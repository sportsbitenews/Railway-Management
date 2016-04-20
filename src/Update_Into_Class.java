import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Update_Into_Class  
{
	public Update_Into_Class() { }
	public void add_into_class(UpdateClass k)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			String s = "insert into Class values(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			pstmt.setInt(1,k.getTrain_ID());
			pstmt.setDate(2, k.getDate());
			pstmt.setInt(3,k.getFare_Class1());
			pstmt.setInt(4,k.getSeat_Class1());
			pstmt.setInt(5,k.getFare_Class2());
			pstmt.setInt(6,k.getSeat_Class2());
			pstmt.setInt(7,k.getFare_Class3());
			pstmt.setInt(8,k.getSeat_Class1());
			pstmt.executeUpdate();	
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