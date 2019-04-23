package com.bookhotel.restapp.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;


@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer number;
	private String category;
	private Integer price;
	
	private boolean isBusy;
	
	@ElementCollection
	@JoinTable(name="busy_data_range", joinColumns= @JoinColumn (name="range_id"))
	@MapKeyColumn (name="arrival")
	@Column(name="departure")
	private Map<Date,Date> busyDataRange = new HashMap<Date,Date>();
	
	
	
	private Integer priceBreakfast;
	private boolean breakfast;
	private Integer priceCleaning;
	private boolean cleaning;
	
	public Room(Integer number, String category,Integer price,boolean isBusy) {
		this.number = number;
		this.category = category;
		this.price = price;
		this.isBusy = isBusy;
		this.priceBreakfast = 10;
		this.breakfast = true;
		this.priceCleaning = 15;
		this.cleaning = true;
	}
	public Room() {
		this.priceBreakfast = 10;
		this.breakfast = true;
		this.priceCleaning = 15;
		this.cleaning = true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Map<Date, Date> getBusyDataRange() {
		return busyDataRange;
	}
	public void setBusyDataRange(Map<Date, Date> busyDataRange) {
		this.busyDataRange = busyDataRange;
	}
	public boolean isBusy() {
		return isBusy;
	}
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	public Integer getPriceBreakfast() {
		return priceBreakfast;
	}
	public void setPriceBreakfast(Integer priceBreakfast) {
		this.priceBreakfast = priceBreakfast;
	}
	public boolean isBreakfast() {
		return breakfast;
	}
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}
	public Integer getPriceCleaning() {
		return priceCleaning;
	}
	public void setPriceCleaning(Integer priceCleaning) {
		this.priceCleaning = priceCleaning;
	}
	public boolean isCleaning() {
		return cleaning;
	}
	public void setCleaning(boolean cleaning) {
		this.cleaning = cleaning;
	}
}
