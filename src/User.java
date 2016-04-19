public class User extends Person
{
	private String email, password;
	private String mobile;
	private String city, state, security_question, security_answer;
	User() { }
	public User(String email, String password, String name, char gender, int age, String mobile, String city, String state,String security_question,String security_answer)
	{
		super(name, age, gender);
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
		this.security_question = security_question;
		this.security_answer = security_answer;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getName()
	{
		return super.getName();
	}
	public void setName(String name)
	{
		super.setName(name);
	}
	public int getAge()
	{
		return super.getAge();
	}
	public void setAge(int age)
	{
		super.setAge(age);
	}
	public char getGender()
	{
		return super.getGender();
	}
	public void setGender(char gender)
	{
		super.setGender(gender);
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getSecurity_question()
	{
		return security_question;
	}
	public void setSecurity_question(String security_question)
	{
		this.security_question = security_question;
	}
	public String getSecurity_answer()
	{
		return security_answer;
	}
	public void setSecurity_answer(String security_answer)
	{
		this.security_answer = security_answer;
	}
	/*public void sign_up_user(SQLConnection sq)
	{
		//SQLConnection sq = new SQLConnection("root", "vidhan");
		try
		{
			//sq.establishConnection();
			String s = "insert into User values(?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = (PreparedStatement)sq.con.prepareStatement(s);
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			pstmt.setString(3,getName());
			pstmt.setString(4,String.valueOf(getGender()));
			pstmt.setInt(5,getAge());
			pstmt.setString(6,mobile);
			pstmt.setString(7,city);
			pstmt.setString(8,state);
			pstmt.setString(9,security_question);
			pstmt.setString(10,security_answer);
			pstmt.executeUpdate();	
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
	}*/
}
