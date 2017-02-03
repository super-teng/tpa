package com.nefu.software.tpa.entity.entity;

/**
 * 帮扶结对表
 * Created by Super腾 on 2017/1/18.
 */
public class PR {
    private Integer prId;
    private String pFlag;//帮扶主体标记，0为扶贫个人，1为扶贫单位
    private String rFlag;//贫困人员标记，0为贫困户，1为自然村
    private Integer rid;//扶贫ID
    private Integer pid;//贫困ID
    private Integer planId;//扶贫计划ID

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public String getpFlag() {
        return pFlag;
    }

    public void setpFlag(String pFlag) {
        this.pFlag = pFlag;
    }

    public String getrFlag() {
        return rFlag;
    }

    public void setrFlag(String rFlag) {
        this.rFlag = rFlag;
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

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "PR{" +
                "prId=" + prId +
                ", pFlag='" + pFlag + '\'' +
                ", rFlag='" + rFlag + '\'' +
                ", rid=" + rid +
                ", pid=" + pid +
                ", planId=" + planId +
                '}';
    }
}
