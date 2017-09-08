package com.thoughtclan.service;
import com.thoughtclan.entites.*;
import java.util.*;
public interface TelephoneService {

	public abstract boolean addPerson(String name, String phoneno,String secondaryphoneno);
	
	public abstract void addAddress(Address address,Person person);


	public abstract boolean delete(long id);

	public abstract void edit(Person person);

	public abstract Person searchId(long id);

	public abstract void display();
	
	public abstract List<Person> getAllPersons();
	
	public abstract List<Person> searchName(String name);
	
	public abstract Person searchPhone(String phoneno);
}
