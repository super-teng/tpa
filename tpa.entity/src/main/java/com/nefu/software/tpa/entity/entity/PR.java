package com.nefu.software.tpa.entity.entity;

/**
 * 帮扶结对表
 * Created by Super腾 on 2017/1/18.
 */
public class PR {
    private Integer prId;
    private String pFlag;//帮扶主体标记，0为扶贫个人，1为扶贫单位
    private String rFlag;//贫困人员标记，0为贫困户，1为自然村
    private Object poverty;//贫困类，具体是贫困人员还是自然村根据上面的判断
    private Object relief;//扶贫类，具体是扶贫人员还是扶贫机构局根据上面的判断
    private Plan plan;//对应的扶贫计划

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

    public Object getPoverty() {
        return poverty;
    }

    public void setPoverty(Object poverty) {
        this.poverty = poverty;
    }

    public Object getRelief() {
        return relief;
    }

    public void setRelief(Object relief) {
        this.relief = relief;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
