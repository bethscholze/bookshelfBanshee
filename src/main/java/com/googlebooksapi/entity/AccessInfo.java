package com.googlebooksapi.entity;

/**
 * The type Access info.
 */
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

	/**
	 * Set access view status.
	 *
	 * @param accessViewStatus the access view status
	 */
	public void setAccessViewStatus(String accessViewStatus){
		this.accessViewStatus = accessViewStatus;
	}

	/**
	 * Get access view status string.
	 *
	 * @return the string
	 */
	public String getAccessViewStatus(){
		return accessViewStatus;
	}

	/**
	 * Set country.
	 *
	 * @param country the country
	 */
	public void setCountry(String country){
		this.country = country;
	}

	/**
	 * Get country string.
	 *
	 * @return the string
	 */
	public String getCountry(){
		return country;
	}

	/**
	 * Set viewability.
	 *
	 * @param viewability the viewability
	 */
	public void setViewability(String viewability){
		this.viewability = viewability;
	}

	/**
	 * Get viewability string.
	 *
	 * @return the string
	 */
	public String getViewability(){
		return viewability;
	}

	/**
	 * Set pdf.
	 *
	 * @param pdf the pdf
	 */
	public void setPdf(Pdf pdf){
		this.pdf = pdf;
	}

	/**
	 * Get pdf pdf.
	 *
	 * @return the pdf
	 */
	public Pdf getPdf(){
		return pdf;
	}

	/**
	 * Set web reader link.
	 *
	 * @param webReaderLink the web reader link
	 */
	public void setWebReaderLink(String webReaderLink){
		this.webReaderLink = webReaderLink;
	}

	/**
	 * Get web reader link string.
	 *
	 * @return the string
	 */
	public String getWebReaderLink(){
		return webReaderLink;
	}

	/**
	 * Set epub.
	 *
	 * @param epub the epub
	 */
	public void setEpub(Epub epub){
		this.epub = epub;
	}

	/**
	 * Get epub epub.
	 *
	 * @return the epub
	 */
	public Epub getEpub(){
		return epub;
	}

	/**
	 * Set public domain.
	 *
	 * @param publicDomain the public domain
	 */
	public void setPublicDomain(boolean publicDomain){
		this.publicDomain = publicDomain;
	}

	/**
	 * Is public domain boolean.
	 *
	 * @return the boolean
	 */
	public boolean isPublicDomain(){
		return publicDomain;
	}

	/**
	 * Set quote sharing allowed.
	 *
	 * @param quoteSharingAllowed the quote sharing allowed
	 */
	public void setQuoteSharingAllowed(boolean quoteSharingAllowed){
		this.quoteSharingAllowed = quoteSharingAllowed;
	}

	/**
	 * Is quote sharing allowed boolean.
	 *
	 * @return the boolean
	 */
	public boolean isQuoteSharingAllowed(){
		return quoteSharingAllowed;
	}

	/**
	 * Set embeddable.
	 *
	 * @param embeddable the embeddable
	 */
	public void setEmbeddable(boolean embeddable){
		this.embeddable = embeddable;
	}

	/**
	 * Is embeddable boolean.
	 *
	 * @return the boolean
	 */
	public boolean isEmbeddable(){
		return embeddable;
	}

	/**
	 * Set text to speech permission.
	 *
	 * @param textToSpeechPermission the text to speech permission
	 */
	public void setTextToSpeechPermission(String textToSpeechPermission){
		this.textToSpeechPermission = textToSpeechPermission;
	}

	/**
	 * Get text to speech permission string.
	 *
	 * @return the string
	 */
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
