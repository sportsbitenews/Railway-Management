import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Enter_Trains 
{
	public Enter_Trains(SQLConnection sq)
	{
		try
		{
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Train;");
			if(!rs.next())
				store(sq);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void store(SQLConnection sq)throws SQLException
	{
		Input_Train inpt = new Input_Train();
		Station st = new Station();
		inpt.getTrains();
		ArrayList<Train> trains = inpt.getTr();
		String s = "insert into Train values(?,?,?,?,?);";
		String s1 = "insert into Route values(?,?,?,?,?,?);";
		PreparedStatement pstmt,pstmt1;
		pstmt = (PreparedStatement)sq.con.prepareStatement(s);
		pstmt1 = (PreparedStatement)sq.con.prepareStatement(s1);
		for(Train tr : trains)
		{
			for(Route rt : tr.getTrain())
			{
				pstmt1.setInt(1, rt.getTrain_ID());
				pstmt1.setString(2, rt.getStation_ID());
				st.setStation_Name(rt.getStation_Name());
				st.setStation_ID(rt.getStation_ID());
				Enter_Stations est = new Enter_Stations();
				if(!est.check_station(sq, st))
				{
					est.store(sq, st);
				}
				pstmt1.setTime(3, rt.getArrival_Time());
				pstmt1.setTime(4,rt.getDeparture_Time());
				pstmt1.setInt(5, rt.getDistance());
				pstmt1.setInt(6, rt.getStop_Number());
				pstmt1.executeUpdate();
			}
			pstmt.setInt(1, tr.getTrain_No());
			pstmt.setString(2, tr.getTrain_Name());
			pstmt.setString(3, tr.getTrain_Type());
			pstmt.setString(4, tr.getSource_ID());
			pstmt.setString(5, tr.getDestination_ID());
			pstmt.executeUpdate();
		}
	}
}
