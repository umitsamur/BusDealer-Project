
public class Company {
	private String Company_Name;
	private String Password;
	public Company(String company_Name,String Password) {
		
		Company_Name = company_Name;
		this.Password = Password;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	
	private void Add_Travel(Travel travel) {
		
	}

	private void Cancel_Travel(Travel travel) {
		
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}




}
