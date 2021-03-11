package Db_Models;

public class EmployeeDetails {
	private String username;
	private String Password;
	private String phone_number;
	
	public void setname(String name)
	{
		username = name;
	}
	public void setnumber(String number)
	{
		phone_number = number;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getname()
	{
		return username;
	}
	public String getnumber()
	{
		return phone_number;
	}
}
