
public class Bus {
	private Travel travel;
	private Seat[] Seat_Size;
	private Person Driver;
	private static final String Bus_Type[] = {"2+1","2+2"};
	
	
	public Bus(Travel travel) {
		this.travel = travel;
	}
	
	public Bus(Seat[] seat_Size, Person driver) {
		
		Seat_Size = seat_Size;
		Driver = driver;
	}
	
	public Travel getTravel() {
		return travel;
	}
	
	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	public Seat[] getSeat_Size() {
		return Seat_Size;
	}
	
	public void setSeat_Size(Seat[] seat_Size) {
		Seat_Size = seat_Size;
	}

	public Person getDriver() {
		return Driver;
	}

	public void setDriver(Person driver) {
		Driver = driver;
	}
	
	public final static String[] getBusType() {
		return Bus_Type;
	}
	

}
