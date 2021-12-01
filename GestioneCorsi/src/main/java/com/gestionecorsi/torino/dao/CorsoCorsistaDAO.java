package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gestionecorsi.torino.dao.adapter.CorsoCorsistaDAOAdapter;
import com.gestionecorsi.torino.model.CorsoCorsista;

/**
 * @author Luca Pianta
 *
 */
public class CorsoCorsistaDAO extends CorsoCorsistaDAOAdapter implements DAOCostants {
	private ResultSet rs;
	private Connection conn;
	private Statement stmt;
	
	private CorsoCorsistaDAO() {
	}
	
	
	public CorsoCorsistaDAO getFactory(){
		return new CorsoCorsistaDAO();
	}

	@Override
	public void createFromModel(Connection conn, CorsoCorsista model) {
		try {
			conn.createStatement();
			stmt.execute(SELECT__CORSO_CORSISTA);
			rs.moveToInsertRow();
			rs.updateLong(1, model.getCodCorsista());
			rs.updateLong(2, model.getCodCorso());
			rs.insertRow();
			rs.moveToCurrentRow();
			conn.commit();	
		}catch (SQLException sql) {
			sql.getMessage();
		}	
		
	}
}
