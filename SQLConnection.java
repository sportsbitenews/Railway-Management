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
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    public void closeConnection()
    {
        if(con != null)
            con.close();
    }
}
