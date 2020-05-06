package com.googlebooksapi.entity;

/**
 * The type List price.
 */
public class ListPrice{
	private double amount;
	private String currencyCode;
	private double amountInMicros;

	/**
	 * Set amount.
	 *
	 * @param amount the amount
	 */
	public void setAmount(double amount){
		this.amount = amount;
	}

	/**
	 * Get amount double.
	 *
	 * @return the double
	 */
	public double getAmount(){
		return amount;
	}

	/**
	 * Set currency code.
	 *
	 * @param currencyCode the currency code
	 */
	public void setCurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}

	/**
	 * Get currency code string.
	 *
	 * @return the string
	 */
	public String getCurrencyCode(){
		return currencyCode;
	}

	/**
	 * Set amount in micros.
	 *
	 * @param amountInMicros the amount in micros
	 */
	public void setAmountInMicros(double amountInMicros){
		this.amountInMicros = amountInMicros;
	}

	/**
	 * Get amount in micros double.
	 *
	 * @return the double
	 */
	public double getAmountInMicros(){
		return amountInMicros;
	}

	@Override
 	public String toString(){
		return 
			"ListPrice{" + 
			"amount = '" + amount + '\'' + 
			",currencyCode = '" + currencyCode + '\'' + 
			",amountInMicros = '" + amountInMicros + '\'' + 
			"}";
		}
}
