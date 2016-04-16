import java.sql.*;
public class Database 
{
	private static void create_Database(Statement st)throws SQLException
	{
		st.executeUpdate("drop database if exists Railway;");
		st.executeUpdate("create database Railway;");
		st.executeUpdate("use Railway;");
	}
	private static void create_admin(Statement st)throws SQLException
	{
		String sql = "create table Admin_table" + "(" + "User_ID varchar(20) not null," + "Password varchar(15) not null," + "primary key(User_ID)" + ");";
		st.executeUpdate(sql);		
	}
	private static void create_user(Statement st)throws SQLException
	{
		String sql = "Create table User_Table" + "(" + "EmailID varchar(30) not null," + "Password varchar(15) not null," + "FullName varchar(30) not null," + "Gender varchar(8) not null," + "Age int not null," + "Mobile varchar(11) not null," + "City varchar(20) not null," + "State varchar(25) not null," + "Security_question varchar(40) not null," + "Security_answer varchar(20) not null" + ")";
		st.executeUpdate(sql);
	}
	public static void main(String[] args)
	{
		Statement stmt = null;
		SQLConnection sq = new SQLConnection("root", "vidhan");
		try
		{
			sq.establishConnection();
			stmt = (Statement)sq.con.createStatement();
			create_Database(stmt);
			create_admin(stmt);
			create_user(stmt);
			System.out.println("done!");
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