package com.googlebooksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ReadingModes{

	@JsonProperty("image")
	private boolean image;

	@JsonProperty("text")
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