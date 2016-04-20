
public class Passenger extends Person
{
	private int Seat;
	int Train_ID;
	public Passenger(){ }
	public Passenger(int Seat,String name,int age,char gender,int train_id)
	{
		super(name,age,gender);
		this.Seat = Seat;
		this.Train_ID = train_id;
	}
	public String getName()
	{
		return super.getName();
	}
	public void setName(String name)
	{
		super.setName(name);
	}
	public int getAge()
	{
		return super.getAge();
	}
	public void setAge(int age)
	{
		super.setAge(age);
	}
	public char getGender()
	{
		return super.getGender();
	}
	public void setGender(char gender)
	{
		super.setGender(gender);
	}
	public int getSeat() {
		return Seat;
	}
	public void setSeat(int seat) {
		this.Seat = seat;
	}
	public int getTrain_ID() {
		return Train_ID;
	}
	public void setTrain_ID(int train_ID) {
		this.Train_ID = train_ID;
	}
}
