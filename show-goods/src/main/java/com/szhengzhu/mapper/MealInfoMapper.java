package com.szhengzhu.mapper;

import com.szhengzhu.bean.excel.MealGoodsModel;
import com.szhengzhu.bean.goods.MealInfo;
import com.szhengzhu.bean.vo.Combobox;
import com.szhengzhu.bean.wechat.vo.GoodsBase;
import com.szhengzhu.bean.wechat.vo.GoodsDetail;
import com.szhengzhu.bean.wechat.vo.StockBase;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Administrator
 */
public interface MealInfoMapper {

    int deleteByPrimaryKey(String markId);

    int insert(MealInfo record);

    int insertSelective(MealInfo record);

    MealInfo selectByPrimaryKey(String markId);

    int updateByPrimaryKeySelective(MealInfo record);

    int updateByPrimaryKey(MealInfo record);

    @Select("select count(*) from t_meal_info where theme = #{theme} and mark_id <> #{markId}")
    int repeatRecords(@Param("theme") String theme, @Param("markId") String markId);

    List<MealInfo> selectByExampleSelective(MealInfo data);
    
    @Select("SELECT mark_id AS code, theme AS name FROM t_meal_info WHERE server_status=1")
    List<Combobox> selectCombobox();

    @Select("select mark_id as code,theme as name from t_meal_info where server_status = 1")
    List<Combobox> selectComboboxList();

    List<MealInfo> selectByExampleSelectiveNotColumn(MealInfo data);

    List<MealInfo> selectByExampleSelectiveNotLabel(MealInfo data);

    List<MealInfo> selectByExampleSelectiveNotSpecial(MealInfo data);

    List<MealInfo> selectByExampleSelectiveNotIcon(MealInfo data);
    
    List<GoodsBase> selectLabelMeal(@Param("labelId") String labelId);
    
    GoodsDetail selectById(@Param("mealId") String mealId);
    
    @Select("SELECT m.mark_id AS goodsId, m.theme AS goodsName,m.base_price AS basePrice,m.sale_price AS salePrice,m.server_status AS goodsStatus," + 
            "  (SELECT i.image_path FROM t_meal_image i WHERE i.meal_id=m.mark_id AND i.server_type=0 LIMIT 1) AS goodsImage " + 
            "FROM t_meal_info m WHERE m.mark_id=#{mealId}")
    GoodsBase selectCartMeal(@Param("mealId") String mealId);
    
    @Update("update t_meal_info set server_status = 0 where mark_id in (select meal_id from t_meal_item where goods_id = #{goodsId}) ")
    int updateStatusByGoods(@Param("goodsId") String goodsId);
    
    StockBase selectMealInfo(@Param("mealId") String mealId);
    
    @Select("SELECT mark_id FROM t_meal_info")
    List<String> selectMealIds();

    @Select("SELECT g.goods_name AS productName,m.quantity AS quantity,0 AS productType from t_meal_item m left join t_goods_info g on m.goods_id = g.mark_id WHERE m.meal_id = #{mealId}")
    List<MealGoodsModel> selectGoodsByMealId(@Param("mealId") String mealId);
}