package com.googlebooksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SearchInfo{

	@JsonProperty("textSnippet")
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