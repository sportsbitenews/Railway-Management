import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Enquire_Trains
{
	private List<Train> ll;
	public Enquire_Trains()
	{
		ll = new ArrayList<Train>();
	}
	public List<Train> getLl() {
		return ll;
	}
	public void setLl(List<Train> ll) {
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
	public void findTrains(Train_EnquiryClass tc)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			Enter_Stations es = new Enter_Stations();
			Station source = es.getStation(sq.con, tc.getFrom_Station());
			Station destination = es.getStation(sq.con, tc.getTo_Station());
			String sql = "select t.Train_ID,tr.Train_Name from Route as t,Route as d,Train as tr where t.Train_ID = d.Train_ID and t.Stop_Number < d.Stop_Number and t.Station_ID = '" + source.getStation_ID() + "' and d.Station_ID = '" + destination.getStation_ID() + "' and tr.Train_ID = t.Train_ID;";
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Train t = new Train();
				t.setTrain_No(rs.getInt("Train_ID"));
				t.setTrain_Name(rs.getString("Train_name"));
				ll.add(t);
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
