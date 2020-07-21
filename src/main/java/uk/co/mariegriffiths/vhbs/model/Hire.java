/**
 *  Copyright 2018 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package uk.co.mariegriffiths.vhbs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hire")
public class Hire {
  private long id;
  private long vehicleId;
	// private OffsetDateTime hireDate;
	// private OffsetDateTime finishDate;
  private long customerId;
  
  @XmlElement(name = "id")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  @XmlElement(name = "vehicleId")
  public long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(long vehicleId) {
    this.vehicleId = vehicleId;
  }

	// @XmlElement(name = "hireDate")
	// public OffsetDateTime getHireDate() {
	// return hireDate;
	// }

//  public void setHireDate(OffsetDateTime hireDate) {
//    this.hireDate = hireDate;
//  }
//
//  @XmlElement(name = "finishDate")
//  public OffsetDateTime getFinishDate() {
//    return finishDate;
//  }
//
//  public void setFinishDate(OffsetDateTime finishDate) {
//    this.finishDate = finishDate;
//  }

  @XmlElement(name = "customerId")
  public long getCustomerId() {
		return this.customerId;
	  }
  
  public void setCustomerId(long customerId) {
	this.customerId=customerId;
  }
}