
public class Admin extends Person {
	
	private String Password;
	
	public Admin(String name, String surname, String gender, String date, String address,String Password) {
		super(name, surname, gender, date, address);
		this.Password = Password;
	}

	private boolean Password_Check() {
		return true;
	}

	private void Add_Company(String Company_Name) {
		
	}

	private void Travel_Display() {
		
	}

	
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
