package blogger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Like it-Domainobjekt
 * 
 * @author Roland.Germ
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Like {
	private int id;
	private String name;

	public Like() {
	}

	public Like(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}