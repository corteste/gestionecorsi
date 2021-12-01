package com.gestionecorsi.torino.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ayoub.architecture.dao.ArticoloDAO;
import com.ayoub.architecture.dao.DAOException;
import com.gestionecorsi.torino.dao.DocenteDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.Docente;

public class DocenteBC {
	private Connection conn;
	
	public DocenteBC() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}
	
	public Docente getByString(String codDocente) {
		Docente docente = null;
		try {
			docente = DocenteDAO.getFactory().getModelByString(conn, codDocente);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return docente;
	}
	
	public List<Docente> getAll(){
		List<Docente> docenti = null;
		try {
			docenti = DocenteDAO.getFactory().
		}
			
		return null;
	}
}
