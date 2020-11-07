package com.jero.common.utils;

import com.jero.common.exception.DateNullException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description 转换工具类
 * @Author zero
 * @Date 2020/11/7
 **/
public class ConvertUtils {

    /**
     * Date patterns
     */
    public static final String DAY_PATTERN = "yyyy-MM-dd";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    private ConvertUtils() {
        throw new IllegalStateException("ConvertUtils Utility class");
    }

    /**
     * 日期（年月日）转换为字符串
     *
     * @param date
     * @return 转换后的日期字符串
     */
    public static String strFromDate(Date date) {
        return dateToDateByPattern(date, DAY_PATTERN);
    }

    /**
     * 日期（年月日时分秒）转换为字符串
     *
     * @param date
     * @return
     */
    public static String strFromDatetime(Date date) {
        return dateToDateByPattern(date, DATETIME_PATTERN);
    }

    /**
     * Date根据转换模式，转换为字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToDateByPattern(Date date, String pattern){
        if (date == null) {
            throw new DateNullException("时间参数不存在");
        }

        if (pattern == null) {
            pattern = DATETIME_PATTERN;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * localDate转换为字符串
     * @param date
     * @return
     */
    public static String localDateToStr(LocalDate date) {
        return localDateToDateByPattern(date, null);
    }

    /**
     * LocalDate根据转换模式，转换为字符串
     * @param date
     * @return
     */
    public static String localDateToDateByPattern(LocalDate date, String pattern) {
        if (date == null) {
            throw new DateNullException("时间参数不存在");
        }

        if (pattern == null){
            pattern = DAY_PATTERN;
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return df.format(date);
    }

    /**
     * LocalDateTime根据转换为字符串
     * @param date
     * @return
     */
    public static String localDateTimeToStr(LocalDateTime date) {
        return localDateTimeToDateByPattern(date, null);
    }

    /**
     * LocalDateTime根据转换模式，转换为字符串
     * @param date
     * @return
     */
    public static String localDateTimeToDateByPattern(LocalDateTime date, String pattern) {
        if (date == null) {
            throw new DateNullException("时间参数不存在");
        }

        if (pattern == null){
            pattern = DATETIME_PATTERN;
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return df.format(date);
    }

    /**
     * 字符串转换为时间
     *
     * @param str
     * @return 转换后的日期
     * @throws ParseException
     */
    public static Date strToDate(String str) throws ParseException {
        return strToDate(str, null);
    }

    /**
     * 字符串转换为时间
     *
     * @param str
     * @param pattern 字符串模式
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str, String pattern) throws ParseException {
        if (pattern == null) {
            pattern = DATETIME_PATTERN;
        }
        return DateUtils.parseDate(str, pattern);
    }

    /**
     * 字符串转换为java8的LocalDateTime
     * @param str
     * @return 转换后的日期
     * @throws ParseException
     */
    public static LocalDateTime strToLocalDateTime(String str) throws ParseException{
        return strToLocalDateTime(str, null);
    }

    /**
     * 字符串转换为时间
     * @param str
     * @param pattern 字符串模式
     * @return LocalDateTime
     * @throws ParseException
     */
    public static LocalDateTime strToLocalDateTime(String str, String pattern) {
        if (pattern == null){
            pattern = DATETIME_PATTERN;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(str,df);
    }

    /**
     * 字符串转换为java8的LocalDate
     * @param str
     * @return 转换后的日期
     * @throws ParseException
     */
    public static LocalDate strToLocalDate(String str) throws ParseException{
        return strToLocalDate(str, null);
    }

    /**
     * 字符串转换为时间
     * @param str
     * @param pattern 字符串模式
     * @return LocalDateTime
     * @throws ParseException
     */
    public static LocalDate strToLocalDate(String str, String pattern) {
        if (pattern == null){
            pattern = DAY_PATTERN;
        }
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(str,df);
    }

}
