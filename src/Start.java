import java.sql.SQLException;

class Start
{
    public static void main(String args[])
    {
    	SQLConnection sq = new SQLConnection("root", "vidhan");
    	try
    	{
    		sq.establishConnection();
    		new Database(sq);
    		new Enter_Stations(sq);
    		Input_Train it = new Input_Train();
    		it.getTrains();
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