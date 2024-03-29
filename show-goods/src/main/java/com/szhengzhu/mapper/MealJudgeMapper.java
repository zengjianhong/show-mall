package com.szhengzhu.mapper;

import com.szhengzhu.bean.goods.MealJudge;
import com.szhengzhu.bean.vo.MealJudgeVo;
import com.szhengzhu.bean.wechat.vo.JudgeBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface MealJudgeMapper {

    int deleteByPrimaryKey(String markId);

    int insert(MealJudge record);

    int insertSelective(MealJudge record);

    MealJudge selectByPrimaryKey(String markId);

    int updateByPrimaryKeySelective(MealJudge record);

    int updateByPrimaryKey(MealJudge record);

    List<MealJudgeVo> selectByExampleSelective(MealJudge data);
    
    List<JudgeBase> selectJudge(@Param("userId") String userId, @Param("mealId") String mealId, @Param("number") Integer number);
}