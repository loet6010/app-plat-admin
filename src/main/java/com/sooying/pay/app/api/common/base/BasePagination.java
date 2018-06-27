/**
 * sooying.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.sooying.pay.app.api.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

/**
 * 储存分页处理工具类 在调用此类的方法之前需设置总页数(即得先从数据库查询到相应数据的数据量)
 * 
 * @author chendiwen
 * @version $ v 0.1 2015-9-14 下午2:14:34 chendiwen Exp $
 */
public class BasePagination implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_ROWS_PER_PAGE = 10;
    /** start表示当前页开始的记录数,start=每页行数*(当前页数-1) */
    @SuppressWarnings("unused")
    private int start;
    /** 当前页结束的记录行数 */
    private int end;
    /** 总行数 */
    private int totalCount;
    /** 每页行数，默认15 */
    private int rowsPerPage = 10;
    /** 当前页数 */
    private int currentPage;
    /** 页码列表大小，默认9 */
    private int pageListSize = 9;

    @SuppressWarnings("rawtypes")
    private List pageResultList = new ArrayList();

    public BasePagination() {
        this.start = 0;
        this.end = 0;
        this.currentPage = 1;
        this.totalCount = 0;
    }

    public BasePagination(int totalCount) {
        this.start = 0;
        this.end = 0;
        this.currentPage = 1;
        this.totalCount = totalCount;
    }

    public BasePagination(int totalCount, int numPerPage) {
        this.start = 0;
        this.end = 0;
        this.totalCount = totalCount;
        this.currentPage = 1;
        if (numPerPage > 0) {
            rowsPerPage = numPerPage;
        }
    }

    /**
     * 执行翻页动作
     * 
     * @param currentPage
     *            要翻到的目标页码
     * @return 返回翻页对象
     */
    public BasePagination doPagination(int currentPage) {
        gotoPage(currentPage);
        return this;
    }

    // 设置起始数
    public int getStart() {
        return this.start = (this.currentPage - 1) * this.rowsPerPage;
    }

    // 得到起始数
    public void setStart(int start) {
        if (start < 0) {
            this.start = 0;
        } else if (start > this.totalCount) {
            this.start = this.totalCount - 1;
        } else {
            this.start = start;
        }
    }

    /**
     * 
     * @param end
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * 返回结束行数
     * 
     * @return
     */
    public int getEnd() {
        if (rowsPerPage * currentPage > this.totalCount) {
            end = this.totalCount - 1;
        } else {
            end = rowsPerPage * currentPage - 1;
        }
        return end;
    }

    /**
     * 是否到了第一页
     * 
     * @return
     */
    public boolean firstEnable() {
        return previousEnable();
    }

    /**
     * 判断是否已经还在第一页
     * 
     * @return
     */
    public boolean previousEnable() {
        return currentPage > 1;// 只要不是第一页，就能到上一页
    }

    /**
     * 判断是否还有下一页
     * 
     * @return
     */
    public boolean nextEnable() {
        return currentPage * rowsPerPage < this.totalCount;
    }

    /**
     * 判断是否最后一页
     * 
     * @return
     */
    public boolean lastEnable() {
        return nextEnable();
    }

    /**
     * 跳转到第一页
     * 
     */
    public void firstPage() {
        currentPage = 1;
    }

    /**
     * 上一页
     * 
     * @param cPage
     */
    public void previousPage(int cPage) {
        currentPage = (cPage - 1) > 0 ? (cPage - 1) : 1;
    }

    /**
     * 跳转到下一页
     * 
     * @param cPage
     */
    public void nextPage(int cPage) {
        currentPage = cPage + 1;
        if (currentPage * rowsPerPage > this.totalCount) {
            lastPage();
        }
    }

    /**
     * 跳转到最后一页
     */
    public void lastPage() {
        if (this.totalCount % rowsPerPage == 0) {
            currentPage = this.totalCount / rowsPerPage;
        } else {
            currentPage = this.totalCount / rowsPerPage + 1;
        }
    }

    /**
     * 跳转到指页
     * 
     * @param pageNumber
     */
    public void gotoPage(int pageNumber) {
        // 超出总页数返回错误
        Assert.isTrue(pageNumber == 1 || ((pageNumber - 1) * rowsPerPage < this.totalCount), "当前已是最后一页！");

        if (pageNumber <= 1) {
            currentPage = 1;
        } else if (getTotalCount() < this.getRowsPerPage()) {
            currentPage = 1;
        } else if (pageNumber * rowsPerPage >= this.totalCount) {
            lastPage();
        } else {
            currentPage = pageNumber;
        }
    }

    /**
     * 分页器数据计算
     */
    public void initPage() {
        gotoPage(this.currentPage);
        int startPageIndex = getStart();
        setStart(startPageIndex);
        this.pageListSize = this.getPages();
    }

    /**
     * 设置总行数
     * 
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取总行数
     * 
     * @return
     */
    public int getTotalCount() {
        return totalCount;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage <= 0 ? DEFAULT_ROWS_PER_PAGE : rowsPerPage;
    }

    // 得到每页行数
    public int getRowsPerPage() {
        return rowsPerPage;
    }

    // 得到总页数
    public int getPages() {
        if (this.totalCount % rowsPerPage == 0)
            return this.totalCount / rowsPerPage;
        else
            return this.totalCount / rowsPerPage + 1;
    }

    // 得到当前页数
    public int getCurrentPage() {
        return currentPage;
    }

    // 设置当前页数
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageListSize() {
        return pageListSize;
    }

    // 设置页码列表大小
    public void setPageListSize(int pageListSize) {
        this.pageListSize = pageListSize;
    }

    @SuppressWarnings("rawtypes")
    public List getPageResultList() {
        return pageResultList;
    }

    @SuppressWarnings("rawtypes")
    public void setPageResultList(List pageResultList) {
        this.pageResultList = pageResultList;
    }
}
