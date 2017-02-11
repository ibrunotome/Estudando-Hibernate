package com.schoolofnet.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.schoolofnet.model.Address;
import com.schoolofnet.model.Options;
import com.schoolofnet.model.HibernateSession;
import com.schoolofnet.model.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Session session = HibernateSession.getSessionFactory().openSession();
		
		User user = new User();
		Address address = new Address();
		Options optionsInst = new Options();
		List<Options> options = new ArrayList<Options>();
		
		optionsInst.setName("kdjsf");
		options.add(optionsInst);
		
		address.setNumber(900);
		address.setStreet("Test");
		
		user.setUsername("ibrunotome");
		user.setName("Bruno");
		user.setLastname("Tomé");
		
		address.setUser(user);
		user.setAddress(address);
		user.setOptions(options);
		
		System.out.println("Hello World!");
		System.out.println(session);
		System.out.println(user.getName() + " " + user.getLastname());
		System.out.println(user.getAddress().getStreet());
	}
}
