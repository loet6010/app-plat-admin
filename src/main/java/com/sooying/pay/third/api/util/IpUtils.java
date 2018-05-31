/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.sooying.pay.third.api.util;

import javax.servlet.http.HttpServletRequest;

import com.bench.common.lang.NumberUtils;
import com.bench.common.lang.StringUtils;

/**
 * ip工具类
 * 
 * @author lhb
 * 
 * @version $Id: IpUtils.java, v 0.1 2014-4-25 下午6:08:27 lhb Exp $
 */
public class IpUtils {

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// 将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
	public static long getLongIp(String strIp) {
		long[] ip = new long[4];
		// 先找到IP地址字符串中.的位置
		String[] ipPositions = StringUtils.split(strIp, ".");
		// 将每个.之间的字符串转换成整型
		ip[0] = NumberUtils.toLong(ipPositions[0]);
		ip[1] = NumberUtils.toLong(ipPositions[1]);
		ip[2] = NumberUtils.toLong(ipPositions[2]);
		ip[3] = NumberUtils.toLong(ipPositions[3]);
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	/**
	 * 将Ipvalue转换为ip<br>
	 * 122221221112=>122.221.221.112<br>
	 * 122221221001=>122.221.221.1
	 * 
	 * @param ipValue
	 * @return
	 */
	public static String getStringIp(long ipValue) {
		StringBuffer buf = new StringBuffer();
		String stringIpValue = Long.toString(ipValue);
		// 第1个区间可能是小于三位数，比如1.222.113.114=》001222113114=》1222113114
		stringIpValue = StringUtils.fillPrefix(stringIpValue, "0", 12);
		buf.append(Long.parseLong(stringIpValue.substring(0, 3))).append(StringUtils.DOT_SIGN)
				.append(Long.parseLong(stringIpValue.substring(3, 6))).append(StringUtils.DOT_SIGN)
				.append(Long.parseLong(stringIpValue.substring(6, 9))).append(StringUtils.DOT_SIGN)
				.append(Long.parseLong(stringIpValue.substring(9, 12)));
		return buf.toString();
	}

}
