package com.sooying.pay.app.api.service.thirdpay;

import com.sooying.pay.app.api.model.thirdpay.OrderInfo;

/**
 * @Description:订单Service
 *
 * @author caimiao
 */
public interface OrderInfoService {
	/**
	 * 添加订单信息
	 */
	public void addOrderInfo(OrderInfo orderInfo);

	/**
	 * 更新订单信息(只更新非成功状态的单子)
	 */
	public int modifyOrderInfo(OrderInfo orderInfo);
	
	/**
	 * 查询订单信息
	 */
	public OrderInfo queryOrderInfoByOrderCode(String orderCode);

}
