package com.nefu.software.tpa.entity.entity;

/**
 * 秘钥表
 * Created by Super腾 on 2017/1/18.
 */
public class KeyNumber {

    private Integer kid;
    private String company; //公司
    private String passkey; //秘钥

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "KeyNumber{" +
                "kid=" + kid +
                ", company='" + company + '\'' +
                ", passkey='" + passkey + '\'' +
                '}';
    }
}
