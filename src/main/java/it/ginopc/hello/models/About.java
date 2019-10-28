package it.ginopc.hello.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class About implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String version;
	@CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    
	public Long getId() { return this.id; }
	public String getTitle() { return this.title; }
	public String getAuthor() { return this.author; }
	public String getVersion() { return this.version; }
}
