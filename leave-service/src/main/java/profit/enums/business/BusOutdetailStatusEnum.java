package profit.enums.business;

public enum BusOutdetailStatusEnum {
    /**
     * 00=待申请
     */
    NO_APPLY("00", "待申请"),
    /**
     * 01=待付款
     */
    NO_PAY("01", "待付款"),

    /**
     * 02=付款失败
     */
    PAY_FAIL("02", "付款失败"),
    /**
     * 03=付款成功
     */
    PAY_SUCCESS("03", "付款成功"),
    /**
     * 04=待审核
     */
    PAY_WAIT("04", "待审核");

    private String code;
    private String name;
    BusOutdetailStatusEnum(String  code, String name) {
        this.code = code;
        this.name = name;
    }
    /**
     * 通过code获取枚举
     *
     * @param code
     * @return
     */
    public static BusOutdetailStatusEnum valueOfEnum(String code) {
        BusOutdetailStatusEnum[] types = values();
        for (BusOutdetailStatusEnum type : types) {
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
