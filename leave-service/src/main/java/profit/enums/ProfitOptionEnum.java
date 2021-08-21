package profit.enums;

public enum ProfitOptionEnum {
    //00刷卡分润，01二维码分润，02千六封顶分润，03千六非封顶分润04小额双免分润05云闪付分润06支付宝分润07微信分润08营销政策分润09外表分润
    /**
     * 刷卡分润
     */
    CARD_OPTION_TYPE("00", "刷卡分润"),
    /**
     * 二维码分润金额
     */
    QRCODE_OPTION_TYPE("24", "银联二维码分润金额"),

    /**
     * 千六封顶分润
     */
    SIX_CAP_OPTION_TYPE("02", "千六封顶分润"),
    /**
     * 千六非封顶分润
     */
    SIX_NOT_CAP_OPTION_TYPE("03", "千六非封顶分润"),
    /**
     * 小额双免
     */
    SMALL_OPTION_TYPE("04", "小额双免"),
    /**
     * 云闪付分润
     */
    YSF_OPTION_TYPE("05", "云闪付分润"),
    /**
     * 支付宝分润
     */
    ZFB_OPTION_TYPE("20", "支付宝分润"),
    /**
     * 微信分润
     */
    WX_OPTION_TYPE("21", "微信分润"),
    /**
     * 营销政策分润
     */
    MARK_POLI_OPTION_TYPE("08", "营销政策分润"),
    /**
     * 外表分润
     */
    OUT_DETAL_OPTION_TYPE("09", "外表分润");


    private String code;
    private String name;

    ProfitOptionEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    /**
     * 通过code获取枚举
     *
     * @param code
     * @return
     */
    public static ProfitOptionEnum valueOfEnum(String code) {
        ProfitOptionEnum[] types = values();
        for (ProfitOptionEnum type : types) {
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
