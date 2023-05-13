package vp.spring.springbootajax.model;

public class Article {
	//title je jednistveni identifikator clanka
	protected String title;
	protected String description;
	protected String text;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", description=" + description
				+ ", text=" + text + "]";
	}

}
