package com.szhengzhu.bean.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FeedbackInfo implements Serializable {
    
    private static final long serialVersionUID = 7180007077086471075L;

    private String markId;

    private String typeId;

    private String content;

    private String creator;

    private Date createTime;

    private String processor;

    private String description;

    private Date processTime;

    private Boolean serverStatus;
    
    private String typeDesc;
    
    private String createName;
}