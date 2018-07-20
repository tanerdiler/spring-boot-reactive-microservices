package com.tanerdiler.reactivemicroservices.model;

public class Account
{
	private String id;
	private String fullname;
	private String email;

	public Account()
	{
	}

	public Account(String id, String fullname, String email)
	{
		this.id = id;
		this.fullname = fullname;
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

	public String getFullname()
	{
		return fullname;
	}

	public void setFullname(String fullname)
	{
		this.fullname = fullname;
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
