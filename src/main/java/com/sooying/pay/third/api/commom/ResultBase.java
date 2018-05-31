package com.sooying.pay.third.api.commom;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ResultBase {

	private boolean success;

	private String detailMessage;
	
	public ResultBase(){
	    
	}
	
	public ResultBase(boolean success,String detailMessage){
	    this.success = success;
	    this.detailMessage = detailMessage;
	}

	/**
	 * @return Returns the success.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            The success to set.
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 * @return Returns the detailMessage.
	 */
	public String getDetailMessage() {
		return detailMessage;
	}

	/**
	 * @param detailMessage
	 *            The detailMessage to set.
	 */
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
}
