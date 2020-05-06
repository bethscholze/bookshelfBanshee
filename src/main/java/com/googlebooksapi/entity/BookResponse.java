package com.googlebooksapi.entity;

import java.util.List;

/**
 * The type Book response.
 */
public class BookResponse{
	private int totalItems;
	private String kind;
	private List<ItemsItem> items;

	/**
	 * Set total items.
	 *
	 * @param totalItems the total items
	 */
	public void setTotalItems(int totalItems){
		this.totalItems = totalItems;
	}

	/**
	 * Get total items int.
	 *
	 * @return the int
	 */
	public int getTotalItems(){
		return totalItems;
	}

	/**
	 * Set kind.
	 *
	 * @param kind the kind
	 */
	public void setKind(String kind){
		this.kind = kind;
	}

	/**
	 * Get kind string.
	 *
	 * @return the string
	 */
	public String getKind(){
		return kind;
	}

	/**
	 * Set items.
	 *
	 * @param items the items
	 */
	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	/**
	 * Get items list.
	 *
	 * @return the list
	 */
	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"BookResponse{" + 
			"totalItems = '" + totalItems + '\'' + 
			",kind = '" + kind + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}