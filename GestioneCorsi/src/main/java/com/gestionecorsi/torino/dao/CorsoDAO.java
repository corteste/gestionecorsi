package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.adapter.CorsoDAOAdapter;
import com.gestionecorsi.torino.model.Corso;

public class CorsoDAO extends CorsoDAOAdapter  implements DAOCostants{
	
	public static CorsoDAO getFactory() {
		return new CorsoDAO();
	}

	
	
	 private CorsoDAO()  {
	 }
	
	//TODO
	@Override
	public void createFromModel(Connection conn, Corso model) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery(SELECT_CORSI);
		rs.moveToInsertRow();
		rs.updateLong(1, model.getIdCorso());
		rs.updateString(2,model.getNomeCorso());
		rs.updateDate(3,new java.sql.Date(model.getDataInizio().getTime()));
		rs.updateDate(4,new java.sql.Date(model.getDataFine().getTime()));
		rs.updateDouble(5, model.getCostoCorso());
		rs.updateString(6, model.getCommenti());
		rs.updateString(7,model.getAulaCorso());
		rs.updateString(8, model.getCodDocente());
		rs.insertRow();
		rs.moveToCurrentRow();
		conn.commit();
	}

	@Override
	public Corso getModelByNumericalId(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		Corso tmp = new Corso();
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_BY_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		tmp.setIdCorso(rs.getLong(1));
		tmp.setNomeCorso(rs.getString(2));
		tmp.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
		tmp.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
		tmp.setCostoCorso(rs.getDouble(5));
		tmp.setCommenti(rs.getString(6));
		tmp.setAulaCorso(rs.getString(7));
		tmp.setCodDocente(rs.getString(8));
		
		return tmp;
		
	}

	@Override
	public void removeByModel(Connection conn, Corso model) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_IN_CORSO_CORSISTA);
		ps.setLong(1, model.getIdCorso());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			ps = conn.prepareStatement(DELETE_CORSO_FROM_CORSISTA);
			ps.setLong(1, model.getIdCorso());
			rs = ps.executeQuery();
			rs.next();
			rs.deleteRow();
			
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, model.getIdCorso());
			rs = ps.executeQuery();
			rs.next();
			rs.deleteRow();
			
		}
		else
		{
			ps.close();
			rs.close();
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, model.getIdCorso());
			rs = ps.executeQuery();
			rs.next();
			rs.deleteRow();
			
		}
	}

	@Override
	public List<Corso> getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		List<Corso>lc = new ArrayList<Corso>() ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SELECT_CORSI);
		
		for(;rs.next();)
		{
			Corso tmp = new Corso();
			tmp.setIdCorso(rs.getLong(1));
			tmp.setNomeCorso(rs.getString(2));
			tmp.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
			tmp.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
			tmp.setCostoCorso(rs.getDouble(5));
			tmp.setCommenti(rs.getString(6));
			tmp.setAulaCorso(rs.getString(7));
			tmp.setCodDocente(rs.getString(8));
			lc.add(tmp);
		}
		return lc;
	}
	

}
