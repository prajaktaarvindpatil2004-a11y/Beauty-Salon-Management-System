package com.employeemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void addEmployee(Employee e) {

		try {
			con = DBConnection.getConnection();

			String sql = "INSERT INTO Employee VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);

			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getDepartment());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getMobile());

			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println("Employee added successfully!!!");
			} else {
				System.out.println("Employee not added!!!");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee e) {

		try {
			con = DBConnection.getConnection();

			String sql = "UPDATE Employee SET name=?, department=?, email=?, mobile=? WHERE id=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, e.getName());
			ps.setString(2, e.getDepartment());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getMobile());
			ps.setInt(5, e.getId());

			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println("Employee updated successfully!!!");
			} else {
				System.out.println("Employee not updated!!!");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int id) {

		try {
			con = DBConnection.getConnection();

			String sql = "DELETE FROM Employee WHERE id=?";
			ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i > 0) {
				System.out.println("Employee deleted successfully!!!");
			} else {
				System.out.println("Employee not found!!!");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Employee searchEmployee(int id) {

		Employee e = null;

		try {
			con = DBConnection.getConnection();

			String sql = "SELECT * FROM Employee WHERE id=?";
			ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				e = new Employee();

				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDepartment(rs.getString("department"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getString("mobile"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	@Override
	public List<Employee> displayAllEmployees() {

		List<Employee> list = new ArrayList<>();

		try {
			con = DBConnection.getConnection();

			String sql = "SELECT * FROM Employee";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				Employee e = new Employee();

				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setDepartment(rs.getString("department"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getString("mobile"));

				list.add(e);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}
}