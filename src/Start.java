import java.sql.SQLException;

class Start
{
    public static void main(String args[])
    {
    	SQLConnection sq = new SQLConnection();
    	try
    	{
    		sq.establishConnection();
    		new Database(sq);
    		new Enter_Stations(sq);
    		new Enter_Trains(sq);
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
    	new Welcome();
    }
}