import java.sql.*;
public class Database 
{
    private void create_admin(Statement st)throws SQLException
    {
        String sql = "create table if not exists Admin" + "(" + "User_ID varchar(20) not null," + "Password varchar(15) not null," + "primary key(User_ID)" + ");";
        st.executeUpdate(sql);		
    }
    private void create_user(Statement st)throws SQLException
    {
        String sql = "create table if not exists User(Username varchar(30) not null, Password varchar(15) not null, FullName varchar(30) not null, Gender enum('M','F') not null, Age int not null, Mobile varchar(11) not null, City varchar(20) not null, State varchar(50) not null,primary key(Username))";
        st.executeUpdate(sql);
    }
    private void create_station(Statement st)throws SQLException
    {
        String sql = "create table if not exists Station(Station_ID varchar(5) not null,Station_Name varchar(25),primary key(Station_ID));";
        st.executeUpdate(sql);
    }
    private void create_train(Statement st)throws SQLException
    {
        String sql = "create table if not exists Train(Train_ID int not null,Train_name varchar(50) not null,Train_type varchar(50) not null,Source_ID varchar(5) null,Destination_ID varchar(5) null,primary key(Train_ID),foreign key(Source_ID) references Station(Station_ID) on update cascade on delete cascade,foreign key(Destination_ID) references Station(Station_ID) on update no action on delete no action);";
        st.executeUpdate(sql);
    }
    private void create_trainClass(Statement st)throws SQLException
    {
        String sql = "create table if not exists Class(Train_ID int not null,Fare_Class1 int not null,Seat_Class1 int not null,Fare_Class2 int not null,Seat_Class2 int not null,Fare_Class3 int not null,Seat_Class3 int not null,primary key(Train_ID));";
        st.executeUpdate(sql);
    }
    private void create_trainStatus(Statement st)throws SQLException
    {
        String sql = "create table if not exists Status(Train_ID int not null,Available_Date date not null,Booked int not null,Waiting int not null,Available int not null,primary key(Train_ID,Available_Date),foreign key(Train_ID) references Train(Train_ID) on update cascade on delete cascade);";
        st.executeUpdate(sql);
    }
    private void create_Passenger(Statement st)throws SQLException
    {
        String sql = "create table if not exists Passenger(PNR varchar(15) not null,Seat int not null,Name varchar(30) not null,Age int not null,Gender enum('M','F') not null,Train_ID int not null,foreign key(Train_ID) references Train(Train_ID) on update cascade on delete cascade,primary key(PNR,Seat));";
        st.executeUpdate(sql);
    }
    private void create_Reservation(Statement st)throws SQLException
    {
        String sql = "create table if not exists Reservation(PNR varchar(15) not null,Source_ID varchar(8) not null,Destination_ID varchar(8) not null,Class_type varchar(25) not null,Reservation_Date date not null,Reservation_Status varchar(25) not null,Train_ID int not null,Booked_by_Email varchar(30) not null,foreign key(Train_ID) references Train(train_ID) on update cascade on delete cascade,foreign key(Source_ID) references Station(Station_ID),foreign key(Destination_ID) references Station(Station_ID),primary key(PNR));";
        st.executeUpdate(sql);
    }
    private void create_Route(Statement st)throws SQLException
    {
        String sql = "Create table if not exists Route(Train_ID int not null,Station_ID varchar(8) not null, Arrival_Time time not null,Departure_Time time not null,Distance int not null,Stop_Number int not null,Primary key(Train_ID,Stop_Number));";
        st.executeUpdate(sql);
    }
    public Database(SQLConnection sq)throws SQLException
    {
        Statement stmt = (Statement)sq.con.createStatement();
        create_admin(stmt);
        create_user(stmt);
        create_station(stmt);
        create_train(stmt);
        create_trainClass(stmt);
        create_trainStatus(stmt);
        create_Passenger(stmt);
        create_Reservation(stmt);
        create_Route(stmt);
    }
}
