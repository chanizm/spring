package mybatisEx.jdbc;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import mybatisEx.dao.DepartmentDao;
import mybatisEx.dao.DepartmentDaoImpl;
import mybatisEx.dto.Department;

public class DepartmentDoTest {

	static final Logger log = LogManager.getLogger();
	static DepartmentDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		log.trace("setUpBeforeClass()");
		dao = new DepartmentDaoImpl();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.trace("tearDownAfterClass()");
		dao = null;
	}

	@Test
	public void test() {
		List<Department> lists;
		lists = dao.selectDepartmentByAll();
		for (Department d : lists) {
			log.trace(d);
		}
		Assert.assertNotNull(lists);
	}

//	@Test
//	public void testInsertDepartment() {
//		try {
//			Department newDept = new Department(10, "총무", 15);
//			int id = dao.insertDepartment(newDept);
//			log.trace(String.format("A new Department with id %d has been inserted.", id));
//			Assert.assertEquals(1, id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	public void test1SelectDepartmentByAll() throws SQLException {
		List<Department> lists = dao.selectDepartmentByAll();
		for (Department d : lists) {
			log.trace(d);
		}
		Assert.assertNotNull(lists);
	}

	@Test
	public void test2InsertDepartment() throws SQLException {
		Department updateDept = new Department(6, "총무", 15);
		int id = dao.insertDepartment(updateDept);
		log.trace(String.format("A new Department with id %d has been inserted.", id));
		Assert.assertEquals(1, id);
	}

	//@Test
	public void test3UpdateDepartment() throws SQLException {
		Department updateDept = new Department(6, "경영3", 10);
		int rowAffected = dao.updateDepartment(updateDept);
		log.trace(String.format("rowAffected %d", rowAffected));
		Assert.assertEquals(1, rowAffected);
	}

	//@Test
	public void test4DeleteDepartment() throws SQLException {
		Department delDept = new Department();
		delDept.setDeptNo(6);
		int id = dao.deleteDepartment(delDept);
		log.trace(String.format("A delete Department with id %d has been inserted.", id));
		Assert.assertEquals(1, id);
	}

	@Test
	public void test5selectDepartmentByNo() throws SQLException {
		Department selDept = new Department();
		selDept.setDeptNo(1);
		Department department = dao.selectDepartmentByNo(selDept);
		log.trace(String.format("A selected Department %s has been inserted.", department));
		Assert.assertNotNull(department);
	}

}
