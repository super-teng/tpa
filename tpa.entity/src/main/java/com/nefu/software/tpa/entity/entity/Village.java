package com.nefu.software.tpa.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *自然村表
 * Created by Super腾 on 2017/1/18.
 */
public class Village {
    private Integer vid;
    @NotEmpty(message = "自然村名称不能为空")
    private String vname;//自然村名称
    @NotEmpty(message = "地址不能为空")
    private String address;//地址
    @Max(value = 100000000, message = "人口过多")
    @Min(value = 0,message = "人口过少")
    private Integer population;//总人口
    @Max(value = 100000000, message = "人口过多")
    @Min(value = 0,message = "人口过少")
    private Integer povertyCount;//贫困人口
    @Max(value = 1000000000, message = "gdp过多")
    @Min(value = 0,message = "gdp过少")
    private Integer gdp;//年生产总值
    @NotEmpty(message = "自然村特色不能为空")
    @Length(max = 30,message = "长度过长")
    private String feature;//自然村特色
    @NotEmpty(message = "贫困等级不能为空")
    @Length(max = 1,message = "长度过长")
    private String vlevel;//自然村贫困等级

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getPovertyCount() {
        return povertyCount;
    }

    public void setPovertyCount(Integer povertyCount) {
        this.povertyCount = povertyCount;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getVlevel() {
        return vlevel;
    }

    public void setVlevel(String vlevel) {
        this.vlevel = vlevel;
    }

    @Override
    public String toString() {
        return "Village{" +
                "vid=" + vid +
                ", vname='" + vname + '\'' +
                ", address='" + address + '\'' +
                ", population=" + population +
                ", povertyCount=" + povertyCount +
                ", gdp=" + gdp +
                ", feature='" + feature + '\'' +
                ", vlevel='" + vlevel + '\'' +
                '}';
    }
}
