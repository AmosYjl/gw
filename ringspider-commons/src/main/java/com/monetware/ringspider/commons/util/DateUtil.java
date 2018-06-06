package com.monetware.ringspider.commons.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 时间工具类
 * 
 * @author Ray
 */
public class DateUtil {

	public static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

	public static final String COMMON_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm";

	public static final String PURE_LONG_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

	public static final String PURE_LONG_DATE_TIME_FORMAT_STR_UUID = "yyyyMMddHHmmssSSS";

	public static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";

	public static final SimpleDateFormat SIMPLE_DATE_TIME_FORMAT = new SimpleDateFormat(STANDARD_DATE_TIME_FORMAT_STR);
	public static final String DAY = "day";
	public static final String WEEK = "week";
	public static final String MONTH = "month";

	/**
	 * 通用日期模式
	 */
	private static final String[] GENERIC_DATE_PATTERNS = { STANDARD_DATE_TIME_FORMAT_STR, STANDARD_DATE_FORMAT_STR,
			COMMON_DATE_TIME_FORMAT_STR };

	/**
	 * 日期字符串转化为日期
	 * 
	 * @param src
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String str) {
		if (str == null || str.equals("")) {
			return null;
		}
		try {
			return DateUtils.parseDate(str, GENERIC_DATE_PATTERNS);
		} catch (ParseException e) {
			new RuntimeException("时间格式不对，返回当前时间", e);
			return new Date();
		}
	}

	/**
	 *
	 * @param str
	 * @return
	 */
	public static Date parseDateTime(String str) {
		if (str == null || str.equals("")) {
			return null;
		}
		try {
			return DateUtils.parseDate(str,STANDARD_DATE_TIME_FORMAT_STR );
		} catch (ParseException e) {
			new RuntimeException("时间格式不对，返回当前时间", e);
			return new Date();
		}
	}

	/**
	 * 日期字符串转化为日期
	 * 
	 * @param src
	 *            日期字符串
	 * @return
	 * @throws ParseException
	 */
	public static Date addDays(String date, int days) throws ParseException {
		return DateUtils.addDays(parseDate(date), days);
	}

	public static Date addDays(Date date, int days) throws ParseException {
		return DateUtils.addDays(date, days);
	}

