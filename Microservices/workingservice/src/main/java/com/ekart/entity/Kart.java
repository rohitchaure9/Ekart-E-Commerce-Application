package com.ekart.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="kart")
public class Kart {
	
	@Id
	private ObjectId kartId;
	
	private int userId;
	
	private int id;
	private String link;
	private String name;
	private String description;
	private int rating;
	private String category;
	private int price;
	
	private int quantity;
	
	private int totalPrice;
	
	public Kart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kart(int id, String link, String name, String description, int rating, String category, int price) {
		super();
		this.id = id;
		this.link=link;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.category = category;
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ObjectId getKartId() {
		return kartId;
	}

	public void setKartId(ObjectId kartId) {
		this.kartId = kartId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
