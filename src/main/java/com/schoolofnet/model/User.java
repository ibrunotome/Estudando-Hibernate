package com.schoolofnet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "created_date")
	private Date createdDate;

	@Column
	private Address address;

	@Column
	@ElementCollection
	private List<Options> options;
	
	@Column
	@ElementCollection
	private List<Computers> computers;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany(mappedBy = "options")
	public List<Options> getOptions() {
		return this.options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public Address getAddress() {
		return this.address;
	}

	@OneToOne(mappedBy = "User")
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="computers")
	public List<Computers> getComputers() {
		return computers;
	}

	public void setComputers(List<Computers> computers) {
		this.computers = computers;
	}

	@Override
	public String toString() {
		return "User [id=]" + id + ", username = " + username + ", name = " + name + ", lastname = " + lastname
				+ ", cratedDate = " + createdDate;
	}
}
