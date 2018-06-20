package cn.et.springmvc.lesson04.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 声明式验证
 */
public class UserInfo {

	/**
	 * NotNull：属性名 != null
	 * NotEmpty：属性名 != null && !属性名.equals("")
	 */
	@NotEmpty(message="{userError}")
	private String userName; //用户名
	
	@NotEmpty(message="{passwordError}")
	private String password; //密码
	
	@NotEmpty(message="{repasswordError}")
	private String repassword; //重复密码
	
	/**
	 * zhouyuxia@10544.com  ---》 .+@.+\..+
	 */
	@Pattern(message="{emailError}",regexp=".+@.+\\..+")
	private String email; //邮件

	//不能验证	@Digits(integer=1,fraction=150,message="年龄必须在1-159之间")
	@NotEmpty(message="{ageError1}")
	@Min(value=1,message="{ageError2}")
	@Max(value=150,message="{ageError3}")
	private String age; //年龄
	
	@Size(min=11,max=11,message="{phoneError}")
	private String phone; //手机号码
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
