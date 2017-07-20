package com.ad.compaign.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.ad.compaign.model.AdCampaignContent;

@Service("adCacheService")
public class AdCampaignCacheServiceImpl implements AdCampaignCacheService {

	private static final AtomicLong counter = new AtomicLong();

	private static Map<String, AdCampaignContent> adContentMap;

	static {
		adContentMap = new HashMap<>();
	}
	@Override
	public void saveAdCampaign(AdCampaignContent adContent) {
		adContent.setId(counter.incrementAndGet());
		adContentMap.put(adContent.getPartnerId(), adContent);
	}

	public AdCampaignContent getAdContentByPartnerId(String partnerId) {
		return adContentMap.get(partnerId);

	}

	@Override
	public List<AdCampaignContent> getAllCampaigns() {
		List<AdCampaignContent> campaignList = new ArrayList<AdCampaignContent>(adContentMap.values());
		return campaignList;
	}
}
