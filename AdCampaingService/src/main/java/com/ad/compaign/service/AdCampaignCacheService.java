package com.ad.compaign.service;


import java.util.List;

import com.ad.compaign.model.AdCampaignContent;

public interface AdCampaignCacheService {
	public void saveAdCampaign(AdCampaignContent adContent);
	public AdCampaignContent getAdContentByPartnerId(String partnerId);
	public List<AdCampaignContent> getAllCampaigns();
}
