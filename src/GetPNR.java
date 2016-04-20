import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

public class GetPNR
{
	private Set<String> st;
	public GetPNR()
	{
		st = new LinkedHashSet();;
	}
	public Set getSet()
	{
		return st;
	}
	public void setSet(Set st)
	{
		this.st = st;
	}
	private SQLConnection connect()throws SQLException, ClassNotFoundException
	{
		SQLConnection sq = new SQLConnection();
		sq.establishConnection();
		return sq;
	}
	private void findAll(Statement stmt) throws SQLException
	{
		String sql = "select PNR from Reservation;";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			st.add(rs.getString("PNR"));
		}
	}
	public void compute()
	{
		SQLConnection sq = null;
		try
		{
			sq = connect();
			Statement stmt = (Statement)sq.con.createStatement();
			findAll(stmt);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
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
