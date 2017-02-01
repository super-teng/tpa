package com.nefu.software.tpa.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 管理员表
 * Created by Super腾 on 2017/1/18.
 */
public class Admin {
    private Integer aid;
    @NotEmpty(message = "用户名不能为空")
    @Length(max = 10,message = "用户名过长")
    private String username; //管理员用户名
    @NotEmpty(message = "密码不能为空")
    @Length(max = 10,message = "密码长度过长")
    private String password;//密码
    @NotEmpty(message = "管理员公司不能为空")
    @Length(max = 10,message = "公司名过长")
    private String company;//管理员公司
    @NotEmpty(message = "秘钥不能为空")
    @Length(max = 10,message = "秘钥长度过长")
    private String passkey;//该公司分配的秘钥

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", company='" + company + '\'' +
                ", passkey='" + passkey + '\'' +
                '}';
    }
}
