package com.googlebooksapi.entity;

/**
 * The type Epub.
 */
public class Epub{
	private boolean isAvailable;
	private String acsTokenLink;

	/**
	 * Set is available.
	 *
	 * @param isAvailable the is available
	 */
	public void setIsAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	/**
	 * Is is available boolean.
	 *
	 * @return the boolean
	 */
	public boolean isIsAvailable(){
		return isAvailable;
	}

	/**
	 * Set acs token link.
	 *
	 * @param acsTokenLink the acs token link
	 */
	public void setAcsTokenLink(String acsTokenLink){
		this.acsTokenLink = acsTokenLink;
	}

	/**
	 * Get acs token link string.
	 *
	 * @return the string
	 */
	public String getAcsTokenLink(){
		return acsTokenLink;
	}

	@Override
 	public String toString(){
		return 
			"Epub{" + 
			"isAvailable = '" + isAvailable + '\'' + 
			",acsTokenLink = '" + acsTokenLink + '\'' + 
			"}";
		}
}
