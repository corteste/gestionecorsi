package com.gestionecorsi.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.CorsoDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.idgen.CorsoIdGenerator;
import com.gestionecorsi.torino.model.Corso;

public class CorsoBC {
	//TODO
	private Connection conn;
	private CorsoIdGenerator idGen;
	
	public CorsoBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
		idGen = CorsoIdGenerator.getInstance();
	}
	
	
	public void createFromModel(Corso model ) throws SQLException {
		model.setIdCorso(idGen.getNextId());
		CorsoDAO.getFactory().createFromModel(conn, model);
		
	}
	public Corso getModelByNumericalId(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return CorsoDAO.getFactory().getModelByNumericalId(conn, id);
	}
	public void removeByModel(Connection conn , Corso model) throws SQLException {
		CorsoDAO.getFactory().removeByModel(conn, model);
	}

	public List<Corso> getAll() throws SQLException {

		List<Corso> lc = new ArrayList<Corso>();

		lc = CorsoDAO.getFactory().getAll(conn);

		return lc;
	}
	
	public String getPopularCorso() {
		Corso tmp = CorsoDAO.getFactory().getPopularCorso(conn);
		return tmp.getNomeCorso();
	}
	
	public Corso getDataLastCorso() {
		
		return  CorsoDAO.getFactory().getDataLastCorso(conn);
	}
	
	public int getCountCommenti() {
		return CorsoDAO.getFactory().getCountCommenti(conn);
	}
	
	public String getAvailableCorso() {
		return CorsoDAO.getFactory().getAvailableCorso();
	}
}
