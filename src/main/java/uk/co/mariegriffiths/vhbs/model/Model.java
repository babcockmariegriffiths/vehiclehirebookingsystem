package uk.co.mariegriffiths.vhbs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Model")
@XmlAccessorType(XmlAccessType.FIELD)
public class Model {
	private Long id;
	private String name;
	private Make make;
	private Category category;
	

	@XmlElement(name = "id")
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	@XmlElement(name = "make")
	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}
	
	@XmlElement(name = "category")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}