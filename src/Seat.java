
public class Seat {
	private int Number;
	private boolean Is_Single;
	private boolean Is_Empty;
	public Seat(int number, boolean is_Single, boolean is_Empty) {
		
		Number = number;
		Is_Single = is_Single;
		Is_Empty = is_Empty;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public boolean isIs_Single() {
		return Is_Single;
	}
	public void setIs_Single(boolean is_Single) {
		Is_Single = is_Single;
	}
	public boolean isIs_Empty() {
		return Is_Empty;
	}
	public void setIs_Empty(boolean is_Empty) {
		Is_Empty = is_Empty;
	}
	
	
}
