package it.contrader.model;

/**
 * Classe Model di esempio
 *
 */
public class Users {

	/**
	 * I campi che sono attributi di una certa tabella che vogliamo rappresentare
	 * <br>
	 * Possiamo avere n colonne
	 */
	private Integer userId;
	private String username;
	private String password;
	private String usertype;

	/**
	 * Costruttore con parametri
	 */
	public Users(Integer userId, String username, String password, String usertype) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.usertype = usertype;

		
	}

	/**
	 * Metodi setter e getter che ci permettono di recuperare le informazioni del
	 * model o di settarle
	 */
	public Integer getId() {
		return userId;
	}

	public void setId(Integer userId) {
		this.userId = userId;
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
