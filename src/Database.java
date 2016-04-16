import java.sql.*;
public class Database 
{
	private static void create_Database(Statement st)throws SQLException
	{
		st.executeUpdate("drop database if exists Railway;");
		st.executeUpdate("create database Railway;");
		st.executeUpdate("use Railway;");
	}
	private static void create_admin(Statement st)throws SQLException
	{
		String sql = "create table Admin_table" + "(" + "User_ID varchar(20) not null," + "Password varchar(15) not null," + "primary key(User_ID)" + ");";
		st.executeUpdate(sql);		
	}
	private static void create_user(Statement st)throws SQLException
	{
		String sql = "Create table User" + "(" + "EmailID varchar(30) not null," + "Password varchar(15) not null," + "FullName varchar(30) not null," + "Gender varchar(8) not null," + "Age int not null," + "Mobile varchar(11) not null," + "City varchar(20) not null," + "State varchar(25) not null," + "Security_question varchar(40) not null," + "Security_answer varchar(20) not null" + ")";
		st.executeUpdate(sql);
	}
	private static void create_station(Statement st)throws SQLException
	{
		String sql = "create table Station(Station_ID varchar(5) not null,Station_Name varchar(25),primary key(Station_ID));";
		st.executeUpdate(sql);
	}
	private static void create_train(Statement st)throws SQLException
	{
		String sql = "create table Train(Train_ID int not null,Train_name varchar(50) not null,Train_type varchar(50) not null,Source_ID varchar(5) null,Destination_ID varchar(5) null,primary key(Train_ID),foreign key(Source_ID) references Station(Station_ID) on update cascade on delete cascade,foreign key(Destination_ID) references Station(Station_ID) on update no action on delete no action);";
		st.executeUpdate(sql);
	}
	private static void create_trainClass(Statement st)throws SQLException
	{
		String sql = "create table Class(Train_ID int not null,Fare_Class1 int not null,Seat_Class1 int not null,Fare_Class2 int not null,Seat_Class2 int not null,Fare_Class3 int not null,Seat_Class3 int not null,primary key(Train_ID));";
		st.executeUpdate(sql);
	}
	private static void create_trainStatus(Statement st)throws SQLException
	{
		String sql = "create table Status(Train_ID int not null,Available_Date date not null,Booked int not null,Waiting int not null,Available int not null,primary key(Train_ID,Available_Date),foreign key(Train_ID) references Train(Train_ID) on update cascade on delete cascade);";
		st.executeUpdate(sql);
	}
	public static void main(String[] args)
	{
		Statement stmt = null;
		SQLConnection sq = new SQLConnection("root", "vidhan");
		try
		{
			sq.establishConnection();
			stmt = (Statement)sq.con.createStatement();
			create_Database(stmt);
			create_admin(stmt);
			create_user(stmt);
			create_station(stmt);
			create_train(stmt);
			create_trainClass(stmt);
			create_trainStatus(stmt);
			System.out.println("done!");
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
			sq.closeConnection();
		}
	}
}