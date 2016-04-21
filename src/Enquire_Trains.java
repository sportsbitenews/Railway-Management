import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Enquire_Trains
{
	private List ll;
	public Enquire_Trains()
	{
		ll = new LinkedList();
	}
	public List getLl() {
		return ll;
	}
	public void setLl(List ll) {
		this.ll = ll;
	}
	public void findTrains(String Source_ID,String Destination_ID)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			String sql = "select distinct t.Train_ID,t.Station_ID as Source,d.Station_ID as Destination,t.Arrival_Time as Source_Arrival_Time,t.Departure_Time as Source_Departure_Time,d.Arrival_Time as Destination_Arrival_Time,d.Departure_Time as Destination_Departure_Time,t.Distance as Source_Distance,d.Distance as Destination_Distance from Route as t,Route as d where t.Stop_Number < d.Stop_Number and t.Station_ID = ? and d.Station_ID = ?;";
			PreparedStatement psmt = sq.con.prepareStatement(sql);
			psmt.setString(1, Source_ID);
			psmt.setString(2, Destination_ID);
			ResultSet rs = psmt.executeQuery();
			while(rs.next())
			{
				
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sq.closeConnection();
		}
	}
}
