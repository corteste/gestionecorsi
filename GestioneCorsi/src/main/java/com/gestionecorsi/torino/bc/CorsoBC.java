package com.gestionecorsi.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.idgen.CorsoIdGenerator;
import com.gestionecorsi.torino.model.Corso;

public class CorsoBC {
	//TODO
	private Connection conn;
	private CorsoIdGenerator idGen;
	
	public CorsoBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}
	
	public void createFromModel(Corso model ) {
		//TODO 
		
	}

}
