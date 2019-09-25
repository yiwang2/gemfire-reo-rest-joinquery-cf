package io.pivotal.bookshop.domain;

import java.io.Serializable;

import org.springframework.data.annotation.*;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;

@Region(value = "BookMaster")
@Data
public class BookMaster implements Serializable{

	private static final long serialVersionUID = 7526471155622776147L;

	@Id
	private Integer itemNumber;

	private String description;
	private float retailCost;
	private int yearPublished;
	private String author;
	private String title;

	public BookMaster() {
	}

	@PersistenceConstructor
	public BookMaster(Integer itemNumber, String description, float retailCost, int yearPublished, String author,
			String title) {
		super();
		this.itemNumber = itemNumber;
		this.description = description;
		this.retailCost = retailCost;
		this.yearPublished = yearPublished;
		this.author = author;
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookMaster other = (BookMaster) obj;
		if (itemNumber != other.itemNumber || !this.author.equals(other.author) || !this.title.equals(other.title))
			return false;
		return true;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRetailCost() {
		return retailCost;
	}

	public void setRetailCost(float retailCost) {
		this.retailCost = retailCost;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
