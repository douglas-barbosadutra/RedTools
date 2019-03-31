package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Users;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class UsersDAO {

	/**
	 * Qui possiamo se vogliamo dichiarare delle stringhe rappresentanti le query
	 * che verranno utilizzate dai service, Non è obbligatorio ma è consigliato
	 * usare un ordine e dei nomi significativi per tutte le query. Con GET_ALL
	 * intendiamo recuperare tutte le tuple dal db. Se volessimo creare una query
	 * per l'inserimento, un nome identificativo potrebbe essere INSERT_ESEMPIO
	 */
	private final String GET_ALL = "SELECT * FROM tab_user";
	private final String QUERY_INSERT = "INSERT INTO tab_user (username, password, usertype) values (?,?,?)";
	private final String QUERY_DELETE = "DELETE FROM tab_user WHERE userId=?";
	private final String QUERY_UPDATE = "UPDATE tab_user SET username, password, usertype =(?,?,?) WHERE userId=?";
	private final String QUERY_LOGIN = "SELECT * FROM tab_user WHERE username=? and password=?";

	/**
	 * Il suddetto metodo si occupa interagire con il database e restituire tutte le
	 * tuple al servizio che ha chiamato questo metodo
	 */

	public Users login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		Users utente = null;
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.execute();
			ResultSet resultSet = statement.getResultSet();

			while (resultSet.next()) {
				String name = resultSet.getString("username");
				String pass = resultSet.getString("password");
				int userId = resultSet.getInt("userId");
				String usertype = resultSet.getString("usertype");
				utente = new Users(userId, name, pass, usertype);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}

	public List<Users> getAllUsers() {

		final List<Users> users = new ArrayList<>();
		final Connection connection = ConnectionSingleton.getInstance();

		try {
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(GET_ALL);
			while (resultSet.next()) {
				final Integer id = resultSet.getInt("userId");
				final String username = resultSet.getString("username");
				final String password = resultSet.getString("password");
				final String ruolo = resultSet.getString("usertype");

				users.add(new Users(id, username, password, ruolo));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	// Inserimento

	public boolean insertUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, users.getId());
			preparedStatement.setString(2, users.getUsername());
			preparedStatement.setString(3, users.getPassword());
			preparedStatement.setString(4, users.getRuolo());
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// cancella una chat
	public boolean deleteUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, users.getId());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	// Modifica Chat

	public boolean updateUsers(Users users) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, users.getUsername());
			preparedStatement.setString(2, users.getPassword());
			preparedStatement.setString(3, users.getRuolo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
}