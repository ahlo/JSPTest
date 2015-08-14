package com.database.Access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Post;
import com.database.Connection.ConnectionManager;

public class PostDAO {

	public int createPost(Post post) {
		Connection con = null;
		PreparedStatement ps = null;
		CallableStatement cs = null;

		int postId = -1;
		try {
			// Get the connection using Connection Manager
			con = ConnectionManager.getConnection();

			// Prepare the stored procedure call
			cs = con.prepareCall("{CALL sp_insert_post(?,?,?,?,?)}");

			cs.setString(1, post.getPostName());
			cs.setString(2, post.getPostType());
			cs.setDouble(3, post.getPostPrice());
			cs.setString(4, post.getPostDescription());
			cs.setDate(5, post.getCreationDate());
			cs.execute();

			System.out.println("Finished calling store procedure.");


			//			//If I want to prepare an output
			//			ps.registerOutParameter(parameterIndex, Types.INTEGER);
			//
			//			ps = con.prepareStatement("INSERT INTO posts (post_name,post_type,post_price,post_description,creation_date) VALUES (?,?,?,?,?)");
			//			ps.setString(1, post.getPostName());
			//			ps.setString(2, post.getPostType());
			//			ps.setDouble(3, post.getPostPrice());
			//			ps.setString(4, post.getPostDescription());
			//			ps.setDate(5, post.getCreationDate());
			//			ps.executeUpdate();
			//
			//get the ID number for the new created post
			ps = con.prepareStatement("SELECT post_id FROM posts ORDER BY post_id DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();
			rs.next();
			postId=rs.getInt(1);

			System.out.println("Post ID#" + postId + " successfully registered.");


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionManager.closeConnection(con);
		}
		return postId;
	}

}
