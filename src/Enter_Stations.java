import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Enter_Stations
{
	public Enter_Stations(SQLConnection sq)
	{
		try
		{
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Station;");
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
	public void store(SQLConnection sq)
	{
		Input_Station inps = new Input_Station();
		inps.getStations();
		Map<String,Station> hmap = inps.getHmap();
		try
		{
			String s = "insert into Station values(?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			for(Map.Entry<String,Station> entry: hmap.entrySet())
			{
				Station st = entry.getValue();
				pstmt.setString(1, st.getStation_ID());
		        pstmt.setString(2, st.getStation_Name());
		        pstmt.executeUpdate();
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
	}
}
