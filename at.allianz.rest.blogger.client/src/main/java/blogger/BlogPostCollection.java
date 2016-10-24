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
public class BlogPostCollection {

	@XmlElement(nillable = true)
	private List<BlogPost> blogPosts = new ArrayList<>();

	public BlogPostCollection() {
	}

	public List<BlogPost> getBlogPosts() {
		return blogPosts;
	}

	public void setBlogPosts(List<BlogPost> blogPosts) {
		this.blogPosts = blogPosts;
	}



}