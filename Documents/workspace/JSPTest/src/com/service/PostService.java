package com.service;

import java.util.ArrayList;

import com.beans.Post;
import com.database.Access.PostDAO;

public class PostService {
	
	PostDAO postdao = new PostDAO();
	public int createPostService(Post post) {
		int postId = postdao.createPost(post);
		return postId;
	}
	
	public ArrayList<Post> getAllPosts() throws Exception {
		return postdao.getAllPosts();
	}
	
}
