package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Post;
import com.service.PostService;

/**
 * Servlet implementation class CreatePostController
 */
@WebServlet("/CreatePostController")
public class CreatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		try {
		Post post = new Post();
		PostService postservice = new PostService();
		String postName = request.getParameter("PostName");
		String postType = request.getParameter("PostType");
		double postPrice = Double.parseDouble(request.getParameter("PostPrice"));
		String postDescription = request.getParameter("PostDescription");
		
		post.setPostName(postName);
		post.setPostType(postType);
		post.setPostPrice(postPrice);
		post.setPostDescription(postDescription);
		postservice.createPostService(post);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			request.getRequestDispatcher("viewallpost.jsp");
			response.getWriter().append("ERROR 404: WHAT ARE YOU DOING?");
		}
	}
}
