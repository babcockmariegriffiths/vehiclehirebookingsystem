/**
 * Copyright 2018 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.mariegriffiths.vhbs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Vehicle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle {
    private Long id;
    private String registration;
	private Model model; // Make and category is implied by model
	private FuelType fuelType;

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

	public void setId(final Long id) {
		this.id = id;
	}

	@XmlElement(name = "registration")
	public String getRegistration() {
		return registration;
	}

	public void setRegistration(final String registration) {
		this.registration = registration;
	}

	@XmlElement(name = "model")
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

    @XmlElement(name = "fueltype")
	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	

}
