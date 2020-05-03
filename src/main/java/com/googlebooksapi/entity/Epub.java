package com.googlebooksapi.entity;

public class Epub{
	private boolean isAvailable;
	private String acsTokenLink;

	public void setIsAvailable(boolean isAvailable){
		this.isAvailable = isAvailable;
	}

	public boolean isIsAvailable(){
		return isAvailable;
	}

	public void setAcsTokenLink(String acsTokenLink){
		this.acsTokenLink = acsTokenLink;
	}

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
