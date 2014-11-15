package my.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import my.dao.EmployeeDao;
import my.entity.Employee;

public class TestEmployeeDao {
	public static void main(String[] args) {
		EmployeeDao dao=new EmployeeDao();
		dao.setAutoRelease(false);
		
		//添加
		Random random=new Random();
		String id=UUID.randomUUID().toString().replace("-","");
		Employee e1=new Employee();
		e1.setEmployeeId(id);
		e1.setName("测试员工");
		e1.setSex("未知");
		e1.setAge((long)random.nextInt(100));
		e1.setCommitTime(new Timestamp(new Date().getTime()));
		long insert=dao.execute("insert into employee(employeeId,name,sex,age,commitTime)values(?,?,?,?,?)",
				e1.getEmployeeId(),
				e1.getName(),
				e1.getSex(),
				e1.getAge(),
				e1.getCommitTime()
			);
		System.out.println(insert);
		
		//删除
//		long delete=dao.execute("delete from employee where age<30");
//		System.out.println(delete);
		
		//修改
//		long update=dao.execute("update employee set age=age+1");
//		System.out.println(update);
		
		//查询总数
//		long count=dao.count("select count(*) from employee where age>0");
//		System.out.println(count);
		
		//查询对象列表
//		List<Employee> list=dao.get("select * from employee limit ?,?",0,15);
//		System.out.println(list.get(0).getName());
		
		//查询单个对象
//		Employee e2=dao.getOne("select * from employee order by age desc limit 0,1");
//		System.out.println(e2.getDescr());
		
		dao.release();
	}
}