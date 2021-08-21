package profit.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式验证工具类
 * 
 * @author Haijun.BI
 */
public class RegexValidateUtil {
    private static final Logger logger = LoggerFactory.getLogger(RegexValidateUtil.class);

    static boolean flag = false;
    static String regex = "";

    /**
     * 验证字符串和正则表达式是否匹配
     *
     * @param str
     * @param regex
     * @return true:验证通过
     */
    public static boolean check(String str, String regex) {
        try {
            logger.info("校验正则入参，str={},regex={}", str, regex);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            flag = matcher.matches();
            logger.info("校验结果flag={}", flag);
        } catch (Exception e) {
            logger.error("校验正则异常e={}", e);
            flag = false;
            logger.info("校验正则异常e={}", e);
        }
        return flag;
    }

    /**
     * 验证非空
     * 
     * @param notEmpty
     * @return true:验证通过
     */
    public static boolean checkNotEmpty(String notEmpty) {
        regex = "^\\s*$";
        return !check(notEmpty, regex);
    }

    /**
     * 验证邮箱
     * 
     * @param email
     * @return true:验证通过
     */
    public static boolean checkEmail(String email) {
        String regex = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        return check(email, regex);
    }

    /**
     * 验证手机号码
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145 电信号码段:133、153、180、189
     * 
     * @param mobilePhone
     * @return true:验证通过
     */

    /**
     * 13[0-9], 14[5,7], 15[0, 1, 2, 3, 5, 6, 7, 8, 9], 17[6, 7, 8], 18[0-9],
     * 170[0-9] 移动号段:
     * 134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
     * ,187,188,147,178,1705 联通号段: 130,131,132,155,156,185,186,145,176,1709
     * 电信号段: 133,153,180,181,189,177,1700
     * 
     * @param mobilePhone
     * @return
     */
    public static boolean checkMobilePhone(String mobilePhone) {
        String regex = "^(1[2-9])\\d{9}$";
        return check(mobilePhone, regex);

    }

    public static boolean checkContect(String no) {
        return checkMobilePhone(no) || checkTelephone(no);
    }

    /**
     * 验证固话号码
     * 
     * @param telephone
     * @return true:验证通过
     */
    public static boolean checkTelephone(String telephone) {
        String reg = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|"
                + "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";
        return check(telephone, reg);
    }

    /**
     * 验证固话号码
     * 
     * @param telephone
     * @return true:验证通过
     */
    public static boolean checkTeleNo(String telephone) {
        String reg = "(?:(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-?\\d+)?)";
        return check(telephone, reg);
    }

    /**
     * 验证传真号码
     * 
     * @param fax
     * @return true:验证通过
     */
    public static boolean checkFax(String fax) {
        String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
        return check(fax, regex);
    }

    /**
     * 验证QQ号码
     * 
     * @param qq
     * @return true:验证通过
     */
    public static boolean checkQQ(String qq) {
        String regex = "^[1-9][0-9]{4,} $";
        return check(qq, regex);
    }

    /**
     * 验证6位数字验证码
     * 
     * @param validCode
     * @return true:验证通过
     */
    public static boolean checkValidCode(String validCode) {
        String regex = "^\\d{6}$";
        return check(validCode, regex);
    }

    /**
     * 验证6位数字支付密码
     * 
     * @param payPwd
     * @return true:验证通过
     */
    public static boolean checkPayPwd(String payPwd) {
        String regex = "^\\d{6}$";
        String regex2 = "^(\\d)\\1+$";
        return (check(payPwd, regex) && !check(payPwd, regex2));
    }

    public static boolean checkLoginPwd(String pwd) {
        String reg = "(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{6,}";// 不能全是字母，也不能全是数字，最少6位长度
        return check(pwd, reg);
    }

    /**
     * 简单检查18位身份证
     *
     * @param idcard
     * @return
     */
    public static boolean check18Idcard(String idcard) {
        String regex = "^(\\d{17})(\\d|[x,X])$";
        return check(idcard, regex);
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    /**
     * 利用正则表达式判断字符串是否是正整数
     * 
     * @param str
     * @return
     */
    public static boolean isJustNumeric(String str) {
        Pattern pattern = Pattern.compile("[1-9]\\d*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    /**
     * 只能有一个小数点
     * 
     * @param str
     * @return
     */
    public static boolean onlyOnePoint(String str) {
        Pattern pattern = Pattern.compile("[^\\.]*\\.[^\\.]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }
    /**
     * 过滤特殊字符
     * 
     * @param str
     * @return
     */
    public static String specialChars(String str) {
        Pattern pattern = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
        Matcher isNum = pattern.matcher(str);
        return isNum.replaceAll("").trim();
    }

}
