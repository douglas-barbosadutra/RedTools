package it.contrader.model;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class BusinessOwner {
	private int userId;
	private String username;
	private String password;
	private String usertype;
	
	public BusinessOwner() {
	}

	public BusinessOwner(String username, String password, String usertype) {
		this.username = username;
		this.username = password;
		this.usertype = usertype;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	 @Override
	 public String toString() {
		 return this.getId() + "\t" + this.getUsername() + "\t" + this.getPassword() + "\t" + this.getUsertype();
	 
	 }
	 
	 public boolean equals(User userCompare) {
		 if (!this.getUsername().equals(userCompare.getUsername())) {
			 return false;
		 }
		 
		 if (!this.getPassword().equals(userCompare.getPassword())) {
				 return false;
	 }
		 if (!this.getUsertype().equals(userCompare.getUsertype())) {
			 return false;
			 
		 }
		 
		 return true;
	 }
		 
}
	 
	 