	/**
	 * 格式日期时间为系统的标准格式(yyyyMMddHHmmssSSS)
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String formatDatetimeUUID(Date date) {
		return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR_UUID);
	}

	/**
	 * 格式日期时间为系统的标准格式(yyyy-MM-dd HH:mm)
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String formatDatetime(Date date) {
		return DateFormatUtils.format(date, COMMON_DATE_TIME_FORMAT_STR);
	}


	/**
	 * 格式日期时间为系统的标准格式(yyyy-MM-dd HH:mm)
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String formatCommonDatetime(Date date) {
		return DateFormatUtils.format(date, COMMON_DATE_TIME_FORMAT_STR);
	}

	/**
	 * 格式日期时间为系统的标准格式(yyyy-MM-dd HH:mm:ss)
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String formatPureDatetime(Date date) {
		return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR);
	}

	/**
	 * 格式日期为系统的标准格式(yyyy-MM-dd)
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String formatDate(Date date) {
		return DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR);
	}

	/**
	 * 对客户端提交的时间进行服务器时间转换，防止时间作弊
	 * 
	 * @param clientTime
	 *            客户端本地生成时间
	 * @param clientUploadTime
	 *            客户端本地上传时的时间
	 * @param currentServerTime
	 *            服务器当前时间
	 * @return 客户端本地时间对应的服务器时间
	 */
	public static String clientSubmitDate(String clientTime, String clientUploadTime, String currentServerTime) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentServerDate = new Date();
		try {
			Date clientDate = df.parse(clientTime);
			Date clientUploadDate = df.parse(clientUploadTime);
			currentServerDate = df.parse(currentServerTime);
			long c = currentServerDate.getTime() - (clientUploadDate.getTime() - clientDate.getTime());
			currentServerDate.setTime(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return df.format(currentServerDate);
	}

	public static long getDateDuration(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		long c = (endDate.getTime() - startDate.getTime())/1000;
		return c;
	}

	/**
	 * 自定义日期返回格式
	 * 
	 * @param time
	 * @return 1小时2分钟3秒
	 */
	public static String millisecondToHourMinuteSecondChineseStr(int time) {
		int hours = 0, minutes, seconds = 0;
		int timeInSeconds = 0;
		try {

			timeInSeconds = time / 1000;
			hours = timeInSeconds / 3600;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (timeInSeconds == 0) {
			return "--";
		}

		timeInSeconds = timeInSeconds - (hours * 3600);
		minutes = timeInSeconds / 60;
		seconds = timeInSeconds - (minutes * 60);

		StringBuffer sb = new StringBuffer();
		if (hours != 0) {
			sb.append(hours).append("小时");
		}
		if (minutes != 0) {
			sb.append(minutes).append("分钟");
		}
		sb.append(seconds).append("秒");
		return sb.toString();
	}


	/**
	 * 自定义日期返回格式
	 * 
	 * @param time
	 * @return 1小时2分钟3秒
	 */
	public static String secondToHourMinuteSecondChineseStr(int timeInSeconds) {
		int hours = 0, minutes, seconds = 0;
		try {
			hours = timeInSeconds / 3600;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (timeInSeconds == 0) {
			return "--";
		}

		timeInSeconds = timeInSeconds - (hours * 3600);
		minutes = timeInSeconds / 60;
		seconds = timeInSeconds - (minutes * 60);

		StringBuffer sb = new StringBuffer();
		if (hours != 0) {
			sb.append(hours).append("小时");
		}
		if (minutes != 0) {
			sb.append(minutes).append("分");
		}
		sb.append(seconds).append("秒");
		return sb.toString();
	}

	/**
	 * 根据Long类型时间自定义返回日期格式
	 * @param timeInSeconds
	 * @return
	 */
	public static String secondToHourMinuteSecondChineseStrByLong(Long timeInSeconds) {
		Long hours = Long.valueOf(0);
		Long minutes = Long.valueOf(0);
		Long seconds = Long.valueOf(0);
		if(timeInSeconds == null){
			return  "";
		}
		try {
			hours = timeInSeconds / 3600;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (timeInSeconds == 0) {
			return "--";
		}

		timeInSeconds = timeInSeconds - (hours * 3600);
		minutes = timeInSeconds / 60;
		seconds = timeInSeconds - (minutes * 60);

		StringBuffer sb = new StringBuffer();
		if (hours != 0) {
			sb.append(hours).append("小时");
		}
		if (minutes != 0) {
			sb.append(minutes).append("分");
		}
		sb.append(seconds).append("秒");
		return sb.toString();
	}

	/**
	 * 判断两个时间之间的天数差、周差、或者月差
	 * @param startTime
	 * @param endTime
	 * @param datetype
	 * @return
	 */
	public static int timeBettwen(String startTime, String endTime, String datetype) {
		//天数
		int days = 0;
		int weeks = 0;
		int months = 0;
		try {
			//时间转换类
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = sdf.parse(startTime);
			Date date2 = sdf.parse(endTime);
			Calendar can1 = Calendar.getInstance();
			can1.setTime(date1);
			Calendar can2 = Calendar.getInstance();
			can2.setTime(date2);
			int year1 = can1.get(Calendar.YEAR);
			int year2 = can2.get(Calendar.YEAR);
			Calendar can = null;
			if(can1.before(can2)){
				days -= can1.get(Calendar.DAY_OF_YEAR);
				days += can2.get(Calendar.DAY_OF_YEAR);
				weeks -= can1.get(Calendar.WEEK_OF_YEAR);
				weeks += can2.get(Calendar.WEEK_OF_YEAR);
				months -= can1.get(Calendar.MONTH);
				months += can2.get(Calendar.MONTH);
				can = can1;
			}else{
				days -= can2.get(Calendar.DAY_OF_YEAR);
				days += can1.get(Calendar.DAY_OF_YEAR);
				weeks -= can2.get(Calendar.WEEK_OF_YEAR);
				weeks += can1.get(Calendar.WEEK_OF_YEAR);
				months -= can2.get(Calendar.MONTH);
				months += can1.get(Calendar.MONTH);
				can = can2;
			}
			for (int i = 0; i < Math.abs(year2-year1); i++) {
				days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
				weeks += can.getActualMaximum(Calendar.WEEK_OF_YEAR);
				months += can.getActualMaximum(Calendar.MONTH) + 1;
				can.add(Calendar.YEAR, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (datetype.equals(DAY)) {
			return days;
		} else if (datetype.equals(WEEK)) {
			return weeks;
		} else if (datetype.equals(MONTH)) {
			return months;
		}
		return 0;
	}

}
