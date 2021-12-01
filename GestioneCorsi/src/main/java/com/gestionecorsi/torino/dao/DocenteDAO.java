package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.gestionecorsi.torino.dao.adapter.DocenteDAOAdapter;
import com.gestionecorsi.torino.model.Docente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocenteDAO extends DocenteDAOAdapter implements DAOCostants {

	private DocenteDAO() {
	}
	
	public static DocenteDAO getFactory() {
		return new DocenteDAO();
	}
	
	/**
	 * Stefano Cortese
	 */
	
	@Override
	public Docente getModelByString(Connection conn, String codDocente) {
		Docente docente = null;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BY_ID);
			ps.setString(1, codDocente);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				docente = new Docente();

				docente.setCodDocente(rs.getLong(1));
				docente.setNomeDocente(rs.getString(2));
				docente.setCognomeDocente(rs.getString(3));
				docente.setCvDocente(rs.getString(4));
				
			}

		} catch (SQLException sql) {
			sql.getMessage();
		}
		
		return docente;
	}
	
	/**
	 * @return  Dani
	 */

	@Override
	public Docente[] getAll(Connection conn) {
		Docente[] docente = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE_BY_ID); // provisorio
			rs.last();
			docente = new Docente[rs.getRow()];
			rs.isBeforeFirst();
			
		}
		finally{

		}
 		return docente;
	}
	
	
	
}
