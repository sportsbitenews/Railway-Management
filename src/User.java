public class User extends Person
{
	private String Username, password;
	private String mobile;
	private String city, state;
	User() { }
	public User(String Username, String password, String name, char gender, int age, String mobile, String city, String state)
	{
		super(name, age, gender);
		this.Username = Username;
		this.password = password;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
	}
	public String getUsername()
	{
		return Username;
	}
	public void setUsername(String Username)
	{
		this.Username = Username;
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
}
