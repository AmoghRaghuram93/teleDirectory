package com.thoughtclan.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.thoughtclan.entites.Address;

@Component
public class AddressConvertor implements Converter<Address, AddressDTO> {

	public AddressDTO convert(Address arg0) {
		// TODO Auto-generated method stub
		
		AddressDTO dto=new AddressDTO();
		dto.setAddressid(arg0.getAddressid());
		dto.setAddressType(arg0.getAddressType());
		dto.setCity(arg0.getCity());
		dto.setStreet(arg0.getStreet());
		dto.setState(arg0.getState());
		dto.setZipcode(arg0.getZipcode());
		dto.setHouseNo(arg0.getHouseNo());
		dto.setLocality(arg0.getLocality());




		
		
		return dto;
	}

}
