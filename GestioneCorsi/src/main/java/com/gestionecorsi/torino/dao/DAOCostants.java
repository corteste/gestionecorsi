package com.gestionecorsi.torino.dao;

public interface DAOCostants {
	
	//CORSO
	public static final String SELECT_CORSI = "SELECT CORSO.COD_CORSO,CORSO.NOME_CORSO,CORSO.DATA_INIZIO,CORSO.DATA_FINE,CORSO.COSTO_CORSO,CORSO.COMMENTI_CORSO,CORSO.AULA_CORSO,CORSO.COD_DOCENTE\r\n"
			+ "FROM CORSO";
	public static final String SELECT_CORSO_BY_DOCENTE ="SELECT CORSO.*\r\n"
			+ "FROM CORSO \r\n"
			+ "WHERE COD_DOCENTE = ?";
	public static final String SELECT_CORSI_BY_CORSISTA ="SELECT CORSO.*\r\n"
			+ "FROM CORSO,CORSO_CORSITA\r\n"
			+ "WHERE CORSO.COD_CORSO = CORSO_CORSISTA.COD_CORSO\r\n"
			+ "AND CORSO_CORSISTA.COD_CORSISTA = ?";
	
	public static final String DELETE_CORSO ="DELETE FROM CORSO WHERE COD_CORSO = ? ";
	
	//END
	//CORSISTI
	public static final String SELECT_CORSISTI = "select cod_corsista, nome_corsista, cognome_corsista from corsista";
	public static final String SELECT_CORSISTA_BY_ID = "select * from corsista where cod_corsista = ?";
	public static final String DELETE_CORSISTA = "delete from corsista where cod_corsista = ?";
	//END
	//CORSOCORSISTI
	//END
	//DOCENTE
	//END
	//LOGIN_ADMIN
	//END
	//STATISTICHE
	public static final String SELECT_POPULAR_CORSO ="";
	//END

}
