package com.googlebooksapi.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VolumeInfo{

	@JsonProperty("industryIdentifiers")
	private List<IndustryIdentifiersItem> industryIdentifiers;

	@JsonProperty("pageCount")
	private int pageCount;

	@JsonProperty("printType")
	private String printType;

	@JsonProperty("readingModes")
	private ReadingModes readingModes;

	@JsonProperty("previewLink")
	private String previewLink;

	@JsonProperty("canonicalVolumeLink")
	private String canonicalVolumeLink;

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;

	@JsonProperty("title")
	private String title;

	@JsonProperty("imageLinks")
	private ImageLinks imageLinks;

	@JsonProperty("averageRating")
	private double averageRating;

	@JsonProperty("panelizationSummary")
	private PanelizationSummary panelizationSummary;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("ratingsCount")
	private int ratingsCount;

	@JsonProperty("publishedDate")
	private String publishedDate;

	@JsonProperty("categories")
	private List<String> categories;

	@JsonProperty("maturityRating")
	private String maturityRating;

	@JsonProperty("allowAnonLogging")
	private boolean allowAnonLogging;

	@JsonProperty("contentVersion")
	private String contentVersion;

	@JsonProperty("authors")
	private List<String> authors;

	@JsonProperty("infoLink")
	private String infoLink;

	public void setIndustryIdentifiers(List<IndustryIdentifiersItem> industryIdentifiers){
		this.industryIdentifiers = industryIdentifiers;
	}

	public List<IndustryIdentifiersItem> getIndustryIdentifiers(){
		return industryIdentifiers;
	}

	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	public int getPageCount(){
		return pageCount;
	}

	public void setPrintType(String printType){
		this.printType = printType;
	}

	public String getPrintType(){
		return printType;
	}

	public void setReadingModes(ReadingModes readingModes){
		this.readingModes = readingModes;
	}

	public ReadingModes getReadingModes(){
		return readingModes;
	}

	public void setPreviewLink(String previewLink){
		this.previewLink = previewLink;
	}

	public String getPreviewLink(){
		return previewLink;
	}

	public void setCanonicalVolumeLink(String canonicalVolumeLink){
		this.canonicalVolumeLink = canonicalVolumeLink;
	}

	public String getCanonicalVolumeLink(){
		return canonicalVolumeLink;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setImageLinks(ImageLinks imageLinks){
		this.imageLinks = imageLinks;
	}

	public ImageLinks getImageLinks(){
		return imageLinks;
	}

	public void setAverageRating(double averageRating){
		this.averageRating = averageRating;
	}

	public double getAverageRating(){
		return averageRating;
	}

	public void setPanelizationSummary(PanelizationSummary panelizationSummary){
		this.panelizationSummary = panelizationSummary;
	}

	public PanelizationSummary getPanelizationSummary(){
		return panelizationSummary;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	public String getPublisher(){
		return publisher;
	}

	public void setRatingsCount(int ratingsCount){
		this.ratingsCount = ratingsCount;
	}

	public int getRatingsCount(){
		return ratingsCount;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setCategories(List<String> categories){
		this.categories = categories;
	}

	public List<String> getCategories(){
		return categories;
	}

	public void setMaturityRating(String maturityRating){
		this.maturityRating = maturityRating;
	}

	public String getMaturityRating(){
		return maturityRating;
	}

	public void setAllowAnonLogging(boolean allowAnonLogging){
		this.allowAnonLogging = allowAnonLogging;
	}

	public boolean isAllowAnonLogging(){
		return allowAnonLogging;
	}

	public void setContentVersion(String contentVersion){
		this.contentVersion = contentVersion;
	}

	public String getContentVersion(){
		return contentVersion;
	}

	public void setAuthors(List<String> authors){
		this.authors = authors;
	}

	public List<String> getAuthors(){
		return authors;
	}

	public void setInfoLink(String infoLink){
		this.infoLink = infoLink;
	}

	public String getInfoLink(){
		return infoLink;
	}

	@Override
 	public String toString(){
		return 
			"VolumeInfo{" + 
			"industryIdentifiers = '" + industryIdentifiers + '\'' + 
			",pageCount = '" + pageCount + '\'' + 
			",printType = '" + printType + '\'' + 
			",readingModes = '" + readingModes + '\'' + 
			",previewLink = '" + previewLink + '\'' + 
			",canonicalVolumeLink = '" + canonicalVolumeLink + '\'' + 
			",description = '" + description + '\'' + 
			",language = '" + language + '\'' + 
			",title = '" + title + '\'' + 
			",imageLinks = '" + imageLinks + '\'' + 
			",averageRating = '" + averageRating + '\'' + 
			",panelizationSummary = '" + panelizationSummary + '\'' + 
			",publisher = '" + publisher + '\'' + 
			",ratingsCount = '" + ratingsCount + '\'' + 
			",publishedDate = '" + publishedDate + '\'' + 
			",categories = '" + categories + '\'' + 
			",maturityRating = '" + maturityRating + '\'' + 
			",allowAnonLogging = '" + allowAnonLogging + '\'' + 
			",contentVersion = '" + contentVersion + '\'' + 
			",authors = '" + authors + '\'' + 
			",infoLink = '" + infoLink + '\'' + 
			"}";
		}
}