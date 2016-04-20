import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
public class Enter_Stations
{
	public Enter_Stations() { }
	public Enter_Stations(SQLConnection sq)
	{
		try
		{
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Station;");
			if(!rs.next())
			{
				Input_Station inps = new Input_Station();
				inps.getStations();
				Map<String,Station> hmap = inps.getHmap();
				store(sq, hmap);
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
	private void store(SQLConnection sq, Map<String,Station> hmap)throws SQLException
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
	public void store(SQLConnection sq, Station st)throws SQLException
	{
		String s = "insert into Station values('" + st.getStation_ID() + "','" + st.getStation_Name() + "');";
		Statement stmt = (Statement)sq.con.createStatement();
		stmt.executeUpdate(s);
	}
	public boolean check_station(SQLConnection sq,Station st)throws SQLException
	{
		String s = "select * from Station where Station_ID = '" + st.getStation_ID() + "' and Station_Name = '" + st.getStation_Name() + "';";
		Statement stmt = (Statement)sq.con.createStatement();
		ResultSet rs = stmt.executeQuery(s);
		if(rs.next())
			return true;
		else
			return false;
	}
}
