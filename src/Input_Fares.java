import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	public void getFares()
	{
		UpdateClass uc = new UpdateClass();
	    try 
	    {
	    	BufferedReader br = new BufferedReader(new FileReader("data/trains.txt"));
	    	String line = br.readLine();
	    	while(line!=null)
	    	{
	    		int [][] previ = new int[10][6];
	    		Random randomGenerator = new Random();
	    		for(int i=0;i<6;i++)
	    		{
	    			int val;
	    			if(i%2==1)
	    				previ[0][i]=256;
	    			else
	    			{
	    				val = randomGenerator.nextInt(2000)+1;
	    				previ[0][i]=val;
	    			}
	    	   }
	    	
	    	   for(int j=0;j<10;j++)
	    	   {
	        	   	String copy=line;
		   			String parts[] = copy.split(" ");
		   			
		   			String sq1 = "Insert into Class values("+parts[0];
		   		
		   			for(int i=0;i<6;i++)
		   			{
		   				int val;
		   				if(i%2==1)
		   				{
		   					if(j==0)
		   						sq1+=",256";
		   					else
		   					{
		   						val=randomGenerator.nextInt(previ[j-1][i])+1;
		   						sq1+=","+val;
		   						previ[j][i]=val;
		   					}
		   				}
		   				else
		   				{
		   					sq1+=","+previ[j-1][i];
		   					previ[j][i]=previ[j-1][i];
		   				}
		   			}
		   			sq1+=")";
	    	   }
	    	}
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
