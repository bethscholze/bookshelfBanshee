package com.googlebooksapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ImageLinks{

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("smallThumbnail")
	private String smallThumbnail;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setSmallThumbnail(String smallThumbnail){
		this.smallThumbnail = smallThumbnail;
	}

	public String getSmallThumbnail(){
		return smallThumbnail;
	}

	@Override
 	public String toString(){
		return 
			"ImageLinks{" + 
			"thumbnail = '" + thumbnail + '\'' + 
			",smallThumbnail = '" + smallThumbnail + '\'' + 
			"}";
		}
}