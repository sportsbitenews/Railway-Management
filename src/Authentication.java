import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Authentication
{
	private String username, password;
	public Authentication(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	public boolean authenticate()
	{
		SQLConnection sq = new SQLConnection();
		try
		{
			sq.establishConnection();
			Statement stmt = (Statement)sq.con.createStatement();
			String sql = "select * from User where Username = '" + username + "' and Password = '" + password + "';";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
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