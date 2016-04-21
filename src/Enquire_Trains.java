import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public boolean checkTrains(Reservation_Class RC)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			String sql = "select t.Train_ID from Route as t,Route as d where t.Train_ID = d.Train_ID and t.Stop_Number > d.Stop_Number and t.Station_ID = '" + RC.getSource_ID() + "' and d.Station_ID = '" + RC.getDestination_ID() + "' and t.Train_ID = " + RC.getTrain_No() + ";";
			Statement smt = (Statement)sq.con.createStatement();
			System.out.println(sql);
			ResultSet rs = smt.executeQuery(sql);
			if(rs.next())
				return true;
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
		return false;
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
