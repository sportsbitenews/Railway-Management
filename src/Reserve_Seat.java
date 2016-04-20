import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reserve_Seat 
{
	public Reserve_Seat() { }
	public int find_Seat(SQLConnection sq,Reservation_Class RC)throws SQLException
	{
		
	}
	public void decrease_Seat(SQLConnection sq,Reservation_Class RC)throws SQLException
	{
		
	}
	public void Reserve(Reservation_Class RC)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			String s = "insert into Reservation values(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			pstmt.setString(1, RC.getPnr());
			pstmt.setString(2, RC.getSource_ID());
			pstmt.setString(3, RC.getDestination_ID());
			pstmt.setString(4, RC.getClass_Type());
			pstmt.setDate(5, (Date) RC.getReservation_Date());
			pstmt.setString(6, RC.getReservation_Status());
			pstmt.setInt(7, RC.getTrain_No());
			pstmt.setString(8, RC.getBooked_By_User());
			pstmt.executeUpdate();
			String s1 = "insert into Passenger values(?,?,?,?,?,?);";
			PreparedStatement pstmt1 = (PreparedStatement)sq.con.prepareStatement(s1);
			for(Passenger al : RC.getPassenger_array())
			{
				pstmt1.setString(1, RC.getPnr());
				int seats = find_Seat(sq, RC);
				pstmt1.setInt(2, seats);
				decrease_Seat(sq, RC);
				pstmt1.setString(3,al.getName());
				pstmt1.setString(5,String.valueOf(al.getGender()));
				pstmt1.setInt(4,al.getAge());
				pstmt.setInt(6, RC.getTrain_No());
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
