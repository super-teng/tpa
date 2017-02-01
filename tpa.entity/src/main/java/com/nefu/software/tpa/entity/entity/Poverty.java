package com.nefu.software.tpa.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Date;

/**
 * 贫困用户表
 * Created by Super腾 on 2017/1/18.
 */
public class Poverty {
    private Integer pid;
    @NotEmpty(message = "姓名不能为空")
    @Length(max = 4,message = "姓名过长")
    private String pName;//姓名
    @NotEmpty(message = "性别不能为空")
    @Length(max = 2,message = "性别过长")
    private String sex;//性别
    private Date birth;//出生日期
    @NotEmpty(message = "住址不能为空")
    @Length(max = 40,message = "住址过长")
    private String address;//住址
    private boolean hasIncome;//是否有收入
    @NotEmpty(message = "收入情况不能为空")
    @Length(max = 10,message = "收入信息过长")
    private String incomeDetail;//收入详细信息
    @NotEmpty(message = "工作不能为空")
    @Length(max = 10, message = "工作信息不能为空")
    private String job;//工作
    @NotEmpty(message = "疾病情况不能为空")
    @Length(max = 30,message = "疾病情况过长")
    private String illness;//疾病情况
    @NotEmpty(message = "贫困原因不能为空")
    @Length(max = 30,message = "贫困原因不能过长")
    private String povertyReason;//贫困原因
    @NotEmpty(message = "贫困等级过长")
    @Length(max = 1,message = "贫困等级过长")
    private String pLevel;//贫困等级
    private Village village;//所属自然村

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHasIncome() {
        return hasIncome;
    }

    public void setHasIncome(boolean hasIncome) {
        this.hasIncome = hasIncome;
    }

    public String getIncomeDetail() {
        return incomeDetail;
    }

    public void setIncomeDetail(String incomeDetail) {
        this.incomeDetail = incomeDetail;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getPovertyReason() {
        return povertyReason;
    }

    public void setPovertyReason(String povertyReason) {
        this.povertyReason = povertyReason;
    }

    public String getpLevel() {
        return pLevel;
    }

    public void setpLevel(String pLevel) {
        this.pLevel = pLevel;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public String toString() {
        return "Poverty{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", hasIncome=" + hasIncome +
                ", incomeDetail='" + incomeDetail + '\'' +
                ", job='" + job + '\'' +
                ", illness='" + illness + '\'' +
                ", povertyReason='" + povertyReason + '\'' +
                ", pLevel='" + pLevel + '\'' +
                ", village=" + village +
                '}';
    }
}
