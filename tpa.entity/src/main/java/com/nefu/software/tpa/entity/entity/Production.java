package com.nefu.software.tpa.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Date;

/**
 *项目表
 * Created by Super腾 on 2017/1/18.
 */
public class Production {
    private Integer proId;
    @NotEmpty(message = "项目名不能为空")
    @Length(max = 10,message = "项目名称过长")
    private String pName;//项目名称
    @NotEmpty(message = "项目内容不能为空")
    @Length(max = 40,message = "项目内容过长")
    private String detail;//项目内容
    @NotEmpty(message = "项目持续时间不能为空")
    @Length(max = 10,message = "项目持续时间过长")
    private String duration;//项目持续时间
    private String checkDetail;//审核情况
    private String povertyFlag;//贫困人员标记，0为贫困户，1为自然村
    private String reliefFlag;//帮扶主体标记，0为扶贫个人，1为扶贫单位
    private Integer rid;//扶贫人士ID具体查那个表取决于上面的标记是0还是1
    private Integer pid;//贫困人士ID具体查那个表取决于上面的标记是0还是1
    private String submitTime;//项目提交时间
    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getReliefFlag() {
        return reliefFlag;
    }

    public void setReliefFlag(String reliefFlag) {
        this.reliefFlag = reliefFlag;
    }

    public String getPovertyFlag() {
        return povertyFlag;
    }

    public void setPovertyFlag(String povertyFlag) {
        this.povertyFlag = povertyFlag;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getCheckDetail() {
        return checkDetail;
    }

    public void setCheckDetail(String checkDetail) {
        this.checkDetail = checkDetail;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        return "Production{" +
                "proId=" + proId +
                ", pName='" + pName + '\'' +
                ", detail='" + detail + '\'' +
                ", duration='" + duration + '\'' +
                ", checkDetail='" + checkDetail + '\'' +
                ", povertyFlag='" + povertyFlag + '\'' +
                ", reliefFlag='" + reliefFlag + '\'' +
                ", rid=" + rid +
                ", pid=" + pid +
                ", submitTime='" + submitTime + '\'' +
                '}';
    }
}
