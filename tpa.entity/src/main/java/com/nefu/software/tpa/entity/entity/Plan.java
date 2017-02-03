package com.nefu.software.tpa.entity.entity;

import java.sql.Date;
import java.util.List;

/**
 * 帮扶计划表
 * Created by Super腾 on 2017/1/18.
 */
public class Plan {
    private Integer planId;
    private String pName; //计划名称
    private Integer povertyId;//扶贫用户ID
    private String povertyFlag;//扶贫的标记0为扶贫个人1为自然村
    private String detail;//计划内容
    private String duration;//计划持续时间
    private Date beginTime;//计划开始时间
    private Integer reliefId;//帮扶主体ID
    private String reliefFlag;//扶贫主体标记
    private List<PlanLog> list;//扶贫日志

    public Plan() {
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }


    public Integer getPovertyId() {
        return povertyId;
    }

    public void setPovertyId(Integer povertyId) {
        this.povertyId = povertyId;
    }

    public String getPovertyFlag() {
        return povertyFlag;
    }

    public void setPovertyFlag(String povertyFlag) {
        this.povertyFlag = povertyFlag;
    }

    public Integer getReliefId() {
        return reliefId;
    }

    public void setReliefId(Integer reliefId) {
        this.reliefId = reliefId;
    }

    public List<PlanLog> getList() {
        return list;
    }

    public void setList(List<PlanLog> list) {
        this.list = list;
    }

    public String getReliefFlag() {
        return reliefFlag;
    }

    public void setReliefFlag(String reliefFlag) {
        this.reliefFlag = reliefFlag;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planId=" + planId +
                ", pName='" + pName + '\'' +
                ", povertyId=" + povertyId +
                ", povertyFlag='" + povertyFlag + '\'' +
                ", detail='" + detail + '\'' +
                ", duration='" + duration + '\'' +
                ", beginTime=" + beginTime +
                ", reliefId=" + reliefId +
                ", reliefFlag='" + reliefFlag + '\'' +
                ", list=" + list +
                '}';
    }
}
