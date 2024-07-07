package com.ekart.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="wishlist")
public class WishList {
	@Id
	private ObjectId wlId;
	
	private int userId;
	
	private int id;
	private String link;
	private String name;
	private String description;
	private int rating;
	private String category;
	private String price;
	
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishList(int id, String link, String name, String description, int rating, String category, String price) {
		super();
		this.id = id;
		this.link=link;
		this.name = name;
		this.description = description;
		this.rating = rating;
		this.category = category;
		this.price = price;
	}

	public ObjectId getWlId() {
		return wlId;
	}

	public void setWlId(ObjectId wlId) {
		this.wlId = wlId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
	
	
}
