
public class Committee extends Person{
	private int seniority;
	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public Committee(String firstName, String lastName, String idNumber,String userName,String hashedPassword,int role,int seniority) {
		super(firstName,lastName,idNumber,userName,hashedPassword,role);
		// TODO Auto-generated constructor stub
		this.seniority=seniority;
	}
}
