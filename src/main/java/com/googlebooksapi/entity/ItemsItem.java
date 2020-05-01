package com.googlebooksapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ItemsItem{

	@JsonProperty("saleInfo")
	private SaleInfo saleInfo;

	@JsonProperty("searchInfo")
	private SearchInfo searchInfo;

	@JsonProperty("kind")
	private String kind;

	@JsonProperty("volumeInfo")
	private VolumeInfo volumeInfo;

	@JsonProperty("etag")
	private String etag;

	@JsonProperty("id")
	private String id;

	@JsonProperty("accessInfo")
	private AccessInfo accessInfo;

	@JsonProperty("selfLink")
	private String selfLink;

	public void setSaleInfo(SaleInfo saleInfo){
		this.saleInfo = saleInfo;
	}

	public SaleInfo getSaleInfo(){
		return saleInfo;
	}

	public void setSearchInfo(SearchInfo searchInfo){
		this.searchInfo = searchInfo;
	}

	public SearchInfo getSearchInfo(){
		return searchInfo;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setVolumeInfo(VolumeInfo volumeInfo){
		this.volumeInfo = volumeInfo;
	}

	public VolumeInfo getVolumeInfo(){
		return volumeInfo;
	}

	public void setEtag(String etag){
		this.etag = etag;
	}

	public String getEtag(){
		return etag;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAccessInfo(AccessInfo accessInfo){
		this.accessInfo = accessInfo;
	}

	public AccessInfo getAccessInfo(){
		return accessInfo;
	}

	public void setSelfLink(String selfLink){
		this.selfLink = selfLink;
	}

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