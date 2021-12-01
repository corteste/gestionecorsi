package com.gestionecorsi.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.CorsistaDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.idgen.CorsistaIdGenerator;
import com.gestionecorsi.torino.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	private CorsistaIdGenerator idGen;
	
	
	public CorsistaBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
		idGen = CorsistaIdGenerator.getInstance();
	}
	
	public void create(Corsista corsista) throws SQLException {
		try {
			corsista.setCodCorsista(idGen.getNextId());
			CorsistaDAO.getFactory().createFromModel(conn, corsista);
		}catch (SQLException sql) {
			throw sql;
		}	
	}
	
	public Corsista getById(long id) throws SQLException {
		try {
			return CorsistaDAO.getFactory().getModelByNumericalId(conn, id);
		}catch (SQLException sql) {
			throw sql;
		}
	}
	
	public List<Corsista> getAll() throws SQLException {

		List<Corsista> lc = new ArrayList<Corsista>();
		try {
			lc = CorsistaDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}
		return lc;
	}
	
	public void delete(Corsista cors) throws SQLException {
		try {
			CorsistaDAO.getFactory().removeByModel(conn, cors);
		}catch (SQLException sql) {
			throw new SQLException(sql);
		}
	}

}
