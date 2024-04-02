package org.generation.ecommerce.dto;
public class ChangePassword {
	private String password;
	private String npassword;
	public ChangePassword(String password, String npassword) {
		super();
		this.password = password;
		this.npassword = npassword;
	}//constructor
	public ChangePassword() {}//constructor
	public String getPassword() {
		return password;
	}//getPassword
	public void setPassword(String password) {
		this.password = password;
	}//setPassword
	public String getNpassword() {
		return npassword;
	}//getNPassword
	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}//setNPassword
	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}//toString
	
}//class ChangePassword
