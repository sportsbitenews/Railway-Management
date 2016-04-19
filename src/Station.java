public class Station {
	private String Station_ID;
	private String Station_Name;
	public Station() { }
	public Station(String Station_ID,String Station_Name)
	{
		this.Station_ID = Station_ID;
		this.Station_Name = Station_Name;	
	}
	public String getStation_ID()
	{
		return Station_ID;
	}
	public void setStation_ID(String station_ID)
	{
		this.Station_ID = station_ID;
	}
	public String getStation_Name()
	{
		return Station_Name;
	}
	public void setStation_Name(String station_Name)
	{
		this.Station_Name = station_Name;
	}
}