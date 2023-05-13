package vp.spring.rcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Record {
	public Record(Long id, String title, String imageUrl, double price,
			Author author, Set<Style> styles) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.price = price;
		this.author = author;
		this.styles = styles;
	}

	public Record() {
		super();
	}

	public Record(String title, String imageURL, double price, Author author) {
		super();
		this.title = title;
		this.imageUrl = imageURL;
		this.price = price;
		this.author = author;
		this.styles = new HashSet<Style>();
	}

	@Id
	@GeneratedValue
	Long id;

	String title;
	
	String imageUrl;
	
	double price;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE) 
	Author author;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	Set<Style> styles = new HashSet<Style>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageURL) {
		this.imageUrl = imageURL;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Style> getStyles() {
		return styles;
	}

	public void setStyles(Set<Style> styles) {
		this.styles = styles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", title=" + title + ", imageUrl="
				+ imageUrl + ", price=" + price + ", author=" + author
				+ ", styles=" + styles + "]";
	}
}
