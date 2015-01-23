package com.anikamcrae.oracle.domain;

public class Person {

	private Long personId;
	private String firstName;
	private String lastName;
	
	protected Person() {}
	
	public Person(Long personId, String firstName, String lastName) {
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public Long getPersonId() {
		return personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}	
	
}
