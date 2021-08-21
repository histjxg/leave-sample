package profit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串工具类
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2019年3月25日 下午8:32:54
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2019年3月25日 下午8:32:54
 */
public class StringUtil {

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0;) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    /**
     * description: 去除字符串前后的空格，若str</code>为<code>null</code>,返回空串
     * 
     * @param str
     * @return
     */
    public static String trim(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * description: 判断<code>str</code>是否为空串或<code>null</code>
     * 
     * @param str
     * @return 若为空串或<code>null</code>返回<code>true</code>,否则返回<code>false</code>
     */
    public static boolean isEmpty(String str) {
        if (null == str)
            return true;
        str = trim(str);
        return "".equals(str) ? true : false;
    }

    /**
     * 给数字型式的日期格式化
     * 
     * @param str
     * @return
     */
    public static String getFomDate(String str) {
        if (null == str || str.equals("")) {
            return "";
        }
        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
            Date date = formatDate.parse(str.trim());
            return StringUtil.getformDatetoStr("yyyy-MM-dd", date);

        } catch (Exception e) {
            LogUtils.info("异常信息", e);
            return "";
        }
    }

    /**
     * 给日期格式化成指定格式
     * 
     * @param format date
     * @return
     */
    public static String getformDatetoStr(String format, Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat(format);
        return null == date ? "" : formatDate.format(date);
    }

    public static int getStrLen(String str) {
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 单字节加1
            if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
                len++;
            } else {
                len += 2;
            }
        }
        return len;
    }

    /**
     * 比较的字符串的是否大于长度
     * 
     * @param checkStr
     * @param length
     * @return
     */
    public static boolean compareStrLen(String checkStr, int length) {
        int strLen = getStrLen(checkStr);
        return strLen > length;

    }

}
