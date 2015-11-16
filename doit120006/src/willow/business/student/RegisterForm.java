package willow.business.student;

import willow.BaseAbstractAction;

/**
 * Filename:  RegisterForm.java
 */
public class RegisterForm extends BaseAbstractAction {
	private static final long serialVersionUID = 6123070770880841647L;

	private String province;
	private String school;
	private String department;
	private String major;
	private String grade;
	private String schoolclass;
	private String degree;
	private String studentId;
	private String name;
	private String sex;
	private String birthday;
	private String mobile;
	private String phone;
	private String email;
	private String qq;
	private String password;
	private String notes;
	private String createdate;
	private String action;


	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getProvince() {
		return replaceSQL(province);
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getSchool() {
		return replaceSQL(school);
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return replaceSQL(department);
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return replaceSQL(major);
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return replaceSQL(grade);
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSchoolclass() {
		return replaceSQL(schoolclass);
	}
	public void setSchoolclass(String schoolclass) {
		this.schoolclass = schoolclass;
	}
	public String getStudentId() {
		return replaceSQL(studentId);
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return replaceSQL(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return replaceSQL(sex);
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getBirthday() {
		return replaceSQL(birthday);
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMobile() {
		return replaceSQL(mobile);
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return replaceSQL(phone);
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return replaceSQL(email);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return replaceSQL(qq);
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNotes() {
		return replaceSQL(notes);
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCreatedate() {
		return createdate;
	}
}
