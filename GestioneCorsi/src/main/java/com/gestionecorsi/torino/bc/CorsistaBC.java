package com.gestionecorsi.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.CorsistaDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.idgen.CorsoIdGenerator;
import com.gestionecorsi.torino.model.Corsista;

import architecture.dao.DAOException;
import architecture.dao.UtenteDAO;
import businesscomponent.model.Utente;

public class CorsistaBC {

	private Connection conn;
	private CorsoIdGenerator idGen;

	public CorsistaBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
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
