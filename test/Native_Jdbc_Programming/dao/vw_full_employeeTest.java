package Native_Jdbc_Programming.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import Native_Jdbc_Programming.dao.impl.vw_full_employeeImpl;
import Native_Jdbc_Programming.dto.Department;
import Native_Jdbc_Programming.dto.Employee;
import Native_Jdbc_Programming.dto.Title;

public class vw_full_employeeTest {

	private static vw_full_employeeImpl dao = vw_full_employeeImpl.getInstance();
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectEmployeeByAll() {
	System.out.println("testSelectEmployeeByAll");
	List<Employee> emplist= dao.selectEmployeeByAll();
	for(Employee e : emplist) {
		System.out.println(e);
	}
	}

	@Test
	public void testSelectEmployeeByNo() {
		System.out.println("testSelectEmployeeByNo");
		Employee  selEmp   = new Employee(2106);
		
		Employee emp = dao.selectEmployeeByNo(selEmp);
		System.out.println(emp);
	}

	@Test
	public void testInsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee emp = new Employee(1004,"천사",new Title(5),new Employee(4377), 200000,new Department(1));
		int res = dao.insertEmployee(emp);
		Assert.assertEquals(1,res);
		System.out.println(dao.selectEmployeeByNo(emp));
	}

	@Test
	public void testUpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee empt = new Employee(1004,"천사2", new Title(4),new Employee(1003), 200000,new Department(1));
		int res = dao.updateEmployee(empt);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(empt));
	}

	@Test
	public void testDeleteEmployee() {
		
		System.out.printf("%s()%n", "testDeleteEmployee");
		int res = dao.deleteEmployee(1004);
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

}
