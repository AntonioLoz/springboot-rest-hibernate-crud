package com.antonio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Despues de crear los modelos y sus correpondientes repositorios, tendremos que crear los servicios
 * para definir nuestras operaciones de CRUD. Este servicio lanzará RecordNotFoundException en el
 * caso de que el no exista en la base de datos
 *
 * Está clase es una simple Custom Exception Java. Anotaremos esta clase con @ResponseStatus. Esta
 * anotación le dice a Spring Boot que responda con el estado HTTP específico en caso de que la excepción
 * sea lanzada, HttpStatus.NOT_FOUND.
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Throwable {

    private String exceptionDetail;
    private Object fieldValue;

    public RecordNotFoundException(String exceptionDetail, Object fieldValue) {
        this.exceptionDetail = exceptionDetail;
        this.fieldValue = fieldValue;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
