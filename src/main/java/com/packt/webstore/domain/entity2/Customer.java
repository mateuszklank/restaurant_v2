package com.packt.webstore.domain.entity2;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "`customer`")
public class Customer {
	//private String customerId;
	//private String name;
	//private String address;
	//private long noOfOrdersMade;
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@javax.persistence.Id
	private int customerId;
	private String name;
	private String surname;
	private String email;
	private String street;
	private String address;

	public Customer() {
		super();
	}

	public Customer(String name, String surname, String email, String street, String address) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.street = street;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
/*
	public long getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(long noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
			return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Klient [customerId=" + customerId + ", nazwisko=" + name +"]";
	}
*/
}