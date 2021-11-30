package com.gestionecorsi.torino.dao;

import java.sql.Connection;

public interface CrudOperation<T> {
	
	public void createFromModel(Connection conn,T model);
	public T getModelByNumericalId(Connection conn,long id);
	public T getModelByString(Connection conn,String id);
	public void removeByModel(Connection conn,T model);
	public T[] getAll(Connection conn);

}
