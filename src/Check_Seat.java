import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Check_Seat 
{
	public Check_Seat() { }
	public boolean check(Reservation_Class RC)
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			String s = "Select * from Status where Train_ID = '" + RC.getTrain_No() +"' and Available_Date = '" + RC.getReservation_Date() + "';";
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery(s);
			String type = RC.getClass_Type();
			int available;
			if(type.equalsIgnoreCase("SL"))
				available = rs.getInt("Seat_Class1");
			else if(type.equalsIgnoreCase("AC"))
				available = rs.getInt("Seat_Class2");
			else
				available = rs.getInt("Seat_Class3");
			if(RC.getNo_of_Passengers() <= available)
				return true;
			else
				return false;
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
}
