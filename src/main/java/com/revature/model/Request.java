package com.revature.model;

import java.io.Serializable;

public class Request implements Serializable {
	private int requestId;
	private double requestAmount;
	private int requesterId;
	private int reviewerId;
	private String status;
	private String imageUrl;
	private String purpose;
	private String requestDate;
	private String reviewDate;
	
	public Request(double requestAmount, int requesterId, int reviewerId, String imageUrl, String purpose) {
		super();
		this.requestAmount = requestAmount;
		this.requesterId = requesterId;
		this.reviewerId = reviewerId;
		this.imageUrl = imageUrl;
		this.purpose = purpose;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		long temp;
		temp = Double.doubleToLongBits(requestAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + requestId;
		result = prime * result + requesterId;
		result = prime * result + ((reviewDate == null) ? 0 : reviewDate.hashCode());
		result = prime * result + reviewerId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Request other = (Request) obj;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (Double.doubleToLongBits(requestAmount) != Double.doubleToLongBits(other.requestAmount))
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestId != other.requestId)
			return false;
		if (requesterId != other.requesterId)
			return false;
		if (reviewDate == null) {
			if (other.reviewDate != null)
				return false;
		} else if (!reviewDate.equals(other.reviewDate))
			return false;
		if (reviewerId != other.reviewerId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestAmount=" + requestAmount + ", requesterId=" + requesterId
				+ ", reviewerId=" + reviewerId + ", status=" + status + ", imageUrl=" + imageUrl + ", purpose="
				+ purpose + ", requestDate=" + requestDate + ", reviewDate=" + reviewDate + "]";
	}
	
	
}
