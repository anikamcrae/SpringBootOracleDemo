package com.anikamcrae.oracle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anikamcrae.oracle.domain.Person;
import com.anikamcrae.oracle.repository.PersonRepository;

@RestController
@RequestMapping("person")
public class PersonController {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PersonRepository repo;	
	
	// localhost:8080/person/82
	@RequestMapping(value="/{personId}", method = RequestMethod.GET)
	public Person getLineItem(@PathVariable Long personId) {
		log.info("controller getLineItem");
		return repo.getPerson(personId);
	}	
}
