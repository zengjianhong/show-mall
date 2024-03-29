package com.szhengzhu.bean.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * 
 * @author Administrator
 * @date 2019年2月19日
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo implements Serializable {
    
    private static final long serialVersionUID = 8233626581197994208L;

    private String markId;

    private String nickName;
    
    private String realName;

    private String phone;

    private String headerImg;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String language;

    private String userLevel;

    private String cookLevel;
    
    private String wopenId;

    private String xopenId;

    private String unionId;
    
    private Date createTime;

    private Integer wechatStatus;
}