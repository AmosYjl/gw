package com.monetware.ringspider.base.model;

public class BaseSetting {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_setting.id
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_setting.setting_name
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private String settingName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_setting.setting_type
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private Integer settingType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_setting.setting_value
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    private String settingValue;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_setting.id
     *
     * @return the value of web_setting.id
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_setting.id
     *
     * @param id the value for web_setting.id
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_setting.setting_name
     *
     * @return the value of web_setting.setting_name
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public String getSettingName() {
        return settingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_setting.setting_name
     *
     * @param settingName the value for web_setting.setting_name
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_setting.setting_type
     *
     * @return the value of web_setting.setting_type
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public Integer getSettingType() {
        return settingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_setting.setting_type
     *
     * @param settingType the value for web_setting.setting_type
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setSettingType(Integer settingType) {
        this.settingType = settingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_setting.setting_value
     *
     * @return the value of web_setting.setting_value
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public String getSettingValue() {
        return settingValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_setting.setting_value
     *
     * @param settingValue the value for web_setting.setting_value
     *
     * @mbg.generated Tue May 29 22:04:09 CST 2018
     */
    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
}