package com.googlebooksapi.entity;

import java.util.List;

public class BookResponse{
	private int totalItems;
	private String kind;
	private List<ItemsItem> items;

	public void setTotalItems(int totalItems){
		this.totalItems = totalItems;
	}

	public int getTotalItems(){
		return totalItems;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

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