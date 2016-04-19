import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class Enter_Stations
{
	private BufferedReader br;
	public Enter_Stations(SQLConnection sq)
	{
		try
		{
			Statement stmt = (Statement)sq.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Station;");
			if(rs.next())
				return ;
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			FileInputStream fstream = new FileInputStream("data/stations.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
			String line;
			Map<String, String> hmap = new LinkedHashMap<String,String>();
			while((line = br.readLine()) != null)
			{
				int space_index = line.indexOf(" ");
				hmap.put(line.substring(0,space_index), line.substring(space_index + 1, line.length()));
			}
			String s = "insert into Station values(?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			for(Map.Entry<String,String> entry: hmap.entrySet())
			{
				pstmt.setString(1, (String)entry.getKey());
		        pstmt.setString(2, (String)entry.getValue());
		        pstmt.executeUpdate();
			}
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
			try
			{
				br.close();
			}
			catch(IOException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
