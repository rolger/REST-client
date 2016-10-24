package blogger;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Post-Domainobjekt
 * 
 * @author Roland.Germ
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BlogPost {
	private String id;
	private String titel;
	private String autor;

	@XmlElement(nillable = true)
	private List<Like> likes = new ArrayList<>();

	public BlogPost() {
	}

	public BlogPost(String id, String titel, String autor) {
		this.id = id;
		this.titel = titel;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public List<Like> getLikes() {
		return likes;
	}

}