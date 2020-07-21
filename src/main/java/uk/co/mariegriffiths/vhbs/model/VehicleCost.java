package uk.co.mariegriffiths.vhbs.model;

import java.time.OffsetDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VehicleCost")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleCost {
	private long vehicleId;
	private OffsetDateTime hireDate;
	private OffsetDateTime finishDate;

	public VehicleCost() {
	}

	@XmlElement(name = "vehicleId")
	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	@XmlElement(name = "hirehDate")
	public OffsetDateTime getHireDate() {
		return hireDate;
	}

	public void setHirehDate(OffsetDateTime hireDate) {
		this.hireDate = hireDate;
	}

	@XmlElement(name = "finishDate")
	public OffsetDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(OffsetDateTime finishDate) {
		this.finishDate = finishDate;
	}

}