package com.googlebooksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class AccessInfo{

	@JsonProperty("accessViewStatus")
	private String accessViewStatus;

	@JsonProperty("country")
	private String country;

	@JsonProperty("viewability")
	private String viewability;

	@JsonProperty("pdf")
	private Pdf pdf;

	@JsonProperty("webReaderLink")
	private String webReaderLink;

	@JsonProperty("epub")
	private Epub epub;

	@JsonProperty("publicDomain")
	private boolean publicDomain;

	@JsonProperty("quoteSharingAllowed")
	private boolean quoteSharingAllowed;

	@JsonProperty("embeddable")
	private boolean embeddable;

	@JsonProperty("textToSpeechPermission")
	private String textToSpeechPermission;

	public void setAccessViewStatus(String accessViewStatus){
		this.accessViewStatus = accessViewStatus;
	}

	public String getAccessViewStatus(){
		return accessViewStatus;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setViewability(String viewability){
		this.viewability = viewability;
	}

	public String getViewability(){
		return viewability;
	}

	public void setPdf(Pdf pdf){
		this.pdf = pdf;
	}

	public Pdf getPdf(){
		return pdf;
	}

	public void setWebReaderLink(String webReaderLink){
		this.webReaderLink = webReaderLink;
	}

	public String getWebReaderLink(){
		return webReaderLink;
	}

	public void setEpub(Epub epub){
		this.epub = epub;
	}

	public Epub getEpub(){
		return epub;
	}

	public void setPublicDomain(boolean publicDomain){
		this.publicDomain = publicDomain;
	}

	public boolean isPublicDomain(){
		return publicDomain;
	}

	public void setQuoteSharingAllowed(boolean quoteSharingAllowed){
		this.quoteSharingAllowed = quoteSharingAllowed;
	}

	public boolean isQuoteSharingAllowed(){
		return quoteSharingAllowed;
	}

	public void setEmbeddable(boolean embeddable){
		this.embeddable = embeddable;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}

	public void setTextToSpeechPermission(String textToSpeechPermission){
		this.textToSpeechPermission = textToSpeechPermission;
	}

	public String getTextToSpeechPermission(){
		return textToSpeechPermission;
	}

	@Override
 	public String toString(){
		return 
			"AccessInfo{" + 
			"accessViewStatus = '" + accessViewStatus + '\'' + 
			",country = '" + country + '\'' + 
			",viewability = '" + viewability + '\'' + 
			",pdf = '" + pdf + '\'' + 
			",webReaderLink = '" + webReaderLink + '\'' + 
			",epub = '" + epub + '\'' + 
			",publicDomain = '" + publicDomain + '\'' + 
			",quoteSharingAllowed = '" + quoteSharingAllowed + '\'' + 
			",embeddable = '" + embeddable + '\'' + 
			",textToSpeechPermission = '" + textToSpeechPermission + '\'' + 
			"}";
		}
}