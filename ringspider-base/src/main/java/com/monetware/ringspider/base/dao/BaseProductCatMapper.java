package com.monetware.ringspider.base.dao;

import com.monetware.ringspider.base.model.BaseProductCat;

public interface BaseProductCatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product_cat
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product_cat
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int insert(BaseProductCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product_cat
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int insertSelective(BaseProductCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product_cat
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    BaseProductCat selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product_cat
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int updateByPrimaryKeySelective(BaseProductCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product_cat
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int updateByPrimaryKey(BaseProductCat record);
}