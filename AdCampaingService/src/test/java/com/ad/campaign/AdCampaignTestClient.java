package com.ad.campaign;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ad.compaign.model.AdCampaignContent;
 

public class AdCampaignTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/AdCampaingService/campaignApi";
     
     
    /* GET */
    private static void getAdContent(){
        System.out.println("Testing getAdContent API----------");
        RestTemplate restTemplate = new RestTemplate();
        AdCampaignContent adCampaignContent = restTemplate.getForObject(REST_SERVICE_URI+"/ad/555", AdCampaignContent.class);
        System.out.println(adCampaignContent);
    }
    
    /* GET */
    private static void getAllCampaigns(){
        System.out.println("Testing getAdContent API----------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>>  adCampaigns = restTemplate.getForObject(REST_SERVICE_URI+"/ad/campaigns", List.class);
        
        if(adCampaigns!=null){
            for(LinkedHashMap<String, Object> map : adCampaigns){
                System.out.println("Campaign : id="+map.get("id")+", Name= "+map.get("partnerId")+", duration="+map.get("duration")+", adContent="+map.get("adContent"));
            }
        }else{
            System.out.println("No Campign exist----------");
        }
    }
     
    /* POST */
    private static void createAdContent() {
        System.out.println("Testing create Ad Content API----------");
        RestTemplate restTemplate = new RestTemplate();
        AdCampaignContent adContent = new AdCampaignContent(1,"555","20 days","election Campaign");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/api/", adContent, AdCampaignContent.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    public static void main(String args[]){
        getAdContent();
        createAdContent();
    }
}