package com.database.Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Post;
import com.database.Connection.ConnectionManager;

public class PostDAO {

	public int createPost(Post post) {
		Connection con = null;
		PreparedStatement ps = null;
		int postId = -1;
		try {
			con = ConnectionManager.getConnection();

			ps = con.prepareStatement("INSERT into POST (post_name,post_type,post_price,post_description,creation_date) VALUES (?,?,?,?,?)");
			ps.setString(1, post.getPostName());
			ps.setString(2, post.getPostType());
			ps.setDouble(3, post.getPostPrice());
			ps.setString(4, post.getPostDescription());
			ps.setDate(5, post.getCreationDate());
			ps.executeUpdate();

			//get the ID number for the new created post
			//			ps = con.prepareStatement("SELECT post_id_sequence.CURRVAL from DUAL");
			//			ResultSet rs = ps.executeQuery();
			//			rs.next();
			//			postId=rs.getInt(1);

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
