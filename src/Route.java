public class Route	{
	private String Station_ID;
	private String Train_ID;
	private String Arrival_Time;
	private String Departure_Time;
	private int Distance;
	private int Stop_Number;
	public Route(String Station_ID,String Train_ID,String Arrival_Time,String Departure_Time,int Distance,int Stop_Number)
	{
		this.Arrival_Time=Arrival_Time;
		this.Departure_Time=Departure_Time;
		this.Station_ID=Station_ID;
		this.Distance=Distance ;
		this.Stop_Number=Stop_Number;
		this.Train_ID =Train_ID;
	}
	public String getStation_ID() {
		return Station_ID;
	}
	public void setStation_ID(String station_ID) {
		this.Station_ID = station_ID;
	}
	public String getTrain_ID() {
		return Train_ID;
	}
	public void setTrain_ID(String train_ID) {
		Train_ID = train_ID;
	}
	public String getArrival_Time() {
		return Arrival_Time;
	}
	public void setArrival_Time(String arrival_Time) {
		this.Arrival_Time = arrival_Time;
	}
	public String getDeparture_Time() {
		return Departure_Time;
	}
	public void setDeparture_Time(String departure_Time) {
		this.Departure_Time = departure_Time;
	}
	public int getDistance() {
		return Distance;
	}
	public void setDistance(int distance) {
		this.Distance = distance;
	}
	public int getStop_Number() {
		return Stop_Number;
	}
	public void setStop_Number(int stop_Number) {
		this.Stop_Number = stop_Number;
	}
}