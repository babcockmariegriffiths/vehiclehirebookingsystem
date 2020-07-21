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

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import io.swagger.v3.oas.annotations.Hidden;

@XmlRootElement(name = "Category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
	private long id;
	private String name;
	@XmlTransient
	@Hidden
	private MonetaryAmount currentPricePerDay;

	  
	@XmlElement(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "currentPrice")
	public Cost getCurrentPrice() {
		return new Cost(extractCurrentPricePerDay());
	}

	public void setCurrentPrice(Cost cost) {
		this.currentPricePerDay = Monetary.getDefaultAmountFactory().setCurrency(cost.getCurrencyCode())
				.setNumber(cost.getPrice()).create();
	}

	public MonetaryAmount extractCurrentPricePerDay() {
		return currentPricePerDay;
	}

	public void applyCurrentPricePerDay(MonetaryAmount currentPricePerDay) {
		this.currentPricePerDay = currentPricePerDay;
	}
}