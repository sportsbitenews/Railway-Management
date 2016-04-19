import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Input_Station 
{
	private Map<String, Station> hmap;
	public Input_Station() { 
		hmap = new LinkedHashMap<String,Station>();
	}
	public Map<String, Station> getHmap() {
		return hmap;
	}
	public void setHmap(Map<String, Station> hmap) {
		this.hmap = hmap;
	}
	public void getStations()
	{
		Station st;
		try
		{
			FileInputStream fstream = new FileInputStream("data/stations.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String line;
			while((line = br.readLine()) != null)
			{
				int space_index = line.indexOf(" ");
				st = new Station();
				st.setStation_ID(line.substring(0, space_index));
				st.setStation_Name(line.substring(space_index + 1,line.length()));
				hmap.put(line.substring(0,space_index),st);
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
