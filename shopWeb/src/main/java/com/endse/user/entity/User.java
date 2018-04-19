package com.endse.user.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/4/19.
 */
@Entity
@Table(name = "OUB_ALLOCATION_RULE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DynamicInsert(true)
@DynamicUpdate(true)
public class User {

    /**
     * 主键
     *
     * @generated
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_money")
    private BigDecimal userMoney;

    @Column(name = "user_point")
    private Integer userPoint;

    @Column(name = "user_point_all")
    private Integer userPointAll;

    @Column(name = "user_tname")
    private String userTname;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name = "user_qq")
    private String userQq;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_atime")
    private Integer userAtime;

    @Column(name = "user_ltime")
    private Integer userLtime;

    @Column(name = "user_ip")
    private String userIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(Integer userPoint) {
        this.userPoint = userPoint;
    }

    public Integer getUserPointAll() {
        return userPointAll;
    }

    public void setUserPointAll(Integer userPointAll) {
        this.userPointAll = userPointAll;
    }

    public String getUserTname() {
        return userTname;
    }

    public void setUserTname(String userTname) {
        this.userTname = userTname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserAtime() {
        return userAtime;
    }

    public void setUserAtime(Integer userAtime) {
        this.userAtime = userAtime;
    }

    public Integer getUserLtime() {
        return userLtime;
    }

    public void setUserLtime(Integer userLtime) {
        this.userLtime = userLtime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
