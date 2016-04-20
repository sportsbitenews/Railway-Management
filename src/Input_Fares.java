import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

public class Input_Fares 
{
	private ArrayList<UpdateClass> al;
	public Input_Fares()
	{
		al = new ArrayList<UpdateClass>();
	}
	public ArrayList<UpdateClass> getAl() 
	{
		return al;
	}
	public void setAl(ArrayList<UpdateClass> al) 
	{
		this.al = al;
	}
	public Date addDays(Date now)
    {
		Date date = new Date(now.getTime() + 24*60*60*1000);
		return date;
    }
	public void getFares()
	{
		BufferedReader br;
	    int [] var = new int[7];
	    Date [] date = new Date[11];
	    date[0] = (Date) new Date(new java.util.Date().getTime());
	    for(int i = 1;i <= 10;i++)
	    	date[i] = addDays(date[i - 1]);
	    try
	    {
	    	br = new BufferedReader(new FileReader("data/trains.txt"));
	    	String line = br.readLine();
	    	while(line!=null)
	    	{
	    	    int [][] previ = new int[10][6];
	    		Random randomGenerator = new Random();
	    		int cc=1;
	    		for(int i=0;i<6;i++)
	    		{
	    			int val;
	    			if(i%2==1)
	    			{
	    				previ[0][i]=300*cc;
	    				cc++;
	    			}
	    			else
	    			{
	    				val = randomGenerator.nextInt(2000)+1;
	    				previ[0][i]=val;
	    			}
	    		}
	    		for(int j=0;j<10;j++)
	    		{
	    			String copy=line;
	    			if(copy == null)
	    				continue;
	    			String[] parts = copy.split(" ");
	    			var[0]=Integer.parseInt(parts[0]);
	    			for(int i=0;i<6;i++)
	    			{
	    				var[i+1]=previ[0][i];
	    			}
	    			UpdateClass uc = new UpdateClass();
	    			uc.setTrain_ID(var[0]);
	    			uc.setDate(date[j]);
	    			uc.setFare_Class1(var[1]);
	    			uc.setSeat_Class1(var[2]);
	    			uc.setFare_Class2(var[3]);
	    			uc.setSeat_Class2(var[4]);
	    			uc.setFare_Class3(var[5]);
	    			uc.setSeat_Class3(var[6]);
	    			al.add(uc);
	    	   }
	    	   line=br.readLine();
	    	}
	    	br.close();
	    }
	    catch(FileNotFoundException fe)
	    {
	    	fe.printStackTrace();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
}
