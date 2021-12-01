package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

				docente.setCodDocente(rs.getString(1));
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
	 * Daniel Cobas
	 */
	@Override
	public List<Docente> getAll(Connection conn) throws SQLException {
		List<Docente> ld = new ArrayList<Docente>();
	
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE_BY_ID);
			rs.isBeforeFirst();
			
			for (; rs.next();) {
				Docente d = new Docente();
				d.setCodDocente(rs.getString(5));
				d.setNomeDocente(rs.getString(30));
				d.setCognomeDocente(rs.getString(30));
				d.setCvDocente(rs.getString(100));
				ld.add(d);
			}
			rs.close();
		} catch (SQLException sql) {
			throw new SQLException(); // Manca la classe DAOException
		}
 		return ld;
	}
	
	
	
}
