package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Mom;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class MomDAO {

	private final String QUERY_ALL_MOM = "SELECT * FROM tab_mom where chiave_est_ut_fin=?";
	
	private final String QUERY_INSERT_MOM = "INSERT INTO tab_mom (nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom, oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom, chiave_est_ut_fin) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ_MOM = "SELECT * FROM tab_mom WHERE id_mom=?";
	
	private final String QUERY_UPDATE_MOM = "UPDATE tab_mom SET id_mom=?, nome_utente_finale_mom=?, luogo_mom=?, data_del_giorno_mom=?, orario_mom=?, oggetto_mom=?, progetto_mom=?, partecipanti_mom=?, testo_agenda_mom=?, testo_azione_mom=?, testo_note_mom=?, chiave_est_ut_fin=?) WHERE id_mom=?";

	private final String QUERY_DELETE_MOM = "DELETE FROM tab_mom WHERE id_mom=?";
	
	public MomDAO() {

	}

	public List<Mom> getAllMom(int idUtenteFinale) {
		List<Mom> momList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_MOM);
			preparedStatement.setInt(1, idUtenteFinale);
			ResultSet resultSet = preparedStatement.executeQuery();
			Mom mom;
			
			while (resultSet.next()) {
				int id_mom = resultSet.getInt("id_mom");
				String nome_utente_finale_mom = resultSet.getString("nome_utente_finale_mom");
				String luogo_mom = resultSet.getString("luogo_mom");
				String data_del_giorno_mom = resultSet.getString("data_del_giorno_mom");
				String orario_mom = resultSet.getString("orario_mom");
				String oggetto_mom = resultSet.getString("oggetto_mom");
				String progetto_mom = resultSet.getString("progetto_mom");
				String partecipanti_mom = resultSet.getString("partecipanti_mom");
				String testo_agenda_mom = resultSet.getString("testo_agenda_mom");
				String testo_azione_mom = resultSet.getString("testo_azione_mom");
				String testo_note_mom = resultSet.getString("testo_note_mom");
				int chiave_est_ut_fin = resultSet.getInt("chiave_est_ut_fin");
				
				mom = new Mom(id_mom, nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom, oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom, chiave_est_ut_fin);
				mom.setId_mom(id_mom);
				momList.add(mom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return momList;
	}
	// Inserimento di una Mom

			public boolean insertMom(Mom mom) {
				Connection connection = ConnectionSingleton.getInstance();
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_MOM);
					preparedStatement.setString(1, mom.getNome_utente_finale_mom());
					preparedStatement.setString(2, mom.getLuogo_mom());
					preparedStatement.setString(3, mom.getData_del_giorno_mom());
					preparedStatement.setString(4, mom.getOrario_mom());
					preparedStatement.setString(5, mom.getOggetto_mom());
					preparedStatement.setString(6, mom.getProgetto_mom());
					preparedStatement.setString(7, mom.getPartecipanti_mom());
					preparedStatement.setString(8, mom.getTesto_agenda_mom());
					preparedStatement.setString(9, mom.getTesto_azione_mom());
					preparedStatement.setString(10, mom.getTesto_note_mom());
					preparedStatement.setInt(11, mom.getChiave_est_ut_fin());
					preparedStatement.execute();
					return true;
				} catch (SQLException e) {
					GestoreEccezioni.getInstance().gestisciEccezione(e);
					return false;
				}
			}
	
			// Lettura di una Mom
	public Mom readMom(int idMom) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ_MOM);
			preparedStatement.setInt(1, idMom);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int id_mom;
			String nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom, oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom; 
			int chiave_est_ut_fin;
			
			id_mom = resultSet.getInt("id_mom");
			nome_utente_finale_mom = resultSet.getString("nome_utente_finale_mom");
			luogo_mom = resultSet.getString("luogo_mom");
			data_del_giorno_mom = resultSet.getString("data_del_giorno_mom");
			orario_mom = resultSet.getString("orario_mom");
			oggetto_mom = resultSet.getString("oggetto_mom");
			progetto_mom = resultSet.getString("progetto_mom");
			partecipanti_mom = resultSet.getString("partecipanti_mom");
			testo_agenda_mom = resultSet.getString("testo_agenda_mom");
			testo_azione_mom = resultSet.getString("testo_azione_mom");
			testo_note_mom = resultSet.getString("testo_note_mom");
			chiave_est_ut_fin = resultSet.getInt("chiave_est_ut_fin");
			Mom mom = new Mom(id_mom, nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom, oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom, chiave_est_ut_fin);
			mom.setId_mom(resultSet.getInt("id_mom"));

			return mom;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}
	
	// Modifica di una Mom

			public boolean updateMom(Mom mom) {
				Connection connection = ConnectionSingleton.getInstance();
				if (mom.getId_mom() == 0)
					return false;
				try {
					
					
					PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_MOM);
					preparedStatement.setInt(1, mom.getId_mom());
					preparedStatement.setString(2, mom.getNome_utente_finale_mom());
					preparedStatement.setString(3, mom.getLuogo_mom());
					preparedStatement.setString(4, mom.getData_del_giorno_mom());
					preparedStatement.setString(5, mom.getOrario_mom());
					preparedStatement.setString(6, mom.getOggetto_mom());
					preparedStatement.setString(7, mom.getProgetto_mom());
					preparedStatement.setString(8, mom.getPartecipanti_mom());
					preparedStatement.setString(9, mom.getTesto_agenda_mom());
					preparedStatement.setString(10, mom.getTesto_azione_mom());
					preparedStatement.setString(11, mom.getTesto_note_mom());
					preparedStatement.setInt(12, mom.getChiave_est_ut_fin());
					int a = preparedStatement.executeUpdate();
					if (a > 0)
						return true;
					else
						return false;

				} catch (SQLException e) {

					GestoreEccezioni.getInstance().gestisciEccezione(e);
					return false;
				}

			}
	
		
		// Cancellazione di una Mom
		
		
		public boolean deleteMom(int id_mom) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_MOM);
				preparedStatement.setInt(1, id_mom);
				int n = preparedStatement.executeUpdate();
				if (n != 0)
					return true;
			} catch (SQLException e) {
			}
			return false;
		}
		
		
	
}
