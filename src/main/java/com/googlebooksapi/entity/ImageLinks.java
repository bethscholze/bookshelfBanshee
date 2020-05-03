package com.googlebooksapi.entity;

public class ImageLinks{
	private String thumbnail;
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
