import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reserve_Seat 
{
	public Reserve_Seat() { }
	public void Reserve(Reservation_Class RC)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			String s = "insert into User values(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			pstmt.setString(1, RC.getPnr());
			pstmt.setString(2, RC.getSource_ID());
			pstmt.setString(3, RC.getDestination_ID());
			pstmt.setString(4, RC.getClass_Type());
			pstmt.setDate(5, RC.getReservation_Date());
			pstmt.setString(6, RC.getReservation_Status());
			pstmt.setInt(7, RC.getTrain_No());
			pstmt.setString(8, RC.getBooked_By_User());
			pstmt.executeUpdate();
			//PreparedStatement pstmt1 = (PreparedStatement)sq.con.prepareStatement(s);
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
