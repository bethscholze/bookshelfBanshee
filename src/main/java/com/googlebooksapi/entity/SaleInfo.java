package com.googlebooksapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SaleInfo{

	@JsonProperty("country")
	private String country;

	@JsonProperty("isEbook")
	private boolean isEbook;

	@JsonProperty("saleability")
	private String saleability;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setIsEbook(boolean isEbook){
		this.isEbook = isEbook;
	}

	public boolean isIsEbook(){
		return isEbook;
	}

	public void setSaleability(String saleability){
		this.saleability = saleability;
	}

	public String getSaleability(){
		return saleability;
	}

	@Override
 	public String toString(){
		return 
			"SaleInfo{" + 
			"country = '" + country + '\'' + 
			",isEbook = '" + isEbook + '\'' + 
			",saleability = '" + saleability + '\'' + 
			"}";
		}
}