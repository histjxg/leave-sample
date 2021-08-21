package profit.enums.business;

public enum QrcodeActicityTypeEnum {

    /*
     * 20 蓝海活动 21 智慧餐饮 22 四方支付宝 23 四方微信 24 银联1000元含以下 25 银联1000元以上
     */
    QRCODE_ACTIVITY_TYPE("00", "二维码普通活动"), ZFB_ACTIVITY_TYPE("20", "蓝海活动"), WEIXIN_QUERY_TYPE("21", "智慧套餐"), ICM_ZFB_ACTIVITY_TYPE(
            "22", "四方支付宝"), ICM_WEIXIN_QUERY_TYPE("23", "四方微信"), YL_1000_DOWN_ACTIVITY_TYPE("24", "银联1000元含以下"), YL_1000_UP_ACTIVITY_TYPE(
            "25", "银联1000元以上");
    private String code;
    private String name;

    QrcodeActicityTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 通过code获取枚举
     *
     * @param code
     * @return
     */
    public static QrcodeActicityTypeEnum valueOfEnum(String code) {
        QrcodeActicityTypeEnum[] types = values();
        for (QrcodeActicityTypeEnum type : types) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
