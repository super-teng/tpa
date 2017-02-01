package com.nefu.software.tpa.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 帮扶单位表
 * Created by Super腾 on 2017/1/18.
 */
public class ReliefCompany {
    private Integer cid;
    @NotEmpty(message = "用户名不能为空")
    @Length(max = 10)
    private String username;//用户名
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "[0-9a-zA-Z]{6,10}",message = "密码格式不正确6-10位")
    private String password;//密码
    @NotEmpty(message = "公司名称不能为空")
    @Length(max = 10)
    private String cname;//公司名称
    @NotEmpty(message = "公司地址不能为空")
    @Length(max = 40)
    private String address;//公司地址
    @NotEmpty(message = "公司经营信息不能为空")
    @Length(max = 50)
    private String detail;//公司经营基本信息
    @NotEmpty
    @Pattern(regexp = "0?(13|14|15|18)[0-9]{9}",message = "电话号格式不正确")
    private String telephone;//公司电话号

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "ReliefCompany{" +
                "cid=" + cid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                ", detail='" + detail + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
