package com.nefu.software.tpa.entity.entity;

import java.sql.Date;

/**
 * 计划日志表
 * Created by Super腾 on 2017/1/18.
 */
public class PlanLog {
    private Integer lid;
    private Date submitTime;//日志提交时间
    private String detail;//日志详细信息
    private String logUrl;//日志附件url
    private Plan plan;//当前日志属于哪个计划

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }


    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "PlanLog{" +
                "lid=" + lid +
                ", submitTime=" + submitTime +
                ", detail='" + detail + '\'' +
                ", logUrl='" + logUrl + '\'' +
                '}';
    }
}
