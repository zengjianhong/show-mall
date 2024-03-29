package com.szhengzhu.service;

import com.szhengzhu.bean.order.UserAddress;
import com.szhengzhu.core.PageGrid;
import com.szhengzhu.core.PageParam;

import java.util.List;

/**
 * @author Jehon Zeng
 */
public interface UserAddressService {

    /**
     * 获取用户地址分页列表
     * 
     * @date 2019年3月5日 上午11:04:46
     * @param addressPage
     * @return
     */
    PageGrid<UserAddress> pageAddress(PageParam<UserAddress> addressPage);
    
    /**
     * 获取用户地址列表
     * 
     * @date 2019年6月12日 下午2:18:24
     * @param userId
     * @return
     */
    List<UserAddress> listByUser(String userId);
    
    /**
     * 用户添加配送地址
     * 
     * @date 2019年6月12日 下午2:34:31
     * @param address
     * @return
     */
    void add(UserAddress address);
    
    /**
     * 用户修改配送地址信息
     * 
     * @date 2019年6月26日 下午4:43:43
     * @param address
     * @return
     */
    void modify(UserAddress address);
    
    /**
     * 获取用户默认地址
     * 
     * @date 2019年7月2日 上午10:23:08
     * @param userId
     * @return
     */
    UserAddress getDefByUser(String userId);
    
    /**
     * 获取地址详细信息
     * 
     * @date 2019年7月4日 下午12:03:12
     * @param addressId
     * @return
     */
    UserAddress getInfo(String addressId);
}
