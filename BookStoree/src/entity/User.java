package entity;

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userNickname;
	private Sex sex;
	private String userAddress;
	private String userPhone;
	private String userRemark;

	public User() {
	}

	public User(String userName, String userPassword, String userEmail,
			Sex sex) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.sex = sex;
	}

	public User(String userName, String userPassword, String userEmail,
			String userNickname, Sex sex, String userAddress,
			String userPhone, String userRemark) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.sex = sex;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userRemark = userRemark;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return this.userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserRemark() {
		return this.userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

}