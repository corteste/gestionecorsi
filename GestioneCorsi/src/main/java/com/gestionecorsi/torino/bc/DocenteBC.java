package com.gestionecorsi.torino.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.DocenteDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.Docente;

/**
 * Marco Placentino
 * 
 * @author Ayoub
 *
 */
public class DocenteBC {
	private Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
		
	}
	
	public Docente getByString(String codDocente) throws SQLException {
		Docente docente = null;
		docente = DocenteDAO.getFactory().getModelByString(conn, codDocente);
		return docente;
	}
	
	
	public List<Docente> getAll() throws SQLException{
		List<Docente> docenti = null;
		try {
			docenti = DocenteDAO.getFactory().getAll(conn);
		} catch(SQLException sql) {
			throw new SQLException();
		}	
		return docenti;
	}
	
	public String getDocenteMostCorsi() throws SQLException {
		String codiceDocente = null;
		try {
			codiceDocente = DocenteDAO.getFactory().getDocenteMostCorsi(conn);
		} catch (SQLException e) {
			throw new SQLException();
		}
		return codiceDocente;
	}
}
