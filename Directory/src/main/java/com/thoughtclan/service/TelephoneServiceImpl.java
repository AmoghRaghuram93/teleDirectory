package com.thoughtclan.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.thoughtclan.entites.Address;
import com.thoughtclan.entites.DirectoryRepositoryPerson;
import com.thoughtclan.entites.DirectoryRepositoryAddress;
//import com.thoughtclan.entites.DirectoryRepositoryAddress;
import com.thoughtclan.entites.Person;

@Service
public class TelephoneServiceImpl implements TelephoneService, InitializingBean, DisposableBean {

	List<Person> persons;
	// static int id ;

	private static final Logger log = LoggerFactory.getLogger(TelephoneServiceImpl.class);

	@Autowired
	private DirectoryRepositoryPerson directoryRepositoryPerson;
	@Autowired
	private DirectoryRepositoryAddress directoryRepositoryAddress;

	// @Autowired
	// TelDirUtils utils;

	public TelephoneServiceImpl() {
		// initialize list of persons
		setData();
	}

	public void initIt() throws Exception {
		System.out.println("Directory Class Called");
	}

	public void cleanUp() throws Exception {
		System.out.println("clean up called");
	}

	private void setData() {
		// Person person1 = new Person();
		// person1.setName("Satheesh");
		// person1.setId(0);
		// person1.setPhoneno(98893676);
		// System.out.println("constructor called");
		persons = new ArrayList<Person>();

	}

	public boolean addPerson(String name, String phoneno,String secondaryphoneno) {
		if (!persons.isEmpty()) {
			for (Person p : persons) {
				if (p.getPhoneno().equals(phoneno)) {
					return false;
				}

			}

		}

		Person person = new Person();
		person.setName(name);
		person.setPhoneno(phoneno);
		person.setSecondaryphoneno("0");
		// persons.add(person);

		List<Address> addresses = new ArrayList();
		Address address=new Address();
		log.info("Adding person");
		
		
		return true;
	}

	
	
	
	public void addAddress(Address address,Person person) {
		// TODO Auto-generated method stub
		test(address,person);
		//demoAddress(address.getAddressid(),address.getHouseNo(),address.getStreet(),address.getLocality(),address.getCity(), address.getState(),address.getZipcode(),address.getAddressType() , demoPerson(person.getName(), person.getPhoneno(), person.getSecondaryphoneno(), person.getAddress()));
	}
	
	
	
	
	
	
	public Person demoPerson(String name, String phoneno, String secondaryphoneno, List<Address> addresses) {

		// save a couple of Employees
		Person p = directoryRepositoryPerson.save(new Person(name, phoneno, secondaryphoneno, addresses));
		// directoryRepository.save(new Person(2, "Jack2", "999", "000"));

		// fetch all Employees
		log.info("Employees found with findAll():");
		log.info("-------------------------------");
		for (Person person : directoryRepositoryPerson.findAll()) {
			log.info(person.toString());
		}
		log.info("");

		// fetch an individual Employee by ID
		Person Employee = directoryRepositoryPerson.findOne(1L);
		log.info("Employee found with findOne(1L):");
		log.info("--------------------------------");
		// log.info(Employee.toString());
		log.info("");

		// fetch Employees by last name
		log.info("Employee found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");

		log.info("");
		return p;
	}

	public TelDirUtils demoAddress(long addressid, int houseNo, String street, String locality, String city, String state,
			String zipcode, String addressType, Person person) {

		// save a couple of Employees
		//person.setAddress(address);
		directoryRepositoryAddress
				.save(new Address(addressid, houseNo, street, locality, city, state, zipcode, addressType, person));
		// directoryRepositoryAddress.save(new Address(222,"nagar","alambagh","lko",
		// "UP","226005","residential",person));

		log.info("DemoAddress called");
		return new TelDirUtils();
	}
public TelDirUtils test(Address address,Person person)
{
	List<Address> list=new ArrayList<Address>();
	list.add(address);
	person.setAddress(list);
	address.setPerson(person);
	directoryRepositoryPerson.save(person);
	directoryRepositoryAddress.save(address);
	return null;
	
}
	public boolean delete(long id) {
		// TODO Auto-generated method stub

//		for (int j = 0; j < persons.size();j++) {
//			Person obj = persons.get(j);
//			long var = obj.getId();
//			if (var == id) {
//				// found, delete.
//				persons.remove(j);
//				directoryRepositoryPerson.delete(obj);
//				return true;
//			} else
//				return false;
//
//		}
		Person person=directoryRepositoryPerson.findOne(id);
		
		List<Address> address=directoryRepositoryAddress.findAllByPersonId(person);
		
		if(person!=null)
		{
			directoryRepositoryAddress.delete(address);
		directoryRepositoryPerson.delete(person);
		return true;
		}
		else
		return false;
	}

	public Person searchId(long id) {
		// TODO Auto-generated method stub
		// for (Person p : persons) {
		// if (p.getId() == id) {
		//
		// return p;
		// }
		// }
		// return null;
		log.info("searching by id");

		return directoryRepositoryPerson.findOne(id);
	}

	public Person searchPhone(String phoneno) {
		// TODO Auto-generated method stub
		// int loc = -1;
		// Person personSearched = new Person();
		// for (Person p : persons) {
		// if (p.getPhoneno().equals( phoneno)) {
		// loc = 0;
		//
		// personSearched.setId(p.getId());
		// personSearched.setName(p.getName());
		// personSearched.setPhoneno(p.getPhoneno());
		//
		// }
		//
		// }
		// if (loc == 0)
		// return personSearched;
		// else
		// return null;
		log.info("searching by phoneno");
		return directoryRepositoryPerson.findByPhoneno(phoneno);

	}

	public List<Person> searchName(String name) {
		// TODO Auto-generated method stub
		// int flag = -1;
		List<Person> personsSearched = new ArrayList<Person>();
		// persons = getAllPersons();
		// for (Person p : persons) {
		// System.out.println(p.getName());
		//
		// if (p.getName().equals(name)) {
		// flag = 0;
		// personsSearched.add(p);
		//
		// }
		// }
		// if (flag == 0) {
		// System.out.println("block");
		// return personsSearched;
		// } else
		// return null;
		log.info("searching by name");
		personsSearched = directoryRepositoryPerson.findByName(name);
		return personsSearched;

	}

	public void display() {
		// TODO Auto-generated method stub
		for (Person p : persons) {
			System.out.println("name=" + p.getName() + "   id=" + p.getId() + "   phone no=" + p.getPhoneno());
		}

	}

	public List<Person> getAllPersons() {
		List<Person> persons = (List<Person>) directoryRepositoryPerson.findAll();
		return persons;

	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy");

	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Init");

	}

	public void edit(Person person) {
		// TODO Auto-generated method stub
		for (Person p : persons) {
			if (p.getId() == person.getId()) {

				p.setName(person.getName());
				p.setPhoneno(person.getPhoneno());
				p.setSecondaryphoneno(person.getSecondaryphoneno());
				demoPerson(person.getName(), person.getPhoneno(), person.getSecondaryphoneno(), person.getAddress());
				break;

			}
		}
	}

	

}
