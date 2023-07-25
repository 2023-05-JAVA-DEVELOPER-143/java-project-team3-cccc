package user;

/*
 이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(100) 
PASSWORD          VARCHAR2(100) 
NAME              VARCHAR2(100) 
ADDRESS           VARCHAR2(100) 
PHONE             VARCHAR2(50)  
GENDER            VARCHAR2(10) 
 */

public class User {
	private String userId;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String gender;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
		

	public User(String userId, String password, String name, String address, String phone, String gender) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", gender=" + gender + "]";
	}
	
}
