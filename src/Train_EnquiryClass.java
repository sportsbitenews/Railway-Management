import java.sql.Date;

public class Train_EnquiryClass {
	private String From_Station,To_Station,Class_Type,Train_Type;
	private Date Date_Of_Journey;
	Train_EnquiryClass() { }
	Train_EnquiryClass(String From_Station,String To_Station,Date Date_Of_Journey,String Class_Type,String Train_Type){
		this.Date_Of_Journey=Date_Of_Journey;
		this.Class_Type=Class_Type;
		this.From_Station=From_Station;
		this.To_Station=To_Station;
		this.Train_Type=Train_Type;
	}
	public String getFrom_Station() {
		return From_Station;
	}
	public void setFrom_Station(String from_Station) {
		this.From_Station = from_Station;
	}
	public String getTo_Station() {
		return To_Station;
	}
	public void setTo_Station(String to_Station) {
		this.To_Station = to_Station;
	}
	public Date getDate_Of_Journey() {
		return Date_Of_Journey;
	}
	public void setDate_Of_Journey(Date date_Of_Journey) {
		this.Date_Of_Journey = date_Of_Journey;
	}
	public String getClass_Type() {
		return Class_Type;
	}
	public void setClass_Type(String class_type) {
		this.Class_Type = class_type;
	}
	public String getTrain_Type() {
		return Train_Type;
	}
	public void setTrain_Type(String train_Type) {
		this.Train_Type = train_Type;
	}

}