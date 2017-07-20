package com.ad.compaign.controller;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ad.compaign.error.ErrorCode;
import com.ad.compaign.exception.CampaignException;
import com.ad.compaign.model.AdCampaignContent;
import com.ad.compaign.service.AdCampaignCacheService;
import com.ad.compaign.util.CustomError;

@RestController
@RequestMapping("/campaignApi")
public class AdCampaignController {

	public static final Logger logger = LoggerFactory.getLogger(AdCampaignController.class);

	@Autowired
	AdCampaignCacheService adCampaignCacheService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve ad content---------------------------------------------

	@RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.GET)
	public ResponseEntity<? extends Serializable> listAllUsers(@PathVariable String partnerId) {
		AdCampaignContent adContent = adCampaignCacheService.getAdContentByPartnerId(partnerId);
		if (adContent == null) {
			logger.error("ad campaign content with partnerId {} not found.", partnerId);
			return new ResponseEntity(new CustomError("Content with id " + partnerId 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(adContent, HttpStatus.OK);
	}

	// -------------------Create ad Content-------------------------------------------

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody AdCampaignContent adContent, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Ad Content : {}", adContent);
		adCampaignCacheService.saveAdCampaign(adContent);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/ad/{partnerId}").buildAndExpand(adContent.getPartnerId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	// -------------------Retrieve All ad Content-------------------------------------------
	@RequestMapping(value = "/ad/campaigns", method = RequestMethod.GET)
	public ResponseEntity<List<AdCampaignContent>> listAllCampaigns() {
		List<AdCampaignContent> adCampaigns = adCampaignCacheService.getAllCampaigns();
		if (adCampaigns.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AdCampaignContent>>(adCampaigns, HttpStatus.OK);
	}
	
	@ExceptionHandler(CampaignException.class)
	public ResponseEntity<CustomError> exceptionHandler(Exception ex) {
		logger.info("Error in the Service : {}", ex.getMessage());
		CustomError customError = new CustomError(ErrorCode.SERVICE_ERROR.getErrorMsg());
		customError.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		return new ResponseEntity<CustomError>(customError, HttpStatus.OK);
	}
}