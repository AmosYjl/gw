package com.monetware.ringspider.base.model;

import java.util.Date;

public class BaseInfoLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_info_log.id
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_info_log.ip
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_info_log.look_time
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private Date lookTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_info_log.id
     *
     * @return the value of web_info_log.id
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_info_log.id
     *
     * @param id the value for web_info_log.id
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_info_log.ip
     *
     * @return the value of web_info_log.ip
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_info_log.ip
     *
     * @param ip the value for web_info_log.ip
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_info_log.look_time
     *
     * @return the value of web_info_log.look_time
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public Date getLookTime() {
        return lookTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_info_log.look_time
     *
     * @param lookTime the value for web_info_log.look_time
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setLookTime(Date lookTime) {
        this.lookTime = lookTime;
    }
}