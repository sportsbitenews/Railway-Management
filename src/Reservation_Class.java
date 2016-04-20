import java.util.*;
public class Reservation_Class 
{
    private String Pnr;
    private int No_of_Passengers,Train_No;
    private String Source_ID,Class_Type,Destination_ID,Booked_By_User,Resrevation_Status;
    private String Reservation_Status,Source_name,Destination_name;
    private Date Reservation_Date;
    ArrayList<Passenger> Passenger_array=new ArrayList<Passenger>();
    public void Reservation()
    {
		this.Train_No = 0;
		this.No_of_Passengers = 0;
    }
    public void Reservation(int Train_no,String pnr,int No_of_Passengers,String Source_ID,String Class_Type,String Destination_ID,String Booked_By_User,Date Reservation_Date,String Reservation_Status,String Source_name,String Destination_name)
    {
        this.Pnr = pnr;
        this.Destination_ID=Destination_ID;
        this.Train_No=Train_no;
        this.Booked_By_User=Booked_By_User;
        this.Class_Type=Class_Type;
        this.Source_ID=Source_ID;
        this.No_of_Passengers=No_of_Passengers;
        this.Reservation_Status=Reservation_Status;
        this.Reservation_Date=Reservation_Date;
        this.Source_name=Source_name;
        this.Destination_name=Destination_name;
    }
    public ArrayList<Passenger> getPassenger_array() {
		return Passenger_array;
	}
	public void setPassenger_array(ArrayList<Passenger> Passenger_array) {
		this.Passenger_array=Passenger_array;
	}
    public Date getReservation_Date() {
        return Reservation_Date;
    }
    public void setReservation_Date(Date reservation_Date) {
        this.Reservation_Date = reservation_Date;
    }
    public String getReservation_Status() {
        return Reservation_Status;
    }
    public void setReservation_Status(String reservation_Status) {
        this.Reservation_Status = reservation_Status;
    }
    public int getNo_of_Passengers() {
        return No_of_Passengers;
    }
    public void setNo_of_Passengers(int no_of_Passengers) {
        this.No_of_Passengers = no_of_Passengers;
    }
    public String getPnr() {
        return Pnr;
    }
    public void setPnr()
    {
    	PNR_Random pr = new PNR_Random();
    	pr.generatePNR();
        this.Pnr = pr.getPNR();
    }
    public String getSource_ID() {
        return Source_ID;
    }
    public void setSource_ID(String source_ID) {
        this.Source_ID = source_ID;
    }
    public String getClass_Type() {
        return Class_Type;
    }
    public void setClass_Type(String class_Type) {
        this.Class_Type = class_Type;
    }
    public String getDestination_ID() {
        return Destination_ID;
    }
    public void setDestination_ID(String destination_ID) {
        this.Destination_ID = destination_ID;
    }
    public int getTrain_No() {
        return Train_No;
    }
    public void setTrain_No(int train_No) {
        this.Train_No = train_No;
    }
    public String getBooked_By_User() {
        return Booked_By_User;
    }
    public void setBooked_By_User(String booked_By_User) {
        this.Booked_By_User = booked_By_User;
    }
    public String getSource_name() {
        return Source_name;
    }
    public void setSource_name(String source_name) {
        this.Source_name=source_name;
    }
    public String getDestination_name() {
        return Destination_name;
    }
    public void setDestination_name(String destination_name) {
        this.Destination_name = destination_name;
    }
    public String toString()
    {
        return (No_of_Passengers+Train_No+Source_ID+Class_Type+Destination_ID+Booked_By_User+Reservation_Date+Resrevation_Status+Reservation_Status+Source_name+Destination_name);
    }
}