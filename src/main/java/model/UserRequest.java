package model;

import java.util.Date;

public class UserRequest {

	private String id;
	
	private String userId;
	
	private String description;
	
	private long maxPrice;
	
	private Date startDate;
	private Date endDate;
	
	// TODO: private service_category;
	// TODO: private geospatial_info;

	
	public UserRequest() {
		
	}
	
	public UserRequest(String descr) {
		this.description = descr;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(long maxPrice) {
		if(maxPrice >= 0) {
			this.maxPrice = maxPrice;
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
