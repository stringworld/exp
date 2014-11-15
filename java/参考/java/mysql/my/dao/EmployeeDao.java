package my.dao;

import java.util.List;

import my.entity.Employee;

public class EmployeeDao extends BaseDao{
	public Employee getOne(String sql, Object... args) {
		return super.getOne(Employee.class, sql, args);
	}
	public List<Employee> get(String sql, Object... args) {
		return super.get(Employee.class, sql, args);
	}
	public long count(String sql, Object... args) {
		return super.count(sql, args);
	}
	public long execute(String sql, Object... args) {
		return super.execute(sql, args);
	}
}