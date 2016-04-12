import java.sql.*;
class SQLConnection
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";
    static final String USER;
    static final String PASS;
    Connection con = null;
    public SQLConnection(String username, String password)
    {
        USER = username;
        PASS = password;
    }
    public establishConnection()
    {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    public closeConnection()
    {
        if(con != null)
            con.close();
    }
}
