package com.szhengzhu.bean.goods;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 标签信息
 * 
 * @author Administrator
 * @date 2019年3月27日
 */
@Data
public class LabelInfo implements Serializable {

    private static final long serialVersionUID = -4277665175276095446L;

    private String markId;

    @NotBlank
    private String theme;

    private Integer serverType;

    private Boolean serverStatus;

    private String imagePath;

    private Integer sort;

}