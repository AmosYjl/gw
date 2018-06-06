package com.monetware.ringspider.commons.constant;

public class AnalysisConstants {

    /**
     * 分析未开始
     */
    public static final Integer SENTIME_STATUS_START = 1;
    /**
     * 分析进行中
     */
    public static final Integer SENTIME_STATUS_DOING = 2;
    /**
     * 分析结束
     */
    public static final Integer SENTIME_STATUS_END = 3;


    /**
     * 分析模块状态值   删除
     */
    public static final Integer Analysis_STATUS_DELETE=0;
    /**
     * 分析模块状态值 执行中未开始
     */
    public static final Integer Analysis_STATUS_START_=1;
    /**
     * 分析模块状态值 执行中
     */
    public static final Integer Analysis_STATUS_DOING=2;
    /**
     * 分析模块状态值  完成
     */
    public static final Integer Analysis_STATUS_END=3;
    /**
     * 分析模块状态值 异常
     */
    public static final Integer Analysis_STATUS_EXCEPTION=4;
    /**
     * K-MEANS
     */
    public static final Integer KMEANS=1;
    /**
     * STC 算法
     */
    public static final Integer STC=2;
    /**
     * LINGO算法
     */
    public static final Integer LINGO=3;

    /**
     * 应用中心窗口打开状态
     */
    public  static  final  Integer WINDOW_OPEN=1;

    /**
     * 应用中心窗口关闭状态
     */
    public  static  final  Integer WINDOW_CLOSE=0;


    /**
     * 文本库导入数据状态
     */
    public static final Integer IS_IMPORT=2;
    /**
     * 文本库未导入数据状态
     */
    public static final Integer NO_IMPORT=2;

}
