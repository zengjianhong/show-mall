package com.szhengzhu.bean.goods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 仓库商品配送范围信息
 * 
 * @author Administrator
 * @date 2019年3月12日
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeliveryArea implements Serializable {

    private static final long serialVersionUID = 1293519134535954966L;

    private String markId;

    private String storehouseId;

    private String province;

    private String city;

    private String area;

    private BigDecimal limitPrice;

    private BigDecimal deliveryPrice;

    private String creator;

    private Date createTime;

    private Boolean serverStatus;
    
    private String houseName;
}