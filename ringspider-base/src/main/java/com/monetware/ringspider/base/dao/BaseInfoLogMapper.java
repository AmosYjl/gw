package com.monetware.ringspider.base.dao;

import com.monetware.ringspider.base.model.BaseInfoLog;

public interface BaseInfoLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_info_log
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_info_log
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int insert(BaseInfoLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_info_log
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int insertSelective(BaseInfoLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_info_log
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    BaseInfoLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_info_log
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int updateByPrimaryKeySelective(BaseInfoLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table web_info_log
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    int updateByPrimaryKey(BaseInfoLog record);
}