package mybatisEx.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mybatisEx.dto.Department;
import mybatisEx.jdbc.MySQLJdbcUtil;
public class DepartmentDaoImpl implements DepartmentDao {
	final Logger LOG = LogManager.getLogger();

	@Override
	public List<Department> selectDepartmentByAll() {
		List<Department> lists = new ArrayList<>();
		String sql = "SELECT deptno, deptname, floor from department";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = MySQLJdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			LOG.trace(pstmt);
			rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				lists.add(getDepartment(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}

	private Department getDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("deptno"), rs.getString("deptname"), rs.getInt("floor"));
	}

	@Override
	public Department selectDepartmentByNo(Department department) throws SQLException {
		Department dept = null;
		String sql = "SELECT deptno, deptname, floor from department where deptno=?";
		try (Connection conn = MySQLJdbcUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					dept = getDepartment(rs);
				}
			}
		}
		return dept;
	}
	@Override
	public int insertDepartment(Department department) throws SQLException {
		String sql = "insert into department values(?, ?, ?)";
		int rowAffected = 0;
		try (Connection conn = MySQLJdbcUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			pstmt.setInt(3, department.getFloor());
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int deleteDepartment(Department department) throws SQLException {
		String sql = "delete from department where deptno=?";
		int rowAffected = 0;
		try (Connection conn = MySQLJdbcUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, department.getDeptNo());
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}

	@Override
	public int updateDepartment(Department department) throws SQLException {
		String sql = "update department set deptname=?, floor=? where deptno=?";
		int rowAffected = 0;
		try (Connection conn = MySQLJdbcUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, department.getDeptName());
			pstmt.setInt(2, department.getFloor());
			pstmt.setInt(3, department.getDeptNo());
			rowAffected = pstmt.executeUpdate();
		}
		return rowAffected;
	}
}
