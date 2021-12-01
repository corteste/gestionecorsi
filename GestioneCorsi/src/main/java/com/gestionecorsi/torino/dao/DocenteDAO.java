package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gestionecorsi.torino.dao.adapter.DocenteDAOAdapter;
import com.gestionecorsi.torino.model.Docente;

public class DocenteDAO extends DocenteDAOAdapter implements DAOCostants {
	
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
			throw new Exception();
		}
		
		return docente;
	}

}
