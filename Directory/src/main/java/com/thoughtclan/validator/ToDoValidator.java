package com.thoughtclan.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.thoughtclan.entites.Person;

public class ToDoValidator implements Validator {


	public boolean supports(Class<?> clazz) {
		if(clazz.equals(Person.class)) {
			return true;
		}
		return false;
	}

	public void validate(Person person, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "title.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "person.name", "person.name.length>3");
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}
}
