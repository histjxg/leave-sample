package profit.enums;

/**
 * @Description: 渠道商类型枚举类
 * @Param:
 * @return:
 * @Author: LiTing [li_ting1@suixingpay.com]
 * @Date: 2018/8/20
 * @Time: 下午4:44
 */
public enum ChannelBusinessEnum {

    /**
     * 01=代理商
     */
    AGENT("01", "代理商"), /**
     * 02=服务商
     */
    ICM("02", "服务商");

    private String value;
    private String displayName;

    ChannelBusinessEnum(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}
