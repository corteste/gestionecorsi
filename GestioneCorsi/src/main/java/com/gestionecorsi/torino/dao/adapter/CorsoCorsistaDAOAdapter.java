package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;

import com.gestionecorsi.torino.dao.CrudOperation;

import com.gestionecorsi.torino.model.CorsoCorsista;

public abstract class CorsoCorsistaDAOAdapter implements CrudOperation<CorsoCorsista> {

	@Override
	public void createFromModel(Connection conn, CorsoCorsista model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista getModelByNumericalId(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista getModelByString(Connection conn, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFromModel(Connection conn, CorsoCorsista model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
