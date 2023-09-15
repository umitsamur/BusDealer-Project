
abstract class Person {
	private String Name;
	private String Surname;
	private String Gender;
	private String Date;
	private String Address;
	
	public Person(String name, String surname, String gender, String date, String address) {
		
		Name = name;
		Surname = surname;
		Gender = gender;
		Date = date;
		Address = address;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	



}
