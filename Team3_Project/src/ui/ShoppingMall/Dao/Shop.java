package ShoppingMall.Dao;

public class Shop {	
	private int no;
	private String name;
	private String birthday;
	private String phone;
	private String address;	
	private String id;
	private String password;
	
	public Shop() {
		
	}
	
	public Shop(int no, String name, String birthday, String phone, String address, String id, String password) {
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.id = id;
		this.password = password;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	
}
