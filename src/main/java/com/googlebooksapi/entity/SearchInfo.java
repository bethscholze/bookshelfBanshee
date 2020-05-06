package com.googlebooksapi.entity;

/**
 * The type Search info.
 */
public class SearchInfo{
	private String textSnippet;

	/**
	 * Set text snippet.
	 *
	 * @param textSnippet the text snippet
	 */
	public void setTextSnippet(String textSnippet){
		this.textSnippet = textSnippet;
	}

	/**
	 * Get text snippet string.
	 *
	 * @return the string
	 */
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
