package com.tanerdiler.microservice.account.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product
{
	private String id;
	private String name;
	private Double price;

	public Product()
	{
	}

	public Product(String name, Double price)
	{
		this.name = name;
		this.price = price;
	}

	public Product(String id, String name, Double price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}
}
