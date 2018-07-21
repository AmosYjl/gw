package com.monetware.ringspider.base.dao;

import com.monetware.ringspider.base.model.BaseProduct;

public interface BaseProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    int insert(BaseProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    int insertSelective(BaseProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    BaseProduct selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    int updateByPrimaryKeySelective(BaseProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(BaseProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_product
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    int updateByPrimaryKey(BaseProduct record);
}