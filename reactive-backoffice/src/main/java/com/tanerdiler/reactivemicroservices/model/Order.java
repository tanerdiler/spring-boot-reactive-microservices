package com.tanerdiler.reactivemicroservices.model;

public class Order
{
	private String id;
	private String productId;
	private String accountId;
	private Integer count;
	private Double price;
	private Double discountedPrice;

	public Order()
	{
	}

	public Order(String productId, String accountId, Integer count, Double price, Double discountedPrice)
	{
		this.productId = productId;
		this.accountId = accountId;
		this.count = count;
		this.price = price;
		this.discountedPrice = discountedPrice;
	}

	public Order(String id, String productId, String accountId, Integer count, Double price, Double discountedPrice)
	{
		this.id = id;
		this.productId = productId;
		this.accountId = accountId;
		this.count = count;
		this.price = price;
		this.discountedPrice = discountedPrice;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getProductId()
	{
		return productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Double getDiscountedPrice()
	{
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice)
	{
		this.discountedPrice = discountedPrice;
	}
}
