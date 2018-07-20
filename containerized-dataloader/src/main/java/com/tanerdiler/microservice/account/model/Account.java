package com.tanerdiler.microservice.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="accounts")
public class Account
{
	@Id
	private String id;
	private String name;
	private String surname;
	private String email;

	public Account()
	{
	}

	public Account(String id, String name, String surname, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
