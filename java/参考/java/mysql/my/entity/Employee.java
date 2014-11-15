package my.entity;

import java.util.Date;

public class Employee {
	private String employeeId;
	private String name;
	private String sex;
	private Long age;
	private Date birthdate;
	private String image;
	private String descr;
	private Long sortOrder;
	private Boolean visible;
	private Date commitTime;
	public String getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public Long getAge() {
		return age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public String getImage() {
		return image;
	}
	public String getDescr() {
		return descr;
	}
	public Long getSortOrder() {
		return sortOrder;
	}
	public Boolean getVisible() {
		return visible;
	}
	public Date getCommitTime() {
		return commitTime;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public void setSortOrder(Long sortOrder) {
		this.sortOrder = sortOrder;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}
}