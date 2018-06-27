package com.sooying.pay.app.api.common.base;

/**
 * 通用dto
 * 
 * @Description BasePageDto
 * @author liurh
 * @date 2018年6月4日
 */
public class BasePageDto {
    // 页码
    private int page;
    // 每页显示数
    private int rows;
    // 用户名
    private String loginName;
    // token字段
    private String token;

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page
     *            the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows
     *            the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName
     *            the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

}
