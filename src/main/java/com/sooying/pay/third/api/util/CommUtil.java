package com.sooying.pay.third.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CommUtil {

	public static String getCurrentTimeStamp(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	/**
	 * 支付实体转换为param
	 */
	public static String getReqGetPayParam(ReqGetPayParam param) throws InterfaceException{
		StringBuffer reqParam = new StringBuffer();
		if(isEmpty(param.getComp_id())){
			throw new InterfaceException("comp_id不能为空！");
		}
		reqParam.append(param.getComp_id()).append("|");
		if(isEmpty(param.getProd_id())){
			throw new InterfaceException("prod_id不能为空！");
		}
		reqParam.append(param.getProd_id()).append("|");
		if(isEmpty(param.getPo_num())){
			throw new InterfaceException("po_num不能为空！");
		}
		reqParam.append(param.getPo_num()).append("|");
		if(isEmpty(param.getVersion())){
			throw new InterfaceException("version不能为空！");
		}
		reqParam.append(param.getVersion()).append("|");
		if(isEmpty(param.getSourceType())){
			throw new InterfaceException("sourceType不能为空！");
		}
		reqParam.append(param.getSourceType()).append("|");
		if(isEmpty(param.getNotify_url())){
			throw new InterfaceException("后台回调地址不能为空！");
		}
		reqParam.append(param.getNotify_url()).append("|");
		reqParam.append(param.getReturn_url()).append("|");
		if(isEmpty(param.getTime_stamp())){
			throw new InterfaceException("time_stamp不能为空！");
		}
		reqParam.append(param.getTime_stamp()).append("|");
		if(isEmpty(param.getPay_content())){
			throw new InterfaceException("支付信息不能为空");
		}
		reqParam.append(param.getPay_content()).append("|");
		return reqParam.toString();
	}
	public static boolean isEmpty(String str){
		if(str==null){
			return true;
		}
		if(str.length()<1){
			return true;
		}
		return false;	
	}
}
