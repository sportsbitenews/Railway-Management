import java.sql.*;
public class SQLConnection
{
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/?";
    private static String USER;
    private static String PASS;
    public Connection con = null;
    public SQLConnection(String username, String password)
    {
        USER = username;
        PASS = password;
    }
    public void establishConnection()
    {
    	try
    	{
    		Class.forName(JDBC_DRIVER);
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
    public void chooseDatabase() throws SQLException
    {
    	Statement stmt = null;
    	stmt = (Statement)con.createStatement();
		stmt.executeUpdate("use Railway;");
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