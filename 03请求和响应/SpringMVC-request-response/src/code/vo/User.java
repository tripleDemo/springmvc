package code.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
	private Long id;
	private String username;
	private Integer age;
	//@DateTimeFormat(pattern="yyyy-MM-dd")//前台往后台传参转换为Date类型
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//后台往前台响应JSON时-Date类型(timezone解决时差)
	private Date hiredate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", age=" + age + ", hiredate=" + hiredate + "]";
	}
}
