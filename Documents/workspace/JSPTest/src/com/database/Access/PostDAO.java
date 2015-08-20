package com.database.Access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public ArrayList<Post> getAllPosts(){
		Connection con = null;
		ArrayList<Post> posts = new ArrayList<Post>();
		
		cs.setString(1, post.getPostName());
		cs.setString(2, post.getPostType());
		cs.setDouble(3, post.getPostPrice());
		cs.setString(4, post.getPostDescription());
		cs.setDate(5, post.getCreationDate());
		cs.execute();
		

		try{			
			// Get the connection using Connection Manager
			con = ConnectionManager.getConnection();
			PreparedStatement preparedStatement3 = con.prepareStatement("SELECT CHANNEL.CHANNEL_NAME, CHANNEL.CHANNEL_BAND, CHANNEL.CHANNEL_CHARGE_TYPE,"
					+"CHANNEL.CHANNEL_TRANSMISSION_TYPE,CHANNEL.CHANNEL_CHARGE, CHANNEL_BANDS.VIDEO_CARRIER_FREQUENCY, "
					+"CHANNEL_BANDS.AUDIO_CARRIER_FREQUENCY "
					+"FROM CHANNEL "
					+"INNER JOIN CHANNEL_BANDS "
					+"ON CHANNEL.CHANNEL_BAND=CHANNEL_BANDS.CHANNEL_BAND");
			ResultSet rs = preparedStatement3.executeQuery();

			while(rs.next()){
				Post post=new Post();
				String postName = rs.getString("post_name");
				String channelBand = rs.getString("CHANNEL_BAND");
				String channelChargeType = rs.getString("CHANNEL_CHARGE_TYPE");
				String channelTransmissionType = rs.getString("CHANNEL_TRANSMISSION_TYPE");
				Float channelCharge= rs.getFloat("CHANNEL_CHARGE");
				int videoCarrierFrequency = rs.getInt("VIDEO_CARRIER_FREQUENCY");
				int audioCarrierFrequency = rs.getInt("AUDIO_CARRIER_FREQUENCY");

				channel.setChannelName(channelName);
				channel.setChannelBand(channelBand);
				channel.setChannelChargeType(channelChargeType);
				channel.setChannelTransmissionType(channelTransmissionType);
				channel.setChannelCharge(channelCharge);
				channel.setVideoCarrierFrequency(videoCarrierFrequency);
				channel.setAudioCarrierFrequency(audioCarrierFrequency);
				channels.add(channel);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectionManager.closeConnection(con);
		}
		return posts;
	}

}
