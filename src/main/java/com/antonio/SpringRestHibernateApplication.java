package com.antonio;

import com.antonio.controller.StudentController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBootApplicaiton indica a esta clase que es una clase de configuracion.
 *
 * Spring application es usada aqui como bootstrap y autoconfigura nuestra aplicacion. Entonces
 * comienza a embeber el servidor Tomcat. Le tenemos que pasar el nombre de la clase en el
 * argumento de rum, esto indica que este es el componente primario de nuestro proyecto
 *
 * Para que el component scan funcione correctamente y encuentre las dependencias, SpringHibernateApplication
 * debe estár en el top del packagin, de lo contrario tendremos que usar @ComponentScan
 *
 */

@SpringBootApplication
public class SpringRestHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestHibernateApplication.class, args);
	}

}
