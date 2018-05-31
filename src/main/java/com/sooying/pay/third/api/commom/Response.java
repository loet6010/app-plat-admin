package com.sooying.pay.third.api.commom;

import java.io.Serializable;

/**
 * 返回信息
 * 
 * @Description Response
 * @author liurh
 * @date 2018年2月26日
 * @param <T>
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 8206448610408409499L;
    /******** 返回状态 **********/
    public final static Integer STATUS_FAIL = 0;// 失败
    public final static Integer STATUS_OK = 1;// 成功
    private long startTime;// 起始时间
    private long endTime;// 结束时间
    private T data = null;// 序列化后的结果数据
    private String returnUrl;
    private String msg;
    private int status;// 操作结果
    private long timeConsum;// 耗时

    public Response() {
        super();
    }

    public long getTimeConsum() {
        return timeConsum;
    }

    public void setTimeConsum(long timeConsum) {
        this.timeConsum = timeConsum;
    }

    public Response<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public long getStartTime() {
        return startTime;
    }

    public Response<T> setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public long getEndTime() {
        return endTime;
    }

    public Response<T> setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 设置状态和起始时间，表示操作正在进行
     */
    public Response<T> start() {
        this.setStartTime(System.currentTimeMillis());
        return this;
    }

    /**
     * 设置状态和时间，表示操作结束，没有失败
     */
    public Response<T> end() {
        this.setEndTime(System.currentTimeMillis());
        this.setTimeConsum(this.endTime - this.startTime);
        this.setStatus(STATUS_OK);
        return this;
    }

    /**
     * 设置状态和时间，表示操作结束，并且失败
     */
    public Response<T> endAndFailed() {
        this.setStatus(STATUS_FAIL);
        this.setEndTime(System.currentTimeMillis());
        this.setTimeConsum(this.endTime - this.startTime);
        return this;
    }

    /**
     * 操作成功
     */
    public Response<T> success() {
        this.end();
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

}
