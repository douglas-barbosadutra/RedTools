package it.contrader.dto;

/**
 * Il DTO (Data transfer object) è un ponte che ci permette di nascondere le
 * informazioni principali del nostro model
 * 
 */
public class UsersDTO {

	private Integer userId;
	private String username;
	private String password;
	private String usertype;
	
	public UsersDTO(Integer id, String username, String password, String usertype) {
		super();
		this.userId = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}

	public Integer getId() {
		return userId;
	}

	public void setId(Integer id) {
		this.userId = id;
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
	public String getRuolo() {
		return usertype;
	}

	public void setRuolo(String usertype) {
		this.usertype = usertype;
	}

}
