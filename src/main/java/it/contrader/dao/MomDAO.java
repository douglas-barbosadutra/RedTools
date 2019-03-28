package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.contrader.model.Mom;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;

public class MomDAO {

	
	private final String QUERY_INSERT_MOM = "INSERT INTO tab_mom (id_mom, nome_utente_finale_mom, luogo_mom, data_del_giorno_mom, orario_mom,"
			+ " oggetto_mom, progetto_mom, partecipanti_mom, testo_agenda_mom, testo_azione_mom, testo_note_mom, chiave_est_ut_fin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_UPDATE_MOM = "UPDATE tab_mom SET id_mom=?, nome_utente_finale_mom=?, luogo_mom=?, data_del_giorno_mom=?, orario_mom=?,"
			+ " oggetto_mom=?, progetto_mom=?, partecipanti_mom=?, testo_agenda_mom=?, testo_azione_mom=?, testo_note_mom=?, chiave_est_ut_fin=?) WHERE id_mom=?";

	private final String QUERY_READ_MOM = "SELECT * FROM tab_mom WHERE id_mom=?";
	private final String QUERY_DELETE_MOM = "DELETE FROM tab_mom WHERE id_mom=?";
	

	// Inserimento di una Mom

		public boolean insertMom(Mom mom) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_MOM);
				preparedStatement.setInt(1, mom.getId_mom());
				preparedStatement.setString(2, mom.getNome_utente_finale_mom());
				preparedStatement.setString(3, mom.getLuogo_mom());
				preparedStatement.setString(4, mom.getData_del_giorno_mom());
				preparedStatement.setString(5, mom.getOrario_mom());
				preparedStatement.setString(6, mom.getOggetto_mom());
				preparedStatement.setString(7, mom.getProgetto_mom());
				preparedStatement.setString(8, mom.getPartecipanti_mom());
				preparedStatement.setString(9, mom.getTesto_agenda_mom());
				preparedStatement.setString(10, mom.getTesto_agenda_mom());
				preparedStatement.setString(11, mom.getTesto_agenda_mom());
				preparedStatement.setString(12, mom.getTesto_agenda_mom());
				return true;
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
		
		// Modifica di una Mom

		public boolean updateMom(Mom mom) {
			Connection connection = ConnectionSingleton.getInstance();
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
				preparedStatement.setString(10, mom.getTesto_agenda_mom());
				preparedStatement.setString(11, mom.getTesto_agenda_mom());
				preparedStatement.setString(12, mom.getTesto_agenda_mom());
				preparedStatement.execute();
				return true;
			} catch (SQLException e) {

				GestoreEccezioni.getInstance().gestisciEccezione(e);
				return false;
			}

		}
	
}
