package com.googlebooksapi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The type Volume info.
 */
public class VolumeInfo implements Serializable {
	private List<IndustryIdentifiersItem> industryIdentifiers;
	private int pageCount;
	private String printType;
	private ReadingModes readingModes;
	private String previewLink;
	private String canonicalVolumeLink;
	private String description;
	private String language;
	private String title;
	private ImageLinks imageLinks;
	private PanelizationSummary panelizationSummary;
	private String publisher;
	private String publishedDate;
	private List<String> categories;
	private String maturityRating;
	private boolean allowAnonLogging;
	private String contentVersion;
	private List<String> authors;
	private String infoLink;
	private String subtitle;
	private double averageRating;
	private int ratingsCount;

	/**
	 * Set industry identifiers.
	 *
	 * @param industryIdentifiers the industry identifiers
	 */
	public void setIndustryIdentifiers(List<IndustryIdentifiersItem> industryIdentifiers){
		this.industryIdentifiers = industryIdentifiers;
	}

	/**
	 * Get industry identifiers list.
	 *
	 * @return the list
	 */
	public List<IndustryIdentifiersItem> getIndustryIdentifiers(){
		return industryIdentifiers;
	}

	/**
	 * Set page count.
	 *
	 * @param pageCount the page count
	 */
	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	/**
	 * Get page count int.
	 *
	 * @return the int
	 */
	public int getPageCount(){
		return pageCount;
	}

	/**
	 * Set print type.
	 *
	 * @param printType the print type
	 */
	public void setPrintType(String printType){
		this.printType = printType;
	}

	/**
	 * Get print type string.
	 *
	 * @return the string
	 */
	public String getPrintType(){
		return printType;
	}

	/**
	 * Set reading modes.
	 *
	 * @param readingModes the reading modes
	 */
	public void setReadingModes(ReadingModes readingModes){
		this.readingModes = readingModes;
	}

	/**
	 * Get reading modes reading modes.
	 *
	 * @return the reading modes
	 */
	public ReadingModes getReadingModes(){
		return readingModes;
	}

	/**
	 * Set preview link.
	 *
	 * @param previewLink the preview link
	 */
	public void setPreviewLink(String previewLink){
		this.previewLink = previewLink;
	}

	/**
	 * Get preview link string.
	 *
	 * @return the string
	 */
	public String getPreviewLink(){
		return previewLink;
	}

	/**
	 * Set canonical volume link.
	 *
	 * @param canonicalVolumeLink the canonical volume link
	 */
	public void setCanonicalVolumeLink(String canonicalVolumeLink){
		this.canonicalVolumeLink = canonicalVolumeLink;
	}

	/**
	 * Get canonical volume link string.
	 *
	 * @return the string
	 */
	public String getCanonicalVolumeLink(){
		return canonicalVolumeLink;
	}

	/**
	 * Set description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Get description string.
	 *
	 * @return the string
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Set language.
	 *
	 * @param language the language
	 */
	public void setLanguage(String language){
		this.language = language;
	}

	/**
	 * Get language string.
	 *
	 * @return the string
	 */
	public String getLanguage(){
		return language;
	}

	/**
	 * Set title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Get title string.
	 *
	 * @return the string
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Set image links.
	 *
	 * @param imageLinks the image links
	 */
	public void setImageLinks(ImageLinks imageLinks){
		this.imageLinks = imageLinks;
	}

	/**
	 * Get image links image links.
	 *
	 * @return the image links
	 */
	public ImageLinks getImageLinks(){
		return imageLinks;
	}

	/**
	 * Set panelization summary.
	 *
	 * @param panelizationSummary the panelization summary
	 */
	public void setPanelizationSummary(PanelizationSummary panelizationSummary){
		this.panelizationSummary = panelizationSummary;
	}

	/**
	 * Get panelization summary panelization summary.
	 *
	 * @return the panelization summary
	 */
	public PanelizationSummary getPanelizationSummary(){
		return panelizationSummary;
	}

	/**
	 * Set publisher.
	 *
	 * @param publisher the publisher
	 */
	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	/**
	 * Get publisher string.
	 *
	 * @return the string
	 */
	public String getPublisher(){
		return publisher;
	}

	/**
	 * Set published date.
	 *
	 * @param publishedDate the published date
	 */
	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	/**
	 * Get published date string.
	 *
	 * @return the string
	 */
	public String getPublishedDate(){
		return publishedDate;
	}

