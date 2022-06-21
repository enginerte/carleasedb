package org.demo.carlease.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String brand, model, version, doors, co2;
	private int year, grossPrice, nettPrice;
	@JsonIgnore

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	private Owner owner;
	
	public Car() {}

	public Car(String brand, String model, String version, String doors, String co2, int grossPrice, int nettPrice) {
		super();
		this.brand = brand;
		this.model = model;
		this.version = version;
		this.doors = doors;
		this.co2 = co2;
		this.grossPrice = grossPrice;
		this.nettPrice = nettPrice;
		this.owner = owner;
	}
	
	public Car(String brand, String model, String version, String doors, String co2, int grossPrice, int nettPrice, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.version = version;
		this.doors = doors;
		this.co2 = co2;
		this.grossPrice = grossPrice;
		this.nettPrice = nettPrice;
		this.owner = owner;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}




}
