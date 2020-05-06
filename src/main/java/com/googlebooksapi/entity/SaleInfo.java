package com.googlebooksapi.entity;

import java.util.List;

/**
 * The type Sale info.
 */
public class SaleInfo{
	private String country;
	private boolean isEbook;
	private String saleability;
	private List<OffersItem> offers;
	private String buyLink;
	private RetailPrice retailPrice;
	private ListPrice listPrice;

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
	 * Set is ebook.
	 *
	 * @param isEbook the is ebook
	 */
	public void setIsEbook(boolean isEbook){
		this.isEbook = isEbook;
	}

	/**
	 * Is is ebook boolean.
	 *
	 * @return the boolean
	 */
	public boolean isIsEbook(){
		return isEbook;
	}

	/**
	 * Set saleability.
	 *
	 * @param saleability the saleability
	 */
	public void setSaleability(String saleability){
		this.saleability = saleability;
	}

	/**
	 * Get saleability string.
	 *
	 * @return the string
	 */
	public String getSaleability(){
		return saleability;
	}

	/**
	 * Set offers.
	 *
	 * @param offers the offers
	 */
	public void setOffers(List<OffersItem> offers){
		this.offers = offers;
	}

	/**
	 * Get offers list.
	 *
	 * @return the list
	 */
	public List<OffersItem> getOffers(){
		return offers;
	}

	/**
	 * Set buy link.
	 *
	 * @param buyLink the buy link
	 */
	public void setBuyLink(String buyLink){
		this.buyLink = buyLink;
	}

	/**
	 * Get buy link string.
	 *
	 * @return the string
	 */
	public String getBuyLink(){
		return buyLink;
	}

	/**
	 * Set retail price.
	 *
	 * @param retailPrice the retail price
	 */
	public void setRetailPrice(RetailPrice retailPrice){
		this.retailPrice = retailPrice;
	}

	/**
	 * Get retail price retail price.
	 *
	 * @return the retail price
	 */
	public RetailPrice getRetailPrice(){
		return retailPrice;
	}

	/**
	 * Set list price.
	 *
	 * @param listPrice the list price
	 */
	public void setListPrice(ListPrice listPrice){
		this.listPrice = listPrice;
	}

	/**
	 * Get list price list price.
	 *
	 * @return the list price
	 */
	public ListPrice getListPrice(){
		return listPrice;
	}

	@Override
 	public String toString(){
		return 
			"SaleInfo{" + 
			"country = '" + country + '\'' + 
			",isEbook = '" + isEbook + '\'' + 
			",saleability = '" + saleability + '\'' + 
			",offers = '" + offers + '\'' + 
			",buyLink = '" + buyLink + '\'' + 
			",retailPrice = '" + retailPrice + '\'' + 
			",listPrice = '" + listPrice + '\'' + 
			"}";
		}
}
