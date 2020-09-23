package mybatisEx.dao;

import java.sql.SQLException;
import java.util.List;

import mybatisEx.dto.Department;

public interface DepartmentDao {
	List<Department> selectDepartmentByAll();
	public Department selectDepartmentByNo(Department department) throws SQLException;
	int updateDepartment(Department department) throws SQLException;
	int insertDepartment(Department department) throws SQLException;
	int deleteDepartment(Department department) throws SQLException;
}

