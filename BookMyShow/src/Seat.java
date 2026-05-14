import Enums.SeatCategory;

public class Seat {
	int seatId;
	int row;
	SeatCategory seatcategory;
	int price;
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public SeatCategory getSeatcategory() {
		return seatcategory;
	}
	public void setSeatcategory(SeatCategory seatcategory) {
		this.seatcategory = seatcategory;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
