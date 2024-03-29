package com.szhengzhu.mapper;

import java.util.List;

import com.szhengzhu.bean.base.FeedbackInfo;
import com.szhengzhu.bean.rpt.IndexDisplay;

public interface FeedbackInfoMapper {
    
    int deleteByPrimaryKey(String markId);

    int insert(FeedbackInfo record);

    int insertSelective(FeedbackInfo record);

    FeedbackInfo selectByPrimaryKey(String markId);

    int updateByPrimaryKeySelective(FeedbackInfo record);

    int updateByPrimaryKey(FeedbackInfo record);
    
    List<FeedbackInfo> selectByExampleSelective(FeedbackInfo feedbackInfo);

    List<IndexDisplay> selectIndexFeebackCount();
}