package com.sooying.pay.third.api.util;

/**
 * 支付实体
 */
public class ReqGetPayParam {

	private String comp_id;
	private String prod_id;
	private String po_num;
	private String version;
	private String sourceType;
	private String return_url;
	private String notify_url;
	private String time_stamp;
	private String pay_content;
	
	public String getComp_id() {
		return comp_id;
	}
	public void setComp_id(String comp_id) {
		this.comp_id = comp_id;
	}
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getPo_num() {
		return po_num;
	}
	public void setPo_num(String po_num) {
		this.po_num = po_num;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getPay_content() {
		return pay_content;
	}
	public void setPay_content(String pay_content) {
		this.pay_content = pay_content;
	}
}
