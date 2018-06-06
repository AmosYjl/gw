package com.monetware.ringspider.commons.util;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;

/**
 * UUID生成
 * 
 * @author Ray
 * 
 */
public class UUIDUtil {

	/**
	 * 获取java系统的uuid
	 * 
	 * @return
	 */
	public final static String getRandomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 当前时间加上随机数的UUID
	 * 
	 * @return
	 */
	public final static String getTimestampUUID() {
		return DateUtil.formatDatetimeUUID(new Date()) + RandomUtils.nextInt(0, 100);
	}


}
