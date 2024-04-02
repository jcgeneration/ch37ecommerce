package org.generation.ecommerce.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}//constructor
	public User() {	}//constructor
	public String getEmail() {
		return email;
	}//getEmail
	public void setEmail(String email) {
		this.email = email;
	}//setEmail
	public String getPassword() {
		return password;
	}//getPassword
	public void setPassword(String password) {
		this.password = password;
	}//setPassword
	public Long getId() {
		return id;
	}//getId
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}//toString
}//class User
