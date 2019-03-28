package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Dossier;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.utils.GestoreEccezioni;


public class DossierDAO {

	private final String QUERY_ALL = "select * from tab_dossier where id_utente_finale=?";
	private final String QUERY_INSERT = "insert into tab_dossier (periodo_di_imposta, costo_dipendenti_periodo_imposta, fatturato_periodo_di_imposta, numero_totale_dipendenti, costo_complessivo_attivita, costo_personale, id_Utente_Finale, id_progetto ) values (?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from tab_dossier where id=?";
	private final String QUERY_UPDATE = "UPDATE tab_dossier SET periodo_di_imposta=?, costo_dipendenti_periodo_imposta=?, fatturato_periodo_di_imposta=?, numero_totale_dipendenti=?, costo_complessivo_attivita=?, costo_personale=?, idUtenteFinale=?, id_progetto=?  where id=?";
	private final String QUERY_DELETE = "DELETE FROM tab_dossier where id=?";

	public DossierDAO() {

	}

	public List<Dossier> getAllDossier(int idUtenteFinale) {
		List<Dossier> dossierList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			preparedStatement.setInt(1, idUtenteFinale);
			ResultSet resultSet = preparedStatement.executeQuery();
			Dossier dossier;
			while (resultSet.next()) {
				int costoDipendenti = resultSet.getInt("costo_dipendenti_periodo_imposta");
				double fatturatoPeriodoDiImposta = resultSet.getDouble("fatturato_periodo_di_imposta");
				int numeroDipendenti = resultSet.getInt("numero_totale_dipendenti");
				double costiAttivitaRd = resultSet.getDouble("costo_complessivo_attivita");
				double costiPersonaleRd = resultSet.getDouble("costo_personale");
				int idUF = resultSet.getInt("id_utente_finale"); 
				int idProgetto = resultSet.getInt("id_progetto");
				int idDossier = resultSet.getInt("id");
				String periodoDiImposta = resultSet.getString("periodo_di_imposta");
				dossier = new Dossier(periodoDiImposta, costoDipendenti, fatturatoPeriodoDiImposta, numeroDipendenti,
						costiAttivitaRd, costiPersonaleRd, idUF, idProgetto, idDossier);
				dossier.setIdUtenteFinale(idUtenteFinale);
				dossierList.add(dossier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dossierList;
	}

	public boolean insertDossier(Dossier dossier) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, dossier.getPeriodoDiImposta());
			preparedStatement.setDouble(2, dossier.getCostoDipendenti());
			preparedStatement.setDouble(3, dossier.getFatturatoPeriodoDiImposta());
			preparedStatement.setInt(4, dossier.getNumeroDipendenti());
			preparedStatement.setDouble(5, dossier.getCostiAttivitaRd());
			preparedStatement.setDouble(6, dossier.getCostiPersonaleRd());
			preparedStatement.setInt(7, dossier.getIdUtenteFinale());
			preparedStatement.setInt(8, dossier.getIdProgetto());

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Dossier readDossier(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int costoDipendenti;
			double fatturatoPeriodoDiImposta;
			int numeroDipendente;
			double costiAttiviRd;
			double costiPersonaleRd;
			String periodoDiImposta;
			int idProgetto;
			int idUtenteFinale;
			
			idUtenteFinale = resultSet.getInt("id_utente_finale");
			costoDipendenti = resultSet.getInt("costo_dipendenti_periodo_imposta");
			fatturatoPeriodoDiImposta = resultSet.getDouble("fatturato_periodo_di_imposta");
			numeroDipendente = resultSet.getInt("numero_totale_dipendenti");
			costiAttiviRd = resultSet.getDouble("costo_complessivo_attivita");
			costiPersonaleRd = resultSet.getDouble("costo_personale");
			periodoDiImposta = resultSet.getString("periodo_di_imposta");
			idProgetto = resultSet.getInt("id_progetto");
			Dossier dossier = new Dossier(periodoDiImposta, costoDipendenti, fatturatoPeriodoDiImposta,
					numeroDipendente, costiAttiviRd, costiPersonaleRd,idUtenteFinale, idProgetto, id);

			return dossier;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateDossier(Dossier dossierToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (dossierToUpdate.getIdDossier() == 0)
			return false;

		Dossier dossierRead = readDossier(dossierToUpdate.getIdDossier());
		if (!dossierRead.equals(dossierToUpdate)) {
			try {
				// Fill the userToUpdate object

				if (dossierToUpdate.getIdUtenteFinale() == 0) {
					dossierToUpdate.setIdUtenteFinale(dossierRead.getIdUtenteFinale());
				}

				if (dossierToUpdate.getCostoDipendenti() == 0) {
					dossierToUpdate.setCostoDipendenti(dossierRead.getCostoDipendenti());
				}

				if (dossierToUpdate.getFatturatoPeriodoDiImposta() == 0) {
					dossierToUpdate.setFatturatoPeriodoDiImposta(dossierRead.getFatturatoPeriodoDiImposta());
				}

				if (dossierToUpdate.getNumeroDipendenti() == 0) {
					dossierToUpdate.setNumeroDipendenti(dossierRead.getNumeroDipendenti());
				}

				if (dossierToUpdate.getCostiAttivitaRd() == 0) {
					dossierToUpdate.setCostiAttivitaRd(dossierRead.getCostiAttivitaRd());
				}

				if (dossierToUpdate.getCostiPersonaleRd() == 0) {
					dossierToUpdate.setCostiPersonaleRd(dossierRead.getCostiPersonaleRd());
				}

				if (dossierToUpdate.getPeriodoDiImposta() == null || dossierToUpdate.getPeriodoDiImposta().equals("")) {
					dossierToUpdate.setPeriodoDiImposta(dossierRead.getPeriodoDiImposta());
				}

				if (dossierToUpdate.getIdProgetto() == 0) {
					dossierToUpdate.setIdDossier(dossierRead.getIdDossier());
				}

				if (dossierToUpdate.getIdDossier() == 0) {
					dossierToUpdate.setIdDossier(dossierRead.getIdDossier());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, dossierToUpdate.getPeriodoDiImposta());
				preparedStatement.setDouble(2, dossierToUpdate.getCostoDipendenti());
				preparedStatement.setDouble(3, dossierToUpdate.getFatturatoPeriodoDiImposta());
				preparedStatement.setInt(4, dossierToUpdate.getNumeroDipendenti());
				preparedStatement.setDouble(5, dossierToUpdate.getCostiAttivitaRd());
				preparedStatement.setDouble(6, dossierToUpdate.getCostiPersonaleRd());
				preparedStatement.setInt(7, dossierToUpdate.getIdUtenteFinale());
				preparedStatement.setInt(8, dossierToUpdate.getIdProgetto());
				preparedStatement.setInt(9, dossierToUpdate.getIdDossier());

				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean deleteDossier(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			

			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
			
		}
		return false;
	}
}
