public  class Reservation_Class {

    private String Pnr;
    private int No_of_Passengers,Train_No;
    private String Source_ID,Class_Type,Destination_ID,Booked_By_User,Reservation_Date,Resrevation_Status;
    private String Reservation_Status,Source_name,Destination_name;
    void Reservation()
    {
        this.Pnr="";
		this.Destination_ID="";
		this.Train_No=0;
		this.Booked_By_User="";
		this.Class_Type="";
		this.Source_ID="";
		this.No_of_Passengers=0;
		this.Reservation_Status="";
		this.Reservation_Date="";
		this.Source_name="";
		this.Destination_name="";
}
     void Reservation(int Train_no,String pnr,int No_of_Passengers,String Source_ID,String Class_Type,String Destination_ID,String Booked_By_User,String Reservation_Date,String Resrevation_Status,String Source_name,String Destination_name)
    {
        this.Pnr=Pnr;
        this.Destination_ID=Destination_ID;
        this.Train_No=Train_No;
        this.Booked_By_User=Booked_By_User;
        this.Class_Type=Class_Type;
        this.Source_ID=Source_ID;
        this.No_of_Passengers=No_of_Passengers;
        this.Reservation_Status=Reservation_Status;
        this.Reservation_Date=Reservation_Date;
        this.Source_name=Source_name;
        this.Destination_name=Destination_name;
    }
    public String getReservation_Date() {
        return Reservation_Date;
    }
    public void setReservation_Date(String reservation_Date) {
        this.Reservation_Date = reservation_Date;
    }
    public String getReservation_Status() {
        return Reservation_Status;
    }
    public void setReservation_Status(Object reservation_Status) {
        this.Reservation_Status = Reservation_Status;
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
    public void setPnr(String pnr) {
        this.Pnr = pnr;
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