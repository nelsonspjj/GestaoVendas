package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.login.model.Login;
import br.com.login.dao.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

	private Connection conn;
	public UserDao() {
		
		conn= DBUtil.getConnection();//connect to database
	}
	//Validates login with user input
	public boolean validateLogin(String em,String pw)
	{
		boolean canLogin=false;
		
		//Search database for email and password and return true if found
		try
		{
			PreparedStatement ps = conn
					.prepareStatement("select * from TheUser where email=? and psword=?");
			ps.setString(1, em);
			ps.setString(2, pw);
			
			ResultSet rs = ps.executeQuery();
			canLogin= rs.next(); //true if found else false
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return canLogin;
	}
	
	//returns user info from specified email for session
	public Login userSession(String em)
	{
		Login user=new Login(); //create new user object
		try
		{
			PreparedStatement ps = conn
					.prepareStatement("select * from TheUser where email=?");//search database for email
			ps.setString(1, em);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPsword(rs.getString("psword"));
				user.setEmail(rs.getString("email"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	
	//Creates a new user with input data
	public void createUser(Login user)
	{
		try
		{
			PreparedStatement ps = conn
					.prepareStatement("insert into TheUser(username,psword,email) values (?,?,?)");//add user to database
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPsword());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	//update user with input data
	public void editAccount(Login user)
	{
		try
		{
			PreparedStatement ps = conn
					.prepareStatement("update TheUser set username=?, psword=?" + " where userID=?"); //find user with id and update info
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPsword());
			ps.setInt(3, user.getUserID());
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//Remove user from database with specified id
	public void deleteAccount(int userid)
	{
		try
		{
			PreparedStatement ps = conn
					.prepareStatement("delete from TheUser where userID=?");
			ps.setInt(1, userid);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//returns a list of all users
	public List<Login> listUsers()
	{
		List<Login> userList = new ArrayList<Login>();
		try
		{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from TheUser");
			while (rs.next())
			{
				Login user = new Login();
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPsword(rs.getString("psword"));
				user.setEmail(rs.getString("email"));
				userList.add(user);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return userList;
	}
	
	//returns user info from specified id
	public Login getUserByID(int userid)
	{
		Login user = new Login();
		try
		{
			PreparedStatement ps = conn
					.prepareStatement("select * from TheUser where userID= ?");
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user.setUserID(rs.getInt("userID"));
				user.setUsername(rs.getString("username"));
				user.setPsword(rs.getString("psword"));
				user.setEmail(rs.getString("email"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;
	}
}
