package profit.enums.business;

public enum PublishStatusEnum {
    /**
     * 待发布
     */
    NOT_PUBLISH("00", "待发布"),
    /**
     * 待汇总
     */
    INIT_PUBLISH("02", "待汇总"),
    /**
     * 已发布
     */
    PUBLISH("01", "已发布");
    private String code;
    private String name;

    PublishStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    /**
     * 通过code获取枚举
     *
     * @param code
     * @return
     */
    public static PublishStatusEnum valueOfEnum(String code) {
        PublishStatusEnum[] types = values();
        for (PublishStatusEnum type : types) {
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
