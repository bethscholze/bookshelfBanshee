package com.googlebooksapi.entity;

public class AccessInfo{
	private String accessViewStatus;
	private String country;
	private String viewability;
	private Pdf pdf;
	private String webReaderLink;
	private Epub epub;
	private boolean publicDomain;
	private boolean quoteSharingAllowed;
	private boolean embeddable;
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
