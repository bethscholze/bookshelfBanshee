package com.googlebooksapi.entity;

public class OffersItem{
	private int finskyOfferType;
	private RetailPrice retailPrice;
	private ListPrice listPrice;
	private boolean giftable;

	public void setFinskyOfferType(int finskyOfferType){
		this.finskyOfferType = finskyOfferType;
	}

	public int getFinskyOfferType(){
		return finskyOfferType;
	}

	public void setRetailPrice(RetailPrice retailPrice){
		this.retailPrice = retailPrice;
	}

	public RetailPrice getRetailPrice(){
		return retailPrice;
	}

	public void setListPrice(ListPrice listPrice){
		this.listPrice = listPrice;
	}

	public ListPrice getListPrice(){
		return listPrice;
	}

	public void setGiftable(boolean giftable){
		this.giftable = giftable;
	}

	public boolean isGiftable(){
		return giftable;
	}

	@Override
 	public String toString(){
		return 
			"OffersItem{" + 
			"finskyOfferType = '" + finskyOfferType + '\'' + 
			",retailPrice = '" + retailPrice + '\'' + 
			",listPrice = '" + listPrice + '\'' + 
			",giftable = '" + giftable + '\'' + 
			"}";
		}
}
