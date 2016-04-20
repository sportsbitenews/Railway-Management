import java.sql.*;
public class SQLConnection
{
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/?";
    private static String USER = "root";
    private static String PASS = "vidhan";
    public Connection con = null;
    public SQLConnection() {}
    /*public SQLConnection(String username, String password)
    {
        USER = username;
        PASS = password;
    }*/
    public void establishConnection()throws SQLException,ClassNotFoundException
    {
    	Class.forName(JDBC_DRIVER);
    	con = DriverManager.getConnection(DB_URL, USER, PASS);
    	Statement stmt = (Statement)con.createStatement();
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