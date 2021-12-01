package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public Corsista getByNumericalld(Connection conn,long codCorsista) {
		  Corsista corsista=null;
		  PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BY_ID);
			ps.setLong(1,codCorsista);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				corsista=new Corsista();
				corsista.setCodCorsista(rs.getInt(1));
				corsista.setNomeCorsista(rs.getString(2));
				corsista.setCognomeCorsista(rs.getString(3));
				corsista.setPrecedentiFormativi(rs.getString(4));	
			}	
		}catch(SQLException exc) {
			exc.printStackTrace();
		}
		return corsista;
	}
	
	
	
	
}
