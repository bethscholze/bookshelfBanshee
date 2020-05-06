package com.googlebooksapi.entity;

/**
 * The type Items item.
 */
public class ItemsItem{
	private SaleInfo saleInfo;
	private SearchInfo searchInfo;
	private String kind;
	private VolumeInfo volumeInfo;
	private String etag;
	private String id;
	private AccessInfo accessInfo;
	private String selfLink;

	/**
	 * Set sale info.
	 *
	 * @param saleInfo the sale info
	 */
	public void setSaleInfo(SaleInfo saleInfo){
		this.saleInfo = saleInfo;
	}

	/**
	 * Get sale info sale info.
	 *
	 * @return the sale info
	 */
	public SaleInfo getSaleInfo(){
		return saleInfo;
	}

	/**
	 * Set search info.
	 *
	 * @param searchInfo the search info
	 */
	public void setSearchInfo(SearchInfo searchInfo){
		this.searchInfo = searchInfo;
	}

	/**
	 * Get search info search info.
	 *
	 * @return the search info
	 */
	public SearchInfo getSearchInfo(){
		return searchInfo;
	}

	/**
	 * Set kind.
	 *
	 * @param kind the kind
	 */
	public void setKind(String kind){
		this.kind = kind;
	}

	/**
	 * Get kind string.
	 *
	 * @return the string
	 */
	public String getKind(){
		return kind;
	}

	/**
	 * Set volume info.
	 *
	 * @param volumeInfo the volume info
	 */
	public void setVolumeInfo(VolumeInfo volumeInfo){
		this.volumeInfo = volumeInfo;
	}

	/**
	 * Get volume info volume info.
	 *
	 * @return the volume info
	 */
	public VolumeInfo getVolumeInfo(){
		return volumeInfo;
	}

	/**
	 * Set etag.
	 *
	 * @param etag the etag
	 */
	public void setEtag(String etag){
		this.etag = etag;
	}

	/**
	 * Get etag string.
	 *
	 * @return the string
	 */
	public String getEtag(){
		return etag;
	}

	/**
	 * Set id.
	 *
	 * @param id the id
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * Get id string.
	 *
	 * @return the string
	 */
	public String getId(){
		return id;
	}

	/**
	 * Set access info.
	 *
	 * @param accessInfo the access info
	 */
	public void setAccessInfo(AccessInfo accessInfo){
		this.accessInfo = accessInfo;
	}

	/**
	 * Get access info access info.
	 *
	 * @return the access info
	 */
	public AccessInfo getAccessInfo(){
		return accessInfo;
	}

	/**
	 * Set self link.
	 *
	 * @param selfLink the self link
	 */
	public void setSelfLink(String selfLink){
		this.selfLink = selfLink;
	}

	/**
	 * Get self link string.
	 *
	 * @return the string
	 */
	public String getSelfLink(){
		return selfLink;
	}

	@Override
 	public String toString(){
		return 
			"ItemsItem{" + 
			"saleInfo = '" + saleInfo + '\'' + 
			",searchInfo = '" + searchInfo + '\'' + 
			",kind = '" + kind + '\'' + 
			",volumeInfo = '" + volumeInfo + '\'' + 
			",etag = '" + etag + '\'' + 
			",id = '" + id + '\'' + 
			",accessInfo = '" + accessInfo + '\'' + 
			",selfLink = '" + selfLink + '\'' + 
			"}";
		}
}
