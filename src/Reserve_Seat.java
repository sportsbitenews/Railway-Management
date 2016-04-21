import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reserve_Seat 
{
	public Reserve_Seat() { }
	private int find_Seat(SQLConnection sq,Reservation_Class RC)throws SQLException
	{
		String type = RC.getClass_Type();
		String Class;
		if(type.equalsIgnoreCase("SL"))
			Class = "Seat_Class1";
		else if(type.equalsIgnoreCase("AC"))
			Class= "Seat_Class2";
		else
			Class = "Seat_Class3";
		Statement stmt = (Statement)sq.con.createStatement();
		String sql = "select * from Status where Train_ID = " + RC.getTrain_No() + " and Available_Date = '" + RC.getReservation_Date() + "';";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			return rs.getInt(Class);
		}
		return 0;
	}
	private void decrease_Seat(SQLConnection sq,Reservation_Class RC,int seats)throws SQLException
	{
		String type = RC.getClass_Type();
		String Class;
		if(type.equalsIgnoreCase("SL"))
			Class = "Seat_Class1";
		else if(type.equalsIgnoreCase("AC"))
			Class= "Seat_Class2";
		else
			Class = "Seat_Class3";
		Statement stmt = (Statement)sq.con.createStatement();
		seats--;
		String sql = "update Status set " + Class + " = " + seats + " where Train_ID = "  + RC.getTrain_No() + " and Available_Date = '" + RC.getReservation_Date() + "';";
		stmt.executeUpdate(sql);
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
				decrease_Seat(sq, RC, seats);
				pstmt1.setString(3,al.getName());
				pstmt1.setString(5,String.valueOf(al.getGender()));
				pstmt1.setInt(4,al.getAge());
				pstmt1.setInt(6, RC.getTrain_No());
				pstmt1.executeUpdate();
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
