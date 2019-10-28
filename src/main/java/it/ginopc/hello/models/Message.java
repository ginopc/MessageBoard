package it.ginopc.hello.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private String body;

	public Long getId() { return id; }
	public Message setId(Long id) { this.id = id; return this; }
	public String getMessage() { return this.body; }
	public Message setMessage(String body) { this.body = body; return this; }
}
