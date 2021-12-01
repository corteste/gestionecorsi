package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gestionecorsi.torino.dao.adapter.CorsistaDAOAdapter;
import com.gestionecorsi.torino.model.Corsista;

public class CorsistaDAO extends CorsistaDAOAdapter implements DAOCostants{
	
	private CorsistaDAO() {
	}
	
	public static CorsistaDAO getFactory() {
		return new CorsistaDAO();
	}

	@Override
	public void createFromModel(Connection conn, Corsista model){
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.moveToInsertRow();
			rs.updateLong(1, model.getCodCorsista());
			rs.updateString(2, model.getNomeCorsista());
			rs.updateString(3, model.getCognomeCorsista());
			rs.updateString(4, model.getPrecedentiFormativi());
			rs.insertRow();
			conn.commit();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	
}
