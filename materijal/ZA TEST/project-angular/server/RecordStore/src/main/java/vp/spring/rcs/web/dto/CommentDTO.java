package vp.spring.rcs.web.dto;

public class CommentDTO {
	
	private String username ;
	private String text;
	
	
	public CommentDTO(String username, String text) {
		super();
		this.username = username;
		this.text = text;
	}


	public CommentDTO() {
		super();
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
	
	

}
