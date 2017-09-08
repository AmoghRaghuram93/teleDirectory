package com.thoughtclan.dto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.thoughtclan.entites.Address;
import com.thoughtclan.entites.Person;

@Component
public class PersonConvertor implements Converter<Person, PersonDTO> {

	@Autowired
	private AddressConvertor addressConvertor;
	
	public PersonDTO convert(Person arg0) {
		// TODO Auto-generated method stub
		
		PersonDTO dto=new PersonDTO();
		dto.setId(arg0.getId());
		dto.setName(arg0.getName());
		dto.setAddresses(new ArrayList<AddressDTO>());
		if(arg0.getAddress()!=null) {
			for(Address add:arg0.getAddress()) {
				dto.getAddresses().add(addressConvertor.convert(add));
			}
		}
		
		
		return dto;
	}

}
