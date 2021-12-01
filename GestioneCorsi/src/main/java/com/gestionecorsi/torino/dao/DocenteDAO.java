package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.gestionecorsi.torino.dao.adapter.DocenteDAOAdapter;
import com.gestionecorsi.torino.model.Docente;

public class DocenteDAO extends DocenteDAOAdapter implements DAOCostants {
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
 		return docente;
	}
	
	
	
}
