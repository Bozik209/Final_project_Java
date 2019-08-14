
public abstract class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String userName;
	private String hashedPassword;
	private int role;
	
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Person(String firstName, String lastName, String idNumber,String userName,String hashedPassword,int role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber=idNumber;
		this.userName = userName;
		this.hashedPassword = hashedPassword;
		this.role=role;
	}

}
