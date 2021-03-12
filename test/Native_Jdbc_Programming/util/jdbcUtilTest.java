package Native_Jdbc_Programming.util;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class jdbcUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {//1
	System.out.printf("%s()%n","setUpBeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {//5
		System.out.printf("%s()%n","tearDownAfterClass");
	}

	@Before
	public void setUp() throws Exception {//2
		System.out.printf("%s()%n","setUp");

	}

	@After
	public void tearDown() throws Exception {//4
		System.out.printf("%s()%n","tearDown");

	}

	@Test
	public void testGetConnection() {//3
		System.out.printf("%s()%n","testGetConnection");
		Connection con =jdbcConn.getConnection();
		System.out.println("con > " + con);
		Assert.assertNotNull(con);
	}

}
