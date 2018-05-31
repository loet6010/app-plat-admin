package com.sooying.pay.app.api.util;


public class MD5SignUtil {

	
	/**
	 * md5的签名检查
	 */
	public static boolean checkSign(String content,String key,String checkSign){
		content = content+"|"+key;
		String sign = MD5Util.MD5Encode(content).toUpperCase();  
	    return sign.equals(checkSign);  
	}
	
	/**
	 * 生成签名
	 */
	public static String createSign(String content,String key){
		content = content+"|"+key;
		String sign = MD5Util.MD5Encode(content).toUpperCase();  
	    return sign; 
	}
    
     public static void main(String[] args){
 		System.out.println(createSign("123456", "123"));
 	}
}
