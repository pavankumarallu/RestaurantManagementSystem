package Db_Models;

public class Userdetails {
	String Name;
	String Password;
	String PhoneNo;
	String Address;
	String Pref;
	String pincode;

	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setPref(String pref) {
		Pref = pref;
	}
	public String getAddress() {
		return Address;
	}
	public String getPref() {
		return Pref;
	}
	public String getName() {
		return Name;
	}
	public String getPassword() {
		return Password;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

}
