
package uk.co.mariegriffiths.vhbs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "FuelType")
@XmlAccessorType(XmlAccessType.FIELD)
public class FuelType {

  private Long id;
  private String name;

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
}