package com.googlebooksapi.entity;

/**
 * The type Image links.
 */
public class ImageLinks{
	private String thumbnail;
	private String smallThumbnail;

	/**
	 * Set thumbnail.
	 *
	 * @param thumbnail the thumbnail
	 */
	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	/**
	 * Get thumbnail string.
	 *
	 * @return the string
	 */
	public String getThumbnail(){
		return thumbnail;
	}

	/**
	 * Set small thumbnail.
	 *
	 * @param smallThumbnail the small thumbnail
	 */
	public void setSmallThumbnail(String smallThumbnail){
		this.smallThumbnail = smallThumbnail;
	}

	/**
	 * Get small thumbnail string.
	 *
	 * @return the string
	 */
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
