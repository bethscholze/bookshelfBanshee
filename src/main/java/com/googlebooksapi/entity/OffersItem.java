package com.googlebooksapi.entity;

/**
 * The type Offers item.
 */
public class OffersItem{
	private int finskyOfferType;
	private RetailPrice retailPrice;
	private ListPrice listPrice;
	private boolean giftable;

    /**
     * Set finsky offer type.
     *
     * @param finskyOfferType the finsky offer type
     */
    public void setFinskyOfferType(int finskyOfferType){
		this.finskyOfferType = finskyOfferType;
	}

    /**
     * Get finsky offer type int.
     *
     * @return the int
     */
    public int getFinskyOfferType(){
		return finskyOfferType;
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

    /**
     * Set giftable.
     *
     * @param giftable the giftable
     */
    public void setGiftable(boolean giftable){
		this.giftable = giftable;
	}

    /**
     * Is giftable boolean.
     *
     * @return the boolean
     */
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
