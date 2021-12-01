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
	public static final String SELECT_CORSO_BY_ID = "SELECT * FROM CORSO WHERE COD_CORSO = ?";
	public static final String SELECT_CORSO_IN_CORSO_CORSISTA = "SELECT * FROM CORSO_CORSISTA WHERE COD_CORSO = ?";
	public static final String DELETE_CORSO ="DELETE FROM CORSO WHERE COD_CORSO = ? ";
	public static final String DELETE_CORSO_FROM_CORSISTA = "DELETE FROM CORSO_CORSISTA WHERE COD_CORSO =? ";
	//END
	//CORSISTI

	public static final String SELECT_CORSISTI = "select cod_corsista, nome_corsista, cognome_corsista, precedenti_formativi from corsista";
	public static final String SELECT_CORSISTA_BY_ID = "select cod_corsista, nome_corsista, cognome_corsista, precedenti_informativi from corsista where cod_corsista = ?";
	public static final String DELETE_CORSISTA = "delete from corsista where cod_corsista = ?";

	//END
	//CORSOCORSISTI
	public static final String SELECT__CORSO_CORSISTA = "select cod_corso, cod_corsista from corso_corsista";
	//END
	//DOCENTE
	public static final String SELECT_DOCENTE_BY_ID = "SELECT cod_docente, nome_docente, cognome_docente, cv_docente FROM Docente WHERE cod_docente = ?";
	//END
	//LOGIN_ADMIN
	//END
	//STATISTICHE
	public static final String SELECT_POPULAR_CORSO ="SELECT NOME_CORSO FROM CORSO,CORSO_POPOLARE WHERE CORSO_POPOLARE.COD_CORSO =CORSO.COD_CORSO";
	public static final String SELECT_CORSO_LAST_DATE="SELECT CORSO.*\r\n"
			+ "FROM CORSO\r\n"
			+ "WHERE DATA_INIZIO = (SELECT MAX(DATA_INIZIO)\r\n"
			+ "                     FROM CORSO)";
	public static final String SELECT_COMMENTI_CORSO ="SELECT NUMERO_COMMENTI\r\n"
			+ "FROM CORSO_N_COMMENTI\r\n"
			+ "WHERE COD_CORSO = ?";
	public static final String SELECT_GET_AVAILABLE_CORSO  ="SELECT CORSO.* ,POSTI_DISPONIBILI\r\n"
			+ "FROM CORSO,CORSO_POSTI_DISPONIBILI\r\n"
			+ "WHERE CORSO.COD_CORSO = CORSO_POSTI_DISPONIBILI.COD_CORSO\r\n";
		
	//END
	
	//SEQUENZE
	public static final String SELECT_ID_CORSO = "SELECT CORSO_SEQ.NEXTVAL FROM DUAL";
	public static final String SELECT_ID_CORSISTA = "SELECT CORSISTA_SEQ.NEXTVAL FROM DUAL";
	//END

}
