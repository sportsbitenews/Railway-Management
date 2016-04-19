import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Register_user 
{
	public Register_user() { }
	public void sign_up_user(User u)
	{
		SQLConnection sq = new SQLConnection("root", "vidhan");
		try
		{
			sq.establishConnection();
			String s = "insert into User values(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getPassword());
			pstmt.setString(3,u.getName());
			pstmt.setString(4,String.valueOf(u.getGender()));
			pstmt.setInt(5,u.getAge());
			pstmt.setString(6,u.getMobile());
			pstmt.setString(7,u.getCity());
			pstmt.setString(8,u.getState());
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
