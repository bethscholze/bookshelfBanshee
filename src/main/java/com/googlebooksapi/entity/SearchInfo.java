package com.googlebooksapi.entity;

public class SearchInfo{
	private String textSnippet;

	public void setTextSnippet(String textSnippet){
		this.textSnippet = textSnippet;
	}

	public String getTextSnippet(){
		return textSnippet;
	}

	@Override
 	public String toString(){
		return 
			"SearchInfo{" + 
			"textSnippet = '" + textSnippet + '\'' + 
			"}";
		}
}
