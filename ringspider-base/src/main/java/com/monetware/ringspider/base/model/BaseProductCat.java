package com.monetware.ringspider.base.model;

public class BaseProductCat {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_product_cat.id
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_product_cat.cat_name
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    private String catName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column web_product_cat.order_by
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    private Integer orderBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_product_cat.id
     *
     * @return the value of web_product_cat.id
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_product_cat.id
     *
     * @param id the value for web_product_cat.id
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_product_cat.cat_name
     *
     * @return the value of web_product_cat.cat_name
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    public String getCatName() {
        return catName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_product_cat.cat_name
     *
     * @param catName the value for web_product_cat.cat_name
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column web_product_cat.order_by
     *
     * @return the value of web_product_cat.order_by
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column web_product_cat.order_by
     *
     * @param orderBy the value for web_product_cat.order_by
     *
     * @mbg.generated Wed Jun 27 11:20:46 CST 2018
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
}