package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;

import com.gestionecorsi.torino.dao.CrudOperation;
import com.gestionecorsi.torino.model.Corsista;

public abstract class CorsistaDAOAdapter implements CrudOperation<Corsista> {

	@Override
	public void createFromModel(Connection conn, Corsista model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corsista getModelByNumericalId(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corsista getModelByString(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFromModel(Connection conn, Corsista model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corsista[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