	/**
	 * Set categories.
	 *
	 * @param categories the categories
	 */
	public void setCategories(List<String> categories){
		this.categories = categories;
	}

	/**
	 * Get categories list.
	 *
	 * @return the list
	 */
	public List<String> getCategories(){
		return categories;
	}

	/**
	 * Set maturity rating.
	 *
	 * @param maturityRating the maturity rating
	 */
	public void setMaturityRating(String maturityRating){
		this.maturityRating = maturityRating;
	}

	/**
	 * Get maturity rating string.
	 *
	 * @return the string
	 */
	public String getMaturityRating(){
		return maturityRating;
	}

	/**
	 * Set allow anon logging.
	 *
	 * @param allowAnonLogging the allow anon logging
	 */
	public void setAllowAnonLogging(boolean allowAnonLogging){
		this.allowAnonLogging = allowAnonLogging;
	}

	/**
	 * Is allow anon logging boolean.
	 *
	 * @return the boolean
	 */
	public boolean isAllowAnonLogging(){
		return allowAnonLogging;
	}

	/**
	 * Set content version.
	 *
	 * @param contentVersion the content version
	 */
	public void setContentVersion(String contentVersion){
		this.contentVersion = contentVersion;
	}

	/**
	 * Get content version string.
	 *
	 * @return the string
	 */
	public String getContentVersion(){
		return contentVersion;
	}

	/**
	 * Set authors.
	 *
	 * @param authors the authors
	 */
	public void setAuthors(List<String> authors){
		this.authors = authors;
	}

	/**
	 * Get authors list.
	 *
	 * @return the list
	 */
	public List<String> getAuthors(){
		return authors;
	}

	/**
	 * Set info link.
	 *
	 * @param infoLink the info link
	 */
	public void setInfoLink(String infoLink){
		this.infoLink = infoLink;
	}

	/**
	 * Get info link string.
	 *
	 * @return the string
	 */
	public String getInfoLink(){
		return infoLink;
	}

	/**
	 * Set subtitle.
	 *
	 * @param subtitle the subtitle
	 */
	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	/**
	 * Get subtitle string.
	 *
	 * @return the string
	 */
	public String getSubtitle(){
		return subtitle;
	}

	/**
	 * Set average rating.
	 *
	 * @param averageRating the average rating
	 */
	public void setAverageRating(double averageRating){
		this.averageRating = averageRating;
	}

	/**
	 * Get average rating double.
	 *
	 * @return the double
	 */
	public double getAverageRating(){
		return averageRating;
	}

	/**
	 * Set ratings count.
	 *
	 * @param ratingsCount the ratings count
	 */
	public void setRatingsCount(int ratingsCount){
		this.ratingsCount = ratingsCount;
	}

	/**
	 * Get ratings count int.
	 *
	 * @return the int
	 */
	public int getRatingsCount(){
		return ratingsCount;
	}

	/**
	 * Gets lead author.
	 *
	 * @return the lead author
	 */
	public String getLeadAuthor() {
		return this.authors.get(0);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VolumeInfo that = (VolumeInfo) o;
		return pageCount == that.pageCount &&
				Objects.equals(industryIdentifiers, that.industryIdentifiers) &&
				Objects.equals(language, that.language) &&
				Objects.equals(title, that.title) &&
				Objects.equals(publisher, that.publisher) &&
				Objects.equals(publishedDate, that.publishedDate) &&
				Objects.equals(contentVersion, that.contentVersion) &&
				Objects.equals(authors, that.authors);
	}

	@Override
	public int hashCode() {
		return Objects.hash(industryIdentifiers, pageCount, language, title, publisher, publishedDate, contentVersion, authors);
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
			",panelizationSummary = '" + panelizationSummary + '\'' + 
			",publisher = '" + publisher + '\'' + 
			",publishedDate = '" + publishedDate + '\'' + 
			",categories = '" + categories + '\'' + 
			",maturityRating = '" + maturityRating + '\'' + 
			",allowAnonLogging = '" + allowAnonLogging + '\'' + 
			",contentVersion = '" + contentVersion + '\'' + 
			",authors = '" + authors + '\'' + 
			",infoLink = '" + infoLink + '\'' + 
			",subtitle = '" + subtitle + '\'' + 
			",averageRating = '" + averageRating + '\'' + 
			",ratingsCount = '" + ratingsCount + '\'' + 
			"}";
		}
}