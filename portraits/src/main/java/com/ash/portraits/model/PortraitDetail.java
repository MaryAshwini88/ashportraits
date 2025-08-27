package com.ash.portraits.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "portraits")
public class PortraitDetail {
	
	@Id
	@Column
    private String id;
	
	@Column(length = 255)
    private String title;
	
	@Column(length = 1000)
    private String description;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
    private byte[] image;

//	@Column
//  private String imageUrl;
    
	@Column(name = "portrait_type")
    private String portraitType; //print or original
	
	@Column(precision = 10)
    private Double price;
	
	@Column
    private String dimensions;
	
	@Column
    private String material;
	
	@Column(name = "medium_used")
    private String mediumUsed;
	
	@Column(name = "portrait_status")
    private String portraitStatus;
	
	@Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdDate = new java.util.Date();

	
	@Column
    private Date updatedDate;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}


	public String getPortraitType() {
		return portraitType;
	}


	public void setPortraitType(String portraitType) {
		this.portraitType = portraitType;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDimensions() {
		return dimensions;
	}


	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public String getMediumUsed() {
		return mediumUsed;
	}


	public void setMediumUsed(String mediumUsed) {
		this.mediumUsed = mediumUsed;
	}


	public String getPortraitStatus() {
		return portraitStatus;
	}


	public void setPortraitStatus(String portraitStatus) {
		this.portraitStatus = portraitStatus;
	}


	public java.util.Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
    
    
    public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}

	
}
