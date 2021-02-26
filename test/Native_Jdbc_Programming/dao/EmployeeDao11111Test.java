package Native_Jdbc_Programming.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Native_Jdbc_Programming.dao.impl.EmployeeDaoImpl111111;
import Native_Jdbc_Programming.dto.Department;
import Native_Jdbc_Programming.dto.Employee;
import Native_Jdbc_Programming.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDao11111Test {

private static EmployeeDao dao = EmployeeDaoImpl111111.getInstance();
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectEmployeeByAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll");
		List<Employee> emp = dao.selectEmployeeByAll();
		for(Employee e : emp) {
			System.out.println(e);
		}
	}

	@Test
	public void test05SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo");
		Employee emp = new Employee(2106);
		Employee semp = dao.selectEmployeeByNo(emp);
		Assert.assertNotNull(semp);
		System.out.println(semp);
	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n", "testInsertEmployee");
		Employee emp = new Employee(2112,"태연",new Title(5),new Employee(4377),2500000,new Department(1));
		int res = dao.insertEmployee(emp);
		Assert.assertEquals(1,res);
		System.out.println(dao.selectEmployeeByNo(emp));
	}

	@Test
	public void test02UpdateEmployee() {
		System.out.printf("%s()%n", "testUpdateEmployee");
		Employee empt = new Employee(2106, "택연");
		int res = dao.updateEmployee(empt);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectEmployeeByNo(empt));
	}

	@Test
	public void test03DeleteEmployee() {
		System.out.printf("%s()%n", "testDeleteEmployee");
		int res = dao.deleteEmployee(2222);
		Assert.assertEquals(1, res);
		dao.selectEmployeeByAll().stream().forEach(System.out::println);
	}

}
