package Native_Jdbc_Programming.dao;

import java.util.List;

import Native_Jdbc_Programming.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();

	Department selectDepartmentByNo(Department department);

	int insertDepartment(Department department);

	int updateDepartment(Department department);

	int deleteDepartment(int deptno);

}
