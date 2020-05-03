package com.googlebooksapi.entity;

public class ReadingModes{
	private boolean image;
	private boolean text;

	public void setImage(boolean image){
		this.image = image;
	}

	public boolean isImage(){
		return image;
	}

	public void setText(boolean text){
		this.text = text;
	}

	public boolean isText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"ReadingModes{" + 
			"image = '" + image + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}
