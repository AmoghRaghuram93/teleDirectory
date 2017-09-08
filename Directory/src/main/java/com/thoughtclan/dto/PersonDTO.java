package com.thoughtclan.dto;

import java.util.ArrayList;

public class PersonDTO {
	
	private long id;
	
	private String name;
	

	private ArrayList<AddressDTO> addresses;
	
	
	
	
	public ArrayList<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	

}
