package uk.co.mariegriffiths.vhbs.model;

import javax.money.MonetaryAmount;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cost")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cost {
	private double price;
	private String currencyCode;

	public Cost() {
	}

	public Cost(MonetaryAmount monetaryAmount) {
		this.price = monetaryAmount.getNumber().doubleValue();
		this.currencyCode = monetaryAmount.getCurrency().getCurrencyCode();
	}

	@XmlElement(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlElement(name = "currencyCode")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}