package com.service;

import com.beans.Post;
import com.database.Access.PostDAO;

public class PostService {
	
	PostDAO postdao = new PostDAO();
	public int createPostService(Post post) {
		int postId = postdao.createPost(post);
		return postId;
	}
	
}
