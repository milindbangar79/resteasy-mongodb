/**
 * 
 */
package com.resteasy.mongodb.configuration;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER })
/**
 * @author milind 
 * Custom annotation to be used within ReastEasy for mapping the
 *         application.proerties values to POJO
 */
public @interface Configuration {

	@Nonbinding
	public String value() default "";

}
