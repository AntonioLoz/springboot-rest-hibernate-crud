package com.antonio.controller;

import com.antonio.exception.RecordNotFoundException;
import com.antonio.model.StudentEntity;
import com.antonio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    public StudentController() {
        System.out.println("TEST: Controller");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/ping")
    public ResponseEntity<String> getPing(){
        return ResponseEntity.ok("pong");
    }
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = studentService.getAll();

        return new ResponseEntity<List<StudentEntity>>(students, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id) throws RecordNotFoundException {
        StudentEntity student = studentService.getStudentById(id);

        return new ResponseEntity<StudentEntity>(student, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(@RequestBody StudentEntity student) throws RecordNotFoundException {
        StudentEntity updated = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteStudentById(@PathVariable("id") Long id) throws RecordNotFoundException {
        studentService.deleteStudentById(id);
        return HttpStatus.FORBIDDEN;
    }
}
