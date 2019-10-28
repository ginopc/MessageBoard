package it.ginopc.hello.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String name;
	private String email;
	private String phone;
	
	public Long getId() { return this.id; }
	public User setId(Long id) { this.id = id; return this; }
	public String getUserName() { return this.userName; }
	public User setUserName(String userName) { this.userName = userName; return this; }
	public String getName() { return this.name; }
	public User setName(String name) { this.name = name; return this; }
	public String getEmail() { return this.email; }
	public User setEmail(String email) { this.email = email; return this; }
	public String getPhone() { return this.phone; }
	public User setPhone(String phone) { this.phone = phone; return this; }
}

