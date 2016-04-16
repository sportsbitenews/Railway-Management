import java.sql.*;
public class SQLConnection
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Railway";
    static String USER;
    static String PASS;
    Connection con = null;
    public SQLConnection(String username, String password)
    {
        USER = username;
        PASS = password;
    }
    public void establishConnection()
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(DB_URL, USER, PASS);
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
    public void closeConnection()
    {
    	try
    	{
    		if(con != null)
    			con.close();
    	}
    	catch(SQLException se)
    	{
    		se.printStackTrace();
    	}
    }
}