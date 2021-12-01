package com.gestionecorsi.torino.dao;

import java.sql.Connection;

import com.gestionecorsi.torino.dao.adapter.CorsoDAOAdapter;
import com.gestionecorsi.torino.model.Corso;

public class CorsoDAO extends CorsoDAOAdapter  implements DAOCostants{
	//TODO
	@Override
	public void createFromModel(Connection conn, Corso model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso getModelByNumericalId(Connection conn, long id) {
		// TODO Auto-generated method stub
		return super.getModelByNumericalId(conn, id);
	}

	@Override
	public void removeByModel(Connection conn, Corso model) {
		// TODO Auto-generated method stub
		super.removeByModel(conn, model);
	}

	@Override
	public Corso[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return super.getAll(conn);
	}
	

}
