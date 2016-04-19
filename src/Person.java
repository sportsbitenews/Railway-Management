
public class Person 
{
	private String name;
	private int age;
	private char gender;
	Person(){ }
	public Person(String name, int age, char gender)
	{
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	protected String getName()
	{
		return name;
	}
	protected void setName(String name)
	{
		this.name = name;
	}
	protected int getAge()
	{
		return age;
	}
	protected void setAge(int age)
	{
		this.age = age;
	}
	protected char getGender()
	{
		return gender;
	}
	protected void setGender(char gender)
	{
		this.gender = gender;
	}
}
