import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Enter_Fare 
{
	public Enter_Fare() { }
	public Enter_Fare(SQLConnection sq)
	{
		try
		{
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Status;");
			if(!rs.next())
			{
				Input_Fares inf = new Input_Fares();
				inf.getFares();
				//Map<String,Station> hmap = inps.getHmap();
				//store(sq, hmap);
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
		String s = "insert into Status values(?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
		for(Map.Entry<String,Station> entry: hmap.entrySet())
		{
			 k = entry.getValue();
			pstmt.setInt(1,k.getTrain_ID());
			pstmt.setDate(2, k.getDate());
			pstmt.setInt(3,k.getFare_Class1());
			pstmt.setInt(4,k.getSeat_Class1());
			pstmt.setInt(5,k.getFare_Class2());
			pstmt.setInt(6,k.getSeat_Class2());
			pstmt.setInt(7,k.getFare_Class3());
			pstmt.setInt(8,k.getSeat_Class1());
			pstmt.executeUpdate();
			/*pstmt.setString(1, st.getStation_ID());
		    pstmt.setString(2, st.getStation_Name());*/
		}
	}
}
