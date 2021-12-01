package com.gestionecorsi.torino.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.model.Docente;

public class AdminFacade {
	
	/**
	 * 
	 * @param codDocente
	 * @return
	 * @author Stefano Cortese
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public Docente getDocenteByString(String codDocente) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getByString(codDocente);
	}
	
	/**
	 * 
	 * @return Un array list di tutti i docenti
	 * @author Stefano Cortese
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<Docente> getDocenti() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getAll();
	}
}
