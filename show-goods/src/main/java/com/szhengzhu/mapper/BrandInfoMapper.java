package com.szhengzhu.mapper;

import com.szhengzhu.bean.goods.BrandInfo;
import com.szhengzhu.bean.vo.Combobox;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Administrator
 */
public interface BrandInfoMapper {
    
    int deleteByPrimaryKey(String markId);

    int insert(BrandInfo record);

    int insertSelective(BrandInfo record);

    BrandInfo selectByPrimaryKey(String markId);

    int updateByPrimaryKeySelective(BrandInfo record);

    int updateByPrimaryKey(BrandInfo record);
    
    @Select("SELECT COUNT(*) FROM t_brand_info WHERE ( cn_name = #{cnName} OR en_name= #{enName} ) AND mark_id <> #{markId}")
    int repeatRecords(@Param("cnName")String cnName,@Param("enName") String enName,@Param("markId") String markId);
    
    List<BrandInfo> selectByExampleSelective(BrandInfo record);
    
    @Select("SELECT mark_id AS code, CONCAT(cn_name,'-',IFNULL(en_name,'')) AS name FROM t_brand_info WHERE brand_status = 1 ORDER BY sort")
    List<Combobox> selectCombobx();
}