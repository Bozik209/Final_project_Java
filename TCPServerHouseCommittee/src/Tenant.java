
public class Tenant extends Person{
	private int apartmentNumber;
	private int monthlyPayment;
	public int getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public int getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(int monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	public Tenant(String firstName, String lastName, String idNumber,String userName,String hashedPassword,int role,int apartmentNumber) {
		super(firstName,lastName,idNumber,userName,hashedPassword,role);
		// TODO Auto-generated constructor stub
		this.apartmentNumber=apartmentNumber;
	}
}
