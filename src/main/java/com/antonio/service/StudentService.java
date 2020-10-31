package com.antonio.service;

import com.antonio.exception.RecordNotFoundException;
import com.antonio.model.StudentEntity;
import com.antonio.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * La capa de servicio es opcional, pero es recomendable.
 * Vamos a usar un servicio para conectar con el repositorio para
 * realizar las operaciones CRUD
 *
 */

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentService() {
        System.out.println("TEST: Student service");
    }

    public List<StudentEntity> getAll() {
        List<StudentEntity> students = studentRepository.findAll();

        // si fuese students.size() <= 0 lanzaría nullpointer exception. Considerar usar optional
        if (students.size() <= 0) {
            students = new ArrayList<StudentEntity>();
        }

        return students;
    }

    public StudentEntity getStudentById(Long id) throws RecordNotFoundException {

        // Con optional nos cubrimos de lanzar un nullPointerException en caso de que
        // el estudianate no exista en la bbdd.
        Optional<StudentEntity> student = studentRepository.findById(id);

        if (!student.isPresent()){
            throw new RecordNotFoundException("No student record exist for id", id);
        }

        return student.get();
    }

    public StudentEntity createOrUpdateStudent(StudentEntity entity) throws RecordNotFoundException{

        StudentEntity entityOut;

        if (entity.getId() != null){
            Optional<StudentEntity> student = studentRepository.findById(entity.getId());

            if (student.isPresent()){
                entityOut = student.get();
                entityOut.setFirstName(entity.getFirstName());
                entityOut.setLastName(entity.getLastName());
                entityOut.setEmail(entity.getEmail());

                entityOut = studentRepository.save(entityOut);
            }
            else {
                entityOut = studentRepository.save(entity);
            }
        }
        // si id == null no debería guardar la entidad
        else {
            entityOut = studentRepository.save(entity);
        }

        return entityOut;
    }

    public void deleteStudentById(Long id) throws RecordNotFoundException {
        Optional<StudentEntity> student = studentRepository.findById(id);

        if(student.isPresent()) {
            studentRepository.deleteById(id);
        }
        else{
            throw new RecordNotFoundException("No student record exist for given id", id);
        }
    }


}
