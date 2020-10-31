package com.antonio.repository;

import com.antonio.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Después de crear la entidad estudiante deberemos crear su repositorio para los estudiantes, para lo cual
 * Crearemos una interface que extienda de JpaRepository<T,E> para implementar los metodos
 * custom de nuestro repositorio de estudiantes si este los tuviese. JpaRepository<T,E> define los metodos
 * CRUD basicos para operar con la entidad
 *
 * Spring JPA tiene una implementación por defecto de la interface JpaRepository la cual es SimpleJpaRepository,
 * en la que vienen implementados los metodos basicos del CRUD
 *
 * Vamos a anotar esta interface con la anotacion @Repository. Esta anotación especifica que esta interface
 * va a ser considerada durante el escaneo de componentes de la aplicación
 *
 *
 * JpaRepository tiene varios metodos como save, delete, count, findOne, etc. Esos metodos son implementados
 * por la clase SimpleJpaRepository, asi que no será necesaria la implementación de dichos metodos
 *
 *
 */

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {


}
