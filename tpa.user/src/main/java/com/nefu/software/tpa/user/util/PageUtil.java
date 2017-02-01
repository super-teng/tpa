package com.nefu.software.tpa.user.util;

import java.util.List;

/**
 * 分页的工具类
 *
 * Created by Super腾 on 2017/1/24.
 */
public class PageUtil {
    //结果集
    public List list;
    //每页显示多少条数据
    private int pageSize;
    //总共有多少条数据
    private int recordCount;
    //当前页面
    private int currentPage;
    //起始索引
    private int fromIndex;
    //终止索引
    private int toIndex;
    //页码总数
    private int pageCount;
    //传了当前页面的构造方法
    public PageUtil(int pageSize,int recordCount,int currentPage){
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        this.currentPage = currentPage;
    }
    //未传当前页面的构造方法 默认为第一个页面
    public PageUtil(int pageSize,int recordCount){
        this(pageSize,recordCount,1);
    }
    //默认构造方法
    public PageUtil(){

    }
    //计算当前总的页面数量 !!!!
    public int getPageCount(){
        //当前有多少页
        int size = recordCount/pageSize;
        //如未整除余下数据页面数在加一
        int mod = recordCount%pageSize;
        if(mod != 0){
            size++;
        }
        //返回当前的页面数量，如果总记录数为0的话显示当前也为第1页否则为size页
        return recordCount == 0 ? 1:size;
    }
    //得到当前页面数量
    public int getCurrentPage() {
        return currentPage;
    }
    //设置当前页面
    public void setCurrentPage(int currentPage){
        //如果用户传参页数小于0则默认显示第一页否则显示当前页码
        int validPage = currentPage <= 0 ? 1 : currentPage;
        //如果当前页码数大于当前页码总数的话，显示为当前页码总数，否则为当前页码数
        validPage = validPage > getPageCount() ? getPageCount() : validPage;
        this.currentPage = validPage;
    }
    // 得到每页显示的条数
    public int getPageSize() {
        return pageSize;
    }
    // 设置每页显示的条数
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    // 得到总共的条数
    public int getRecordCount() {
        return recordCount;
    }
    // 设置总共的条数
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
    //获取所有数据量
    public List getList() {
        return list;
    }
    //设置数据量
    public void setList(List list) {
        this.list = list;
    }
    public int getFromIndex() {
        return (currentPage - 1) * pageSize;
    }
    public void setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
    }
    public int getToIndex() {
        return Math.min(recordCount, currentPage * pageSize);
    }
    public void setToIndex(int toIndex) {
        this.toIndex = toIndex;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
