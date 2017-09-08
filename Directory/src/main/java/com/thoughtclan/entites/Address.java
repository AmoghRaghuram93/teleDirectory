package com.thoughtclan.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	private int houseNo;
	private String street;
	private String locality;
	private String city;
	private String state;
	private String zipcode;
	private String addressType;
	@ManyToOne(targetEntity = Person.class)
	private Person person;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressid;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + ", locality=" + locality + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", addressType=" + addressType + ", person=" + person
				+ ", addressid=" + addressid + "]";
	}

	public Address(Long addressid,int houseNo, String street, String locality, String city, String state, String zipcode,
			String addressType, Person person) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.addressType = addressType;
		this.person = person;
		this.addressid = addressid;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Address()
	{
		
	}

	// @Override
	// public String toString() {
	// return "Address [employee=" + person.getId() + ", project=" +
	// person.getPhoneno() + "]";
	// }
	
			
}
