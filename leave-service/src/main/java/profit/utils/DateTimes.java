package profit.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 日期工具类
 * 
 * @author Qilun Jiang
 */
public final class DateTimes {
    //
    private static AtomicReference<DateTimeProvider> PROVIDER = new AtomicReference<DateTimeProvider>();
    static {
        PROVIDER.set(new DefaultDateTimeProvider());
    }

    //
    private static final int MIN_YEAR = 0;
    private static final int MAX_YEAR = 9999;
    private static final int MIN_MONTH = 0;
    private static final int MAX_MONTH = 11;
    private static final int MIN_DAY_OF_MONTH = 1;
    private static final int MAX_DAY_OF_MONTH = 31;
    private static final int DAYS_OF_MONTH[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    //
    private static String[] PATTERNS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMddHHmmssSSS" };

    /**
     * 获取当前日期
     */
    public static Date currentDate() {
        return date(now());
    }

    /**
     * 获取当前时间
     */
    public static Date currentTime() {
        return now();
    }

    public static long currentTimeInMillis() {
        return now().getTime();
    }

    /**
     * 获取前一日日期
     */
    public static Date preDate() {
        return addDayOfMonth(currentDate(), -1);
    }

    /**
     * 日期格式化
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);// 非严格解析日期
        return sdf.format(date);
    }

    public static String format(long date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        return sdf.format(new Date(date));
    }

    public static String dateFormat(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(dateStr);
        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return nowDate;
    }

    public static String dateFormatStr(String dateStr) throws ParseException {
        if (null != dateStr && !"".equals(dateStr)) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return new SimpleDateFormat("yyyyMMdd").format(date);
        }
        return dateStr;
    }

    public static String dateFormatStrConver(String dateStr) throws ParseException {
        if (null != dateStr && !"".equals(dateStr)) {
            Date date = new SimpleDateFormat("yyyyMMdd").parse(dateStr);
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        return dateStr;
    }

    public static String dateFormatStrConverMonth(String dateStr) throws ParseException {
        if (null != dateStr && !"".equals(dateStr)) {
            Date date = new SimpleDateFormat("yyyyMM").parse(dateStr);
            return new SimpleDateFormat("yyyy-MM").format(date);
        }
        return dateStr;
    }

    public static String formatCurrentDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        return sdf.format(currentDate());
    }

    public static String formatCurrentTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
        return sdf.format(currentTime());
    }

    public static String lenientlyFormat(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(true);
        return sdf.format(date);
    }

    public static String lenientlyFormat(long date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(true);
        return sdf.format(new Date(date));
    }

    public static String lenientlyFormatCurrentDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(true);
        return sdf.format(currentDate());
    }

    public static String lenientlyFormatCurrentTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(true);
        return sdf.format(currentTime());
    }

    /**
     *
     */
    public static Date parse(String pattern, String source) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            return sdf.parse(source);
        } catch (Exception e) {
            throw new IllegalArgumentException("failed to parse " + source + " by pattern: " + pattern, e);
        }
    }

    public static Date lenientlyParse(String pattern, String source) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(true);
            return sdf.parse(source);
        } catch (Exception e) {
            throw new IllegalArgumentException("failed to parse " + source + " by pattern: " + pattern, e);
        }
    }

    public static Date parse(Object source) {

        if (source == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(source.toString(), PATTERNS);
        } catch (ParseException e) {
            LogUtils.info("异常信息", e);
            return null;
        }
    }

    /**
     *
     */
    public static boolean isWeekend(Date date) {
        final int dayOfWeek = getDayOfWeek(date);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static boolean isLeapYear(Date date) {
        return isLeapYear(getYear(date));
    }

    public static boolean isLeapYear(int year) {
        return new GregorianCalendar().isLeapYear(year);
    }

    public static boolean isSameDay(Date d1, Date d2) {
        assertNotNull(d1, "invalid parameter d1");
        assertNotNull(d2, "invalid parameter d2");
        return date(d1).compareTo(date(d2)) == 0;
    }

    public static boolean isValidDate(int year, int month, int dayOfMonth) {
        //
        if (year < MIN_YEAR || year > MAX_YEAR) {
            return false;
        }
        if (month < MIN_MONTH || month > MAX_MONTH) {
            return false;
        }
        if (dayOfMonth < MIN_DAY_OF_MONTH || dayOfMonth > MAX_DAY_OF_MONTH) {
            return false;
        }

        //
        if (month == 1) {
            if (isLeapYear(year)) {
                if (dayOfMonth > 29) {
                    return false;
                }
            } else {
                if (dayOfMonth > 28) {
                    return false;
                }
            }
        } else {
            if (dayOfMonth > DAYS_OF_MONTH[month]) {
                return false;
            }
        }

        //
        Date gregorianChange = new GregorianCalendar().getGregorianChange();
        final int gcYear = DateTimes.getYear(gregorianChange); // 1582
        final int gcMonth = DateTimes.getMonth(gregorianChange); // Calendar.OCTOBER
        if (year == gcYear && month == gcMonth && (dayOfMonth >= 5 && dayOfMonth <= 14)) {
            return false;
        }
        //
        return true;
    }

    /**
     *
     */
    public static Date date(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date date(Date date) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Time time(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.YEAR, 1970);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return new Time(c.getTimeInMillis());
    }

    public static Time time(Date date) {
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.YEAR, 1970);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return new Time(c.getTimeInMillis());
    }

    public static Date merge(Date date, Time time) {
        //
        final Calendar c1 = Calendar.getInstance();
        c1.setTime(time);

        //
        final Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.HOUR_OF_DAY, c1.get(Calendar.HOUR_OF_DAY));
        c2.set(Calendar.MINUTE, c1.get(Calendar.MINUTE));
        c2.set(Calendar.SECOND, c1.get(Calendar.SECOND));
        c2.set(Calendar.MILLISECOND, 0);
        return c2.getTime();
    }

    /**
     *
     */
    public static java.sql.Date toSqlDate(Date date) {
        if (date == null) {
            return null;
        } else {
            return new java.sql.Date(date.getTime());
        }
    }

    public static Date valueOf(java.sql.Date date) {
        if (date == null) {
            return null;
        } else {
            return new Date(date.getTime());
        }
    }

    public static java.sql.Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return new java.sql.Timestamp(date.getTime());
        }
    }

    public static Date valueOf(java.sql.Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp.getTime());
        }
    }

    public static Date valueOf(long milliSeconds) {
        return new Date(milliSeconds);
    }

    public static Date valueOf(int year, int month, int dayOfMonth) {
        // Precondition checking
        if (!isValidDate(year, month, dayOfMonth)) {
            throw new IllegalArgumentException("invalid parameters, year: " + year + ", month: " + month
                    + ", dayOfMonth: " + dayOfMonth);
        }

        //
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     *
     */
    public static int getYear(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.YEAR);
    }

    public static int getYear(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.MONTH);
    }

    public static int getMonth(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH);
    }

    public static int getDayOfMonth(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayOfMonth(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getWeekOfYear(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getWeekOfYear(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getDayOfWeek(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static int getDayOfWeek(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static int getHourOfDay(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getHourOfDay(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.MINUTE);
    }

    public static int getMinute(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    public static int getSecond(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.SECOND);
    }

    public static int getSecond(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    public static int getMilliSecond(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.get(Calendar.MILLISECOND);
    }

    public static int getMilliSecond(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MILLISECOND);
    }

    public static int getLastDayOfMonth(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getLastDayOfMonth(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date getFirstDateOfMonth(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    public static Date getFirstDateOfMonth(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    public static Date getLastDateOfMonth(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.DAY_OF_MONTH, getLastDayOfMonth(date));
        return c.getTime();
    }

    public static Date getLastDateOfMonth(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, getLastDayOfMonth(date));
        return c.getTime();
    }

    public static int getLastDayOfWeek(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        return c.getActualMaximum(Calendar.DAY_OF_WEEK);
    }

    public static int getLastDayOfWeek(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_WEEK);
    }

    public static Date getFirstDateOfWeek(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }

    public static Date getFirstDateOfWeek(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
    }

    public static Date getLastDateOfWeek(long date) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.set(Calendar.DAY_OF_WEEK, getLastDayOfWeek(date));
        return c.getTime();
    }

    public static Date getLastDateOfWeek(Date date) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, getLastDayOfWeek(date));
        return c.getTime();
    }

    /**
     *
     */
    public static Date addYear(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.YEAR, delta);
        return c.getTime();
    }

    public static Date addYear(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, delta);
        return c.getTime();
    }

    public static Date addMonth(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.MONTH, delta);
        return c.getTime();
    }

    public static Date addMonth(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, delta);
        return c.getTime();
    }

    public static Date addDayOfMonth(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.DAY_OF_MONTH, delta);
        return c.getTime();
    }

    public static Date addDayOfMonth(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, delta);
        return c.getTime();
    }

    public static java.sql.Date addDayOfMonth(java.sql.Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, delta);
        return new java.sql.Date(c.getTimeInMillis());
    }

    public static Date addWeekOfYear(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.WEEK_OF_YEAR, delta);
        return c.getTime();
    }

    public static Date addWeekOfYear(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_YEAR, delta);
        return c.getTime();
    }

    public static Date addHourOfDay(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.HOUR_OF_DAY, delta);
        return c.getTime();
    }

    public static Date addHourOfDay(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, delta);
        return c.getTime();
    }

    public static Date addMinute(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.MINUTE, delta);
        return c.getTime();
    }

    public static Date addMinute(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, delta);
        return c.getTime();
    }

    public static Date addSecond(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.SECOND, delta);
        return c.getTime();
    }

    public static Date addSecond(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, delta);
        return c.getTime();
    }

    public static Date addMilliSecond(long date, int delta) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date);
        c.add(Calendar.MILLISECOND, delta);
        return c.getTime();
    }

    public static Date addMilliSecond(Date date, int delta) {
        assertNotNull(date, "invalid parameter date");
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, delta);
        return c.getTime();
    }

    /**
     *
     */
    public static int compareTime(Date date, int hour, int minute, int second, int millis) {
        //
        assertNotNull(date, "invalid parameter date");

        //
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        final int h = c.get(Calendar.HOUR_OF_DAY);
        if (h - hour != 0)
            return h - hour;
        final int m = c.get(Calendar.MINUTE);
        if (m - minute != 0)
            return m - minute;
        final int s = c.get(Calendar.SECOND);
        if (s - second != 0)
            return s - second;
        final int ms = c.get(Calendar.MILLISECOND);
        return ms - millis;
    }

    /**
     *
     */
    public static DateTimeProvider getProvider() {
        return PROVIDER.get();
    }

    public static void setProvider(DateTimeProvider provider) {
        PROVIDER.set(provider);
    }

    /**
     *
     */
    private static Date now() {
        return getProvider().now();
    }

    private static void assertNotNull(Date date, String message) {
        if (date == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     *
     */
    public static interface DateTimeProvider {

        Date now();
    }

    public static class DefaultDateTimeProvider implements DateTimeProvider {

        @Override
        public Date now() {
            return new Date();
        }
    }

    // 获取上个月的第一天
    public static String getPreviousMonthFirst() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar.getTime());
    }

    // 获取上个月的最后一天
    public static String getPreviousMonthEnd() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return sdf.format(calendar.getTime());

    }

    // 获取某年某月的最后一天
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }

    /**
     * yyyy-MM-dd hh:mm:ss
     * 
     * @param date
     * @return Date
     * @throws Exception
     */
    public static Date strDateToDate(String date) throws Exception {
        DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = timeFormat.parse(date);
        return d;
    }

    /**
     * 根据当前日期算出与给定日期相差的天数
     * 
     * @param date
     * @return Integer
     */
    public static Integer getDayByDate(Date date) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = df.format(new Date());
            long cdlong = df.parse(currentDate).getTime();

            String transferDate = df.format(date);
            long tflong = df.parse(transferDate).getTime();

            Integer result = (int) ((tflong - cdlong) / (1000 * 60 * 60 * 24));
            return result;
        } catch (ParseException e) {
            LogUtils.info("异常信息", e);
        }
        return null;
    }

    /**
     * Description: 用于密钥导出功能的查询处理
     *
     * @author ji_xw@suixingpay.com
     * @date 2015年9月24日下午10:36:55
     * @param @param inputDate
     * @param @param format
     * @param @return
     * @return String
     * @throws
     */
    public static String nextDay(String inputDate, String format) {
        String outDate = null;
        if (!StringUtils.isEmpty(inputDate)) {
            try {
                Date temp = DateUtils.parseDate(inputDate, new String[] { format });
                outDate = DateFormatUtils.format(DateUtils.addDays(temp, 1), format);
            } catch (ParseException e1) {

            }
        }
        return outDate;
    }

    public static String nextDay(Date inputDate, String format) {
        return DateFormatUtils.format(DateUtils.addDays(inputDate, 1), format);
    }

    public static String lastMonthFirstDay(Date inputDate, String format) {
        Date defaultBeginDate = DateUtils.addMonths(inputDate, -1);
        String defaultBegin = DateFormatUtils.format(defaultBeginDate, format);
        return defaultBegin;
    }

    /**
     * @Description: 获取当前系统的前一个月的字符串YYYY-mm
     * @Param:
     * @return:
     * @Author: LiTing [li_ting1@suixingpay.com]
     * @Date: 2018/8/22
     * @Time: 下午4:59
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
     * 结束月份不能大于开始月份12个月
     * 
     * @param beg
     * @param ed
     * @return
     */
    public static boolean checkMonth(String beg, String ed) {
        try {
            boolean result = false;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Date date = format.parse(beg);
            Date date2 = format.parse(ed);
            // 开始时间
            Calendar start = Calendar.getInstance();
            start.setTime(date);
            // 结束时间
            Calendar end = Calendar.getInstance();
            end.setTime(date2);
            if (compareMonth(start, end)) {
                result = true;
            }
            return result;
        } catch (ParseException e) {
            LogUtils.info("转换日期异常", e);
            return false;
        }
    }

    /**
     * 结束月份和开始月份比较
     * 
     * @param start
     * @param end
     * @return
     */
    public static boolean compareMonth(Calendar start, Calendar end) {
        boolean result = false;
        int subMonthCount = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR) == 0)// 相差的月份
        ? end.get(Calendar.MONTH) - start.get(Calendar.MONTH) // 同一年
                : ((end.get(Calendar.YEAR) - start.get(Calendar.YEAR) >= 2)
                // 年数差超过2年
                ? (end.get(Calendar.YEAR) - start.get(Calendar.YEAR) - 1) * 12 + start.getActualMaximum(Calendar.MONTH)
                        - start.get(Calendar.MONTH) + end.get(Calendar.MONTH) + 1
                        : start.getActualMaximum(Calendar.MONTH) - start.get(Calendar.MONTH) + end.get(Calendar.MONTH)
                                + 1); // 年数差为1，Calendar.get(MONTH)
        // 第一月是0，所以+1
        // System.out.println(subMonthCount);
        if (subMonthCount < 0) {// 相差月份必须大于一个月
            result = false;
        } else if (subMonthCount > 12) {
            return false;
        } else {
            result = true;
        }
        return result;
    }
}
