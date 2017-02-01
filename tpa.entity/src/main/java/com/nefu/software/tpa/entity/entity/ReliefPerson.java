package com.nefu.software.tpa.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.sql.Date;

/**
 * 扶贫人员表
 * Created by Super腾 on 2017/1/18.
 */
public class ReliefPerson implements Serializable{
    private Integer rid;
    @NotEmpty(message = "用户名不能为空")
    @Length(max=10)
    private String username;//用户名
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "[0-9a-zA-Z]{6,10}",message = "密码格式不正确6-10位")
    private String password;//密码
    @NotEmpty(message = "真实姓名不能为空")
    @Length(max=4)
    private String realName;//真实姓名
    private Date birth;//出生日期
    @NotEmpty(message = "住址不能为空")
    @Length(max=40)
    private String address;//住址
    @NotEmpty(message = "工作不能为空")
    @Length(max=10)
    private String job;//工作
    @NotEmpty
    @Pattern(regexp = "0?(13|14|15|18)[0-9]{9}",message = "电话格式不正确")
    private String telephone;//电话号
    private String incomeDetail;//收入情况
    private boolean hasPovertyRelative;//是否有贫困亲属

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIncomeDetail() {
        return incomeDetail;
    }

    public void setIncomeDetail(String incomeDetail) {
        this.incomeDetail = incomeDetail;
    }

    public boolean isHasPovertyRelative() {
        return hasPovertyRelative;
    }

    public void setHasPovertyRelative(boolean hasPovertyRelative) {
        this.hasPovertyRelative = hasPovertyRelative;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "ReliefPerson{" +
                "rid=" + rid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", job='" + job + '\'' +
                ", telephone='" + telephone + '\'' +
                ", incomeDetail='" + incomeDetail + '\'' +
                ", hasPovertyRelative=" + hasPovertyRelative +
                '}';
    }
}
