package com.amit.stream;

public class Product {

	private int productId;
	private String description;
	private double price;
	/**
	 * @param productId
	 * @param description
	 * @param price
	 */
	public Product(int productId, String description, double price) {
		super();
		this.productId = productId;
		this.description = description;
		this.price = price;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", description=" + description + ", price=" + price + "]";
	}
}