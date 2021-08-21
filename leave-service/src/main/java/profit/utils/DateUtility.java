package profit.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <strong>Title : DateUtility<br>
 * </strong> <strong>Description : </strong>@ 日期、时间处理的工具类@<br>
 * <strong>Create on : 2015年11月16日<br>
 * </strong>
 * <p>
 * <strong>Copyright (C) Vbill Co.,Ltd.<br>
 * </strong>
 * <p>
 * 
 * @author department:技术公司-架构设计部 <br>
 *         username:yinlei <br>
 *         email:yin_lei@suixingpay.com <br>
 * @version <strong>随行付支付有限公司-运营平台</strong><br>
 * <br>
 *          <strong>修改历史:</strong><br>
 *          修改人 修改日期 修改描述<br>
 *          -------------------------------------------<br>
 * <br>
 * <br>
 */
public class DateUtility {
    /**
     * 构造函数
     */
    public DateUtility() {
    }

    /**
     * 比较两个日期 返回值为两个日期的差 "2015-11-02","2015-11-03"
     * 
     * @return int
     * @param sDate1 java.lang.String
     * @param sDate2 java.lang.String
     */
    public static long compareDate(String sDate1, String sDate2) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = dateFormat.parse(sDate1);
            date2 = dateFormat.parse(sDate2);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in compareDate()");
            System.err.println("sDate1:" + sDate1);
            System.err.println("sDate2:" + sDate2);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return 0;
        }

        long dif = 0;
        long lDate2 = date2.getTime();
        long lDate1 = date1.getTime();

        dif = (lDate2 - lDate1) / 1000 / 60 / 60 / 24;
        return dif;
    }

    /**
     * 获取当前日期 格式为YYYYMMDD
     * 
     * @return java.lang.String
     */
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(new Date());
        return s;
    }
    /**
     * 获取当前日期 格式为yyyy-MM-dd
     * 
     * @return
     */
    public static String getCurrentDateDD() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(new Date());
        return s;
    }

    /**
     * 获取当前日期及时间 格式为YYYYMMDDHHmmss
     * 
     * @return java.lang.String
     */
    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = df.format(new Date());
        return s;
    }

    /**
     * 获取当前日期中的日
     * 
     * @return java.lang.String
     */
    public static String getCurrentDay() {
        String day;
        SimpleDateFormat df = new SimpleDateFormat("d");
        day = df.format(new Date());
        return day;
    }

    /**
     * 获取当前日期中的月
     * 
     * @return java.lang.String
     */
    public static String getCurrentMonth() {
        String month;
        SimpleDateFormat df = new SimpleDateFormat("M");
        month = df.format(new Date());
        return month;
    }

    /**
     * 获取当前时间 格式为YYYY-MM-DD HH:MM:SS
     * 
     * @return java.lang.String
     */
    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 获取当前日期中的年
     * 
     * @return java.lang.String
     */
    public static String getCurrentYear() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return df.format(new Date());
    }

    /**
     * 获取指定季度或月的起止日期
     * 
     * @return java.lang.String
     * @param periodType int 0表示季度 1表示月份
     * @param year java.lang.String
     * @param period java.lang.String
     */
    public static String[] getDate(int periodType, String year, String period) {

        String[] dates = { getCurrentDate(), getCurrentDate() };

        // Validate
        if (periodType != 0 && periodType != 1) {
            // Error period type
            System.err.println("Error period type in DateUtil.getDate().");
            System.err.println("Period type(0-1):" + periodType);
            return dates;
        }

        int intYear = 2000;
        try {
            intYear = Integer.parseInt(year);
            if (intYear < 1900 || intYear > 3000) {
                System.err.println("Invalid year in DateUtility.getDate().");
                System.err.println("Year(1900-3000):" + year);
                return dates;
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid year in DateUtility.getDate().");
            System.err.println("Year:" + year);
            return dates;
        }

        int intPeriod = 1;
        try {
            intPeriod = Integer.parseInt(period);
            if (periodType == 0) {
                // Season
                if (intPeriod < 1 || intPeriod > 4) {
                    System.err.println("Invalid season in DateUtility.getDate().");
                    System.err.println("Season(1-4):" + period);
                    return dates;
                }
            } else {
                // Month
                if (intPeriod < 1 || intPeriod > 12) {
                    System.err.println("Invalid month in DateUtility.getDate().");
                    System.err.println("Month(1-12):" + period);
                    return dates;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid period in DateUtility.getDate().");
            System.err.println("Period:" + period);
            return dates;
        }

        if (periodType == 0) {
            // Season
            switch (intPeriod) {
                case 1:
                    dates[0] = year + "-1-1";
                    dates[1] = year + "-3-31";
                    break;
                case 2:
                    dates[0] = year + "-4-1";
                    dates[1] = year + "-6-30";
                    break;
                case 3:
                    dates[0] = year + "-7-1";
                    dates[1] = year + "-9-30";
                    break;
                case 4:
                    dates[0] = year + "-10-1";
                    dates[1] = year + "-12-31";
                    break;
            }
        } else {
            // Month
            switch (intPeriod) {
                case 1:
                    dates[0] = year + "-1-1";
                    dates[1] = year + "-1-31";
                    break;
                case 2:
                    dates[0] = year + "-2-1";
                    if ((intYear % 400 == 0) || ((intYear % 4 == 0) && (intYear % 100 != 0))) {
                        dates[1] = year + "-2-29";
                    } else {
                        dates[1] = year + "-2-28";
                    }
                    break;
                case 3:
                    dates[0] = year + "-3-1";
                    dates[1] = year + "-3-31";
                    break;
                case 4:
                    dates[0] = year + "-4-1";
                    dates[1] = year + "-4-30";
                    break;
                case 5:
                    dates[0] = year + "-5-1";
                    dates[1] = year + "-5-31";
                    break;
                case 6:
                    dates[0] = year + "-6-1";
                    dates[1] = year + "-6-30";
                    break;
                case 7:
                    dates[0] = year + "-7-1";
                    dates[1] = year + "-7-31";
                    break;
                case 8:
                    dates[0] = year + "-8-1";
                    dates[1] = year + "-8-31";
                    break;
                case 9:
                    dates[0] = year + "-9-1";
                    dates[1] = year + "-9-30";
                    break;
                case 10:
                    dates[0] = year + "-10-1";
                    dates[1] = year + "-10-31";
                    break;
                case 11:
                    dates[0] = year + "-11-1";
                    dates[1] = year + "-11-30";
                    break;
                case 12:
                    dates[0] = year + "-12-1";
                    dates[1] = year + "-12-31";
                    break;
            }
        }

        return dates;
    }

    /**
     * 获取一个月前的一天
     * 
     * @return java.lang.String
     */
    public static String getDateBeforeAMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取一个月后的一天
     * 
     * @return String
     */
    public static String getDateAfterAMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取当前月的第一天
     * 
     * @return java.lang.String
     */
    public static String getFirstDateOfMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-");
        String s = df.format(new Date());
        s += "1";
        return s;
    }

    /**
     * 验证日期的合法性
     * 
     * @param date String
     * @param type int 0表示一个日期 1表示年月
     * @return boolean
     */
    public static boolean validateDate(String date, int type) {

        boolean valid = true;
        DateFormat dateFormat = DateFormat.getDateInstance();
        switch (type) {
            case 0:
                // 2001-9-1
                break;
            case 1:
                // 2001-9
                date += "-1";
                break;
        }

        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            valid = false;
            System.err.println("Invalid date format:" + date);
            e.printStackTrace();
        }

        return valid;
    }

    /**
     * 获取当前季度
     * 
     * @return String
     */
    public static String getCurrentQuarter() {
        String quarter = null;
        Calendar mydate = Calendar.getInstance();
        Double dd = new Double(Math.floor(mydate.get(Calendar.MONTH) / 3d));
        switch (dd.intValue()) {
            case 0:
                quarter = "1";
                break;
            case 1:
                quarter = "2";
                break;
            case 2:
                quarter = "3";
                break;
            case 3:
                quarter = "4";
                break;
        }
        return quarter;
    }

    /**
     * 根据日期获取所属季度
     * 
     * @param sDate1 java.lang.String
     * @return String
     */
    public static String getQuarterByDay(String sDate1) {
        String quarter = "";
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date1 = null;
        try {
            date1 = dateFormat.parse(sDate1);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getQuarterByDay()");
            System.err.println("sDate1:" + sDate1);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "";
        }
        Calendar mydate = Calendar.getInstance();
        mydate.setTime(date1);
        Double dd = new Double(Math.floor(mydate.get(Calendar.MONTH) / 3d));
        switch (dd.intValue()) {
            case 0:
                quarter = "1";
                break;
            case 1:
                quarter = "2";
                break;
            case 2:
                quarter = "3";
                break;
            case 3:
                quarter = "4";
                break;
        }
        return quarter;
    }

    /**
     * 获取与当前日期相差若干天的日期
     * 
     * @return java.lang.String
     * @param dif int
     */
    public static String getDate(int dif) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取与当前日期相差若干天的日期
     * 
     * @return java.lang.String
     * @param dif int
     */
    public static String getdifDate(int dif) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取与指定日期相差若干天的日期
     * 
     * @return java.lang.String
     * @param aDate java.lang.String
     * @param dif int
     */
    public static String getDate(String aDate, int dif) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = null;
        try {
            date = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDate()");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取与指定日期相差若干天的日期
     * 
     * @return java.lang.String
     * @param aDate java.lang.String
     * @param dif int
     */
    public static String getDatenew(String aDate, int dif) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date = null;
        try {
            date = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDate()");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dif);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取指定日期一个月前的一天
     * 
     * @param aDate java.lang.String
     * @return java.lang.String
     */
    public static String getDateBeforeAMonth(String aDate) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date1 = null;
        try {
            date1 = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDateBeforeAMonth(String)");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    // 修改增加方法用于assistant.schedule--------begin------------->
    /**
     * 获取指定日期下个月的同一天
     * 
     * @param aDate String
     * @return java.lang.String
     */
    public static String getDateAfterMonth(String aDate) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date1 = null;
        try {
            date1 = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDateBeforeAMonth(String)");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取指定日期下个月的某一天
     * 
     * @param aDate String
     * @param n int
     * @return java.util.Date
     */
    public static String getDateAfterMonth(String aDate, int n) {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date date1 = null;
        try {
            date1 = dateFormat.parse(aDate);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in getDateBeforeAMonth(String)");
            System.err.println("aDate:" + aDate);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, n);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取指定日期所在月的最后一天
     * 
     * @param selectDate String
     * @return int
     */
    public static int getLastDate(String selectDate) {
        // Validate
        int dates = 0;
        int year;
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(DateFormat.getDateInstance().parse(selectDate));
        } catch (ParseException e) {
        }
        year = calendar.get(Calendar.YEAR);
        System.out.println(calendar.get(Calendar.MONTH));
        switch (calendar.get(Calendar.MONTH) + 1) {
            case 1:
                dates = 31;
                break;
            case 2:
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    dates = 29;
                } else {
                    dates = 28;
                }
                break;
            case 3:
                dates = 31;
                break;
            case 4:
                dates = 30;
                break;
            case 5:
                dates = 31;
                break;
            case 6:
                dates = 30;
                break;
            case 7:
                dates = 31;
                break;
            case 8:
                dates = 31;
                break;
            case 9:
                dates = 30;
                break;
            case 10:
                dates = 31;
                break;
            case 11:
                dates = 30;
                break;
            case 12:
                dates = 31;
                break;
        }
        return dates;
    }

    // 修改增加方法用于assisitant.schedule---------end---------->
    /**
     * 获取当前日期后的一天
     * 
     * @return java.lang.String
     */
    public static String getNextDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取当前日期前的一天
     * 
     * @return java.lang.String
     */
    public static String getPreviousDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * Change date format. From: yyyy-MM-dd To: yyyy.MM.dd
     * 
     * @param oldValue String
     * @return String
     */
    public static String changeDateFormat(String oldValue) {
        String newValue = new String("2000.01.01");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        DateFormat df = DateFormat.getDateInstance();
        Date temp = null;
        try {
            temp = df.parse(oldValue);
        } catch (ParseException e) {
            System.err
                    .println("Catch invalid date format in method changeDateFormat(String oldValue) in class DateUtility.");
            System.err.println("Your input parameter:oldValue(" + oldValue + ")");
        }
        newValue = sdf.format(temp);
        return newValue;
    }

    /**
     * 由日期和时分秒来构成一个java.sql.Date
     * 
     * @param aDay String
     * @param aHour String
     * @param aMinute String
     * @param aSecond String
     * @return java.sql.Date
     */
    public static java.sql.Date constructDate(String aDay, String aHour, String aMinute, String aSecond) {
        java.sql.Date sDate = null;
        Date uDate = null;
        int hour, minute, second;
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            uDate = dateFormat.parse(aDay);
            hour = Integer.parseInt(aHour);
            minute = Integer.parseInt(aMinute);
            second = Integer.parseInt(aSecond);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in DateUtility");
            System.err.println("aDay:" + aDay);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Application log:Catch Exception in DateUtility");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        uDate = calendar.getTime();
        sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    /**
     * @param aDay String
     * @return java.sql.Date
     */
    public static java.sql.Date constructDate(String aDay) {
        return constructDate(aDay, "0", "0", "0");
    }

    /**
     * 由日期和时分秒来构成一个java.sql.Timestamp
     * 
     * @param aDay String
     * @param aHour String
     * @param aMinute String
     * @param aSecond String
     * @return java.sql.Timestamp
     */
    public static java.sql.Timestamp constructTimestamp(String aDay, String aHour, String aMinute, String aSecond) {
        java.sql.Timestamp timestamp = null;
        Date uDate = null;
        int hour, minute, second;
        DateFormat dateFormat = DateFormat.getDateInstance();
        try {
            uDate = dateFormat.parse(aDay);
            hour = Integer.parseInt(aHour);
            minute = Integer.parseInt(aMinute);
            second = Integer.parseInt(aSecond);
        } catch (ParseException e) {
            System.err.println("Application log:Catch Exception in DateUtility");
            System.err.println("aDay:" + aDay);
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Application log:Catch Exception in DateUtility");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        uDate = calendar.getTime();
        timestamp = new java.sql.Timestamp(uDate.getTime());
        return timestamp;
    }

    /**
     * 由日期来构成一个java.sql.Timestamp 获取上个月的第一天
     * 
     * @return String
     */
    public static String getFirstDateOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-");
        String s = df.format(calendar.getTime());
        s += "01";
        return s;
    }

    /**
     * 获取上个月的最后一天
     * 
     * @return String
     */
    public static String getLastDateOfLastMonth() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        Date uDate = null;
        try {
            uDate = dateFormat.parse(getFirstDateOfMonth());
        } catch (ParseException e) {
            System.err.println("Application log: Catch Exception in DateUtility");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(uDate);
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 获取上年同期的日期
     * 
     * @param curBegin String
     * @param curEnd String
     * @return String[]
     */
    public static String[] getSameOfLastYear(String curBegin, String curEnd) {
        String[] last = new String[2];
        last[0] = (Integer.parseInt(curBegin.substring(0, 4)) - 1) + curBegin.substring(4);
        last[1] = (Integer.parseInt(curEnd.substring(0, 4)) - 1) + curEnd.substring(4);
        return last;
    }

    /**
     * 将日期转换为字符串
     * 
     * @param aDate java.util.Date
     * @param formatString 格式化字符串，如：yyyy-MM-dd
     * @return String
     */
    public static String formatDate(Date aDate, String formatString) {
        if (aDate == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        String s = df.format(calendar.getTime());
        return s;
    }

    /**
     * 由日期获得星期(String)
     * 
     * @param s yyyy-MM-dd
     * @return EEE
     */
    public static String getDay(String s) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dayFormatter = new SimpleDateFormat("EEE");
        ParsePosition pos = new ParsePosition(0);
        Date giveDate = dateFormatter.parse(s, pos);
        return dayFormatter.format(giveDate).toString();
    }

    /**
     * 将日期由字符串转成日期型
     * 
     * @param s yyyy-MM-dd
     * @return yyyy-MM-dd
     */
    public static Date getDateD(String s) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        return dateFormatter.parse(s, pos);
    }

    /**
     * 将星期由字符串转成日期型
     * 
     * @param s EEE
     * @return EEE
     */
    public static Date getDayD(String s) {
        SimpleDateFormat dayFormatter = new SimpleDateFormat("EEE");
        ParsePosition pos = new ParsePosition(0);
        return dayFormatter.parse(s, pos);
    }

    /**
     * 对时间进行格式化
     */
    public static Date getPattrnDate(Date d) {
        Date parse = d;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = f.format(d);
        try {
            parse = f.parse(format);
        } catch (Exception e) {
            // LogUtils.info("日期转换失败");
        }

        return parse;
    }

    /**
     * 对时间进行格式化
     */
    public static String getPattrnDateStr(Date d) {
        Date parse = d;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = f.format(d);

        return format;
    }

    /**
     * 将时间由字符串转成日期型
     * 
     * @param s HH:mm:ss
     * @return HH:mm:ss
     */
    public static Date getTimeD(String s) {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return timeFormatter.parse(s, pos);
    }

    /**
     * 去当前系统的前一个月的字符串YYYY-mm
     */

    public static String getPreMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        return mon;
    }
}
