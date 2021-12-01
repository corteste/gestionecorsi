package test.com.gestionecorsi.torino.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.dao.CorsistaDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.Corsista;

class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		corsista.setCodCorsista(10);
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Bianchi");
		corsista.setPrecedentiFormativi("S");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			conn = DBAccess.getConnection();
			CorsistaDAO.getFactory().removeByModel(conn, corsista);
			corsista = null;
			System.out.println("Eliminato corsista");
			DBAccess.closeConnection();
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
		
	}

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
	}

	@AfterEach
	void tearDown() throws Exception {
		DBAccess.closeConnection();
	}
	
	@Test
	void testGetFactory() {
		CorsistaDAO cDAO = CorsistaDAO.getFactory();
		assertNotNull(cDAO);
	}

	@Test
	void testCreateFromModel() {
		try {
			CorsistaDAO.getFactory().createFromModel(conn, corsista);
			System.out.println("Creato corsista");
		} catch(SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetByNumericalid() {
		fail("Not yet implemented");
	}

}
