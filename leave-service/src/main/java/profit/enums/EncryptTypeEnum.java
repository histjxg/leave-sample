package profit.enums;

/**
 * Description: 记录是否有效
 * 
 * @author: zhangqiang[zhang_qiang@suixingpay.com]
 * @date: 2017年6月16日 下午5:04:30
 * @version: V1.0
 * @review: zhangqiang[zhang_qiang@suixingpay.com]/2017年6月16日 下午5:04:30
 */
public enum EncryptTypeEnum {
    // 加密数据类型,取值范围 0 1 2 3 4 其中0代表手机号类型1代表银行卡号2代表身份证号3代表姓名4代表其他数据",
    PHONE("0", "手机号"),
    BNK_CRD("1", "银行卡"),
    ID_CARD("2", "身份证号"),
    NAME("3", "姓名"),
    OTHER("4", "其它");
    private String type;
    private String msg;

    EncryptTypeEnum(String type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public String getMsg() {
        return msg;
    }

    public static boolean exists(String type) {
        for (EncryptTypeEnum s : EncryptTypeEnum.values()) {
            if (s.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static String getMsgByCode(String type) {
        for (EncryptTypeEnum s : EncryptTypeEnum.values()) {
            if (s.getType().equals(type)) {
                return s.getMsg();
            }
        }
        return null;
    }
}