package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;

import com.gestionecorsi.torino.dao.CrudOperation;
import com.gestionecorsi.torino.model.Corso;

public abstract class CorsoDAOAdapter implements CrudOperation<Corso> {

	@Override
	public void createFromModel(Connection conn, Corso model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso getModelByNumericalId(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corso getModelByString(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFromModel(Connection conn, Corso model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
