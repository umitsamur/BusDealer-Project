
public class Travel {
	private City Source;
	private City Destination;
	private String time;
	private String date;
	private String company;
	private int price;
	private String busType;
	
	public Travel(City source, City destination, String time,String date) {
		
		Source = source;
		Destination = destination;
		this.time = time;
		this.date = date;
	}
	
	public Travel(City source, City destination, String time,String date,String company,int price, String busType) {
		
		Source = source;
		Destination = destination;
		this.time = time;
		this.date = date;
		this.company = company;
		this.price = price;
		this.busType = busType;
	}

	public City getSource() {
		return Source;
	}

	

	public City getDestination() {
		return Destination;
	}

	public void travel_Search() {
		
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSource(City source) {
		Source = source;
	}

	public void setDestination(City destination) {
		Destination = destination;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	
	


}
