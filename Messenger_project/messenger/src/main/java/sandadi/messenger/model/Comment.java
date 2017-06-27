package sandadi.messenger.model;

import java.util.Date;

public class Comment {
	private long id;
	private String author;
	private Date created;
	private String comment;
	public Comment(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Comment(long id, String author, Date created, String comment) {
		super();
		this.id = id;
		this.author = author;
		this.created = created;
		this.comment = comment;
	}
	
}
