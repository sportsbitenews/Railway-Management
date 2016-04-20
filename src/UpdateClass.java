import java.sql.Date;
public class UpdateClass 
{
	private int Train_ID,Fare_Class1,Seat_Class1,Fare_Class2,Seat_Class2,Fare_Class3,Seat_Class3;
	private Date date;
	public UpdateClass() { }
	public UpdateClass(int Fare_Class1,int Train_ID ,int Fare_Class2,int Fare_Class3,int Seat_Class1,int Seat_Class2,int Seat_Class3)
	{
		this.Fare_Class1=Fare_Class1;
		this.Fare_Class2=Fare_Class2;
		this.Fare_Class3=Fare_Class3;
		this.Seat_Class1=Seat_Class1;
		this.Seat_Class2=Seat_Class2;
		this.Seat_Class3=Seat_Class3;
		this.Train_ID=Train_ID;
		
	}
	public int getTrain_ID() {
		return Train_ID;
	}
	public void setTrain_ID(int train_ID) {
		this.Train_ID = train_ID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFare_Class1() {
		return Fare_Class1;
	}
	public void setFare_Class1(int fare_Class1) {
		this.Fare_Class1 = fare_Class1;
	}
	public int getSeat_Class1() {
		return Seat_Class1;
	}
	public void setSeat_Class1(int seat_Class1) {
		this.Seat_Class1 = seat_Class1;
	}
	public int getFare_Class2() {
		return Fare_Class2;
	}
	public void setFare_Class2(int fare_Class2) {
		this.Fare_Class2 = fare_Class2;
	}
	public int getSeat_Class2() {
		return Seat_Class2;
	}
	public void setSeat_Class2(int seat_Class2) {
		this.Seat_Class2 = seat_Class2;
	}
	public int getFare_Class3() {
		return Fare_Class3;
	}
	public void setFare_Class3(int fare_Class3) {
		this.Fare_Class3 = fare_Class3;
	}
	public int getSeat_Class3() {
		return Seat_Class3;
	}
	public void setSeat_Class3(int seat_Class3) {
		this.Seat_Class3 = seat_Class3;
	}
}