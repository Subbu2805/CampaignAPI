package com.ad.compaign.model;

import java.io.Serializable;

public class AdCampaignContent  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	private String partnerId;

	private String duration;

	private String adContent;

	public AdCampaignContent(long id, String partnerId, String duration,
			String adContent) {
		this.id = id;
		this.partnerId = partnerId;
		this.duration = duration;
		this.adContent = adContent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	@Override
	public String toString() {
		return "AdContent [id=" + id + ", partnerId=" + partnerId
				+ ", duration=" + duration + ", adContent=" + adContent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((partnerId == null) ? 0 : partnerId.hashCode());
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
		AdCampaignContent other = (AdCampaignContent) obj;
		if (id != other.id)
			return false;
		if (partnerId == null) {
			if (other.partnerId != null)
				return false;
		} else if (!partnerId.equals(other.partnerId))
			return false;
		return true;
	}
}
