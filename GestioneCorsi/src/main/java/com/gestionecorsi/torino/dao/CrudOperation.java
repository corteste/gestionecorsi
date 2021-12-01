package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.model.Docente;

public interface CrudOperation<T> {
	
	public void createFromModel(Connection conn,T model);
	public T getModelByNumericalId(Connection conn,long id);
	public T getModelByString(Connection conn,String id);
	public void removeByModel(Connection conn,T model);
	public List<Docente> getAll(Connection conn) throws SQLException;

}
