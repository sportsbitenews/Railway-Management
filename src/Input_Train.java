import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input_Train 
{
	private ArrayList<Train> tr;
	public Input_Train()
	{
		tr = new ArrayList<Train>();
	}
	public ArrayList<Train> getTr()
	{
		return tr;
	}
	public void setTr(ArrayList<Train> tr) 
	{
		this.tr = tr;
	}
	public ArrayList<Route> getRoute(String filename,int Train_ID)throws IOException
	{
		ArrayList<Route> route = new ArrayList<Route>();
		FileInputStream fstream = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String line = br.readLine();
		Route rt;
		if(line != null)
			line = br.readLine();
		int c = 1;
		while(line != null)
		{
			rt = new Route();
			String[] parts = line.split("[|]");
			rt.setStation_ID(parts[2].trim());
			rt.setArrival_Time(parts[3].trim());
			rt.setDeparture_Time(parts[4].trim());
			rt.setTrain_ID(Train_ID);
			rt.setStop_Number(c);
			rt.setDistance(Integer.parseInt(parts[6].trim().substring(0,parts[6].trim().indexOf(" KM"))));
			route.add(rt);
			line = br.readLine();
			c++;
 		}
		br.close();
		return route;
	}
	public void getTrains()
	{
		ArrayList<Route> route = new ArrayList<Route>();
		Train trn;
		try
		{
			FileInputStream fstream = new FileInputStream("data/trains.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String line;
			while((line = br.readLine()) != null)
			{
				trn = new Train();
				line = line.trim();
				int index = line.indexOf(" ");
				int lastIndex = line.lastIndexOf(" http");
				trn.setTrain_No(Integer.parseInt(line.substring(0,index)));
				trn.setTrain_Name(line.substring(index + 1,lastIndex));
				String filename = "data/train routes/" + trn.getTrain_Name() + "(";
				if(line.charAt(0) == '0')
				{
					filename += "0";
					if(line.charAt(1) == '0')
						filename += "0";
				}
				filename += trn.getTrain_No() + ").txt";
				route = getRoute(filename, trn.getTrain_No());
				trn.setTrain(route);
				trn.setSource_ID(route.get(0).getStation_ID());
				trn.setDestination_ID(route.get(route.size() - 1).getStation_ID());
				tr.add(trn);
			}
			br.close();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
