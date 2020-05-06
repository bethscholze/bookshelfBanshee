package com.googlebooksapi.entity;

/**
 * The type Reading modes.
 */
public class ReadingModes{
	private boolean image;
	private boolean text;

	/**
	 * Set image.
	 *
	 * @param image the image
	 */
	public void setImage(boolean image){
		this.image = image;
	}

	/**
	 * Is image boolean.
	 *
	 * @return the boolean
	 */
	public boolean isImage(){
		return image;
	}

	/**
	 * Set text.
	 *
	 * @param text the text
	 */
	public void setText(boolean text){
		this.text = text;
	}

	/**
	 * Is text boolean.
	 *
	 * @return the boolean
	 */
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
