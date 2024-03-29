package com.szhengzhu.service;

import com.szhengzhu.bean.goods.MealImage;
import com.szhengzhu.core.Result;

import java.util.Map;

public interface MealImageService {

    /**
     * 添加套餐图片信息
     *
     * @date 2019年5月30日 上午9:31:57
     * @param base
     * @return
     */
    MealImage addMealImage(MealImage base);

    /**
     * 修改套餐图片信息
     *
     * @date 2019年5月30日 上午9:31:59
     * @param base
     * @return
     */
    MealImage modifyMealImage(MealImage base);

    /**
     * 删除套餐图片信息
     *
     * @date 2019年5月30日 上午9:32:02
     * @param markId
     * @return
     */
    void deleteMealImage(String markId);

    /**
     * 获取套餐图片展示列表
     *
     * @date 2019年5月30日 上午9:32:04
     * @param mealId
     * @param type
     * @return
     */
    Map<String,Object> getMealImageList(String mealId, Integer type);

    /**
     * 根据id获取套餐图片信息
     *
     * @date 2019年5月30日 上午9:32:06
     * @param markId
     * @return
     */
    MealImage getImageInfo(String markId);
}
