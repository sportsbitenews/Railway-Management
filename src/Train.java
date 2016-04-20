import java.util.ArrayList;

public class Train {
	private int Train_No;
	private String Train_Type;
	private String Train_Name;
	private String Source_ID,Destination_ID;
	private ArrayList<Route> train;
	public Train() 
	{ 
		train = new ArrayList<Route>();
	}
	public Train(int Train_no,String Train_type,String Train_Name,String Source_ID,String Destination_ID,ArrayList<Route> train)
	{
		this.Train_No = Train_no;
		this.Train_Type = Train_type;
		this.Train_Name = Train_Name;
		this.Source_ID = Source_ID;
		this.Destination_ID = Destination_ID;
		this.train = train;
	}
	public int getTrain_No() {
		return Train_No;
	}
	public void setTrain_No(int train_No) {
		this.Train_No = train_No;
	}
	public String getTrain_Type() {
		return Train_Type;
	}
	public void setTrain_Type(String train_Type) {
		this.Train_Type = train_Type;
	}
	public String getTrain_Name() {
		return Train_Name;
	}
	public void setTrain_Name(String train_name) {
		this.Train_Name = train_name;
	}
	public String getSource_ID() {
		return Source_ID;
	}
	public void setSource_ID(String source_ID) {
		this.Source_ID = source_ID;
	}
	public String getDestination_ID() {
		return Destination_ID;
	}
	public void setDestination_ID(String destination_ID) {
		this.Destination_ID = destination_ID;
	}
	public ArrayList<Route> getTrain() {
		return train;
	}
	public void setTrain(ArrayList<Route> train) {
		this.train = train;
	}
}