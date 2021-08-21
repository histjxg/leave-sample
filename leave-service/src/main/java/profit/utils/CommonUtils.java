package profit.utils;

/**
 * Description: CommonUtils Controller Copyright: ©2015 suixingpay. All rights
 * reserved. Created on: 2015-03-24 15:13:32
 *
 * @author JY
 */
public class CommonUtils {

    static String[] units = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };
    static char[] numArray = { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };

    /**
     * 将Integer类型(正整数)阿拉伯数字转化成汉字数字
     * 
     * @param num
     * @return
     */
    public static String formatIntegerToChinese(int num) {
        char[] val = String.valueOf(num).toCharArray();
        int len = val.length;
        StringBuilder sb = new StringBuilder();
        if (0 < num) {// 针对正整数
            for (int i = 0; i < len; i++) {
                String m = val[i] + "";
                int n = Integer.valueOf(m);
                boolean isZero = n == 0;
                String unit = units[(len - 1) - i];
                if (isZero) {
                    if ('0' == val[i - 1]) {
                        // not need process if the last digital bits is 0
                        continue;
                    } else {
                        // no unit for 0
                        sb.append(numArray[n]);
                    }
                } else {
                    sb.append(numArray[n]);
                    sb.append(unit);
                }
            }
        } else {
            // 小于0或等于0时，设置为空
            sb.append("");
        }
        return sb.toString();
    }
}
