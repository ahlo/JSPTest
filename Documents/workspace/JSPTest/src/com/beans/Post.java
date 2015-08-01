package com.beans;

import java.sql.Date;

public class Post {
	private static int postId;
	private String postName;
	private String postType;
	private double postPrice;
	private String postDescription;
	private Date creationDate;
	
	public Post() {}

	public static int getPostId() {
		return postId;
	}

//setPostId disabled
//	public static void setPostId(int postId) {
//		Post.postId = postId;
//	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public double getPostPrice() {
		return postPrice;
	}

	public void setPostPrice(double postPrice) {
		this.postPrice = postPrice;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
