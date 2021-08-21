package profit.enums;

import java.util.Arrays;

/**
 * @Auther: huang_xg
 * @Date: 2019-10-29 12:00
 * @Company: 随行付支付有限公司
 * @maill:   huang_xg@suixingpay.com
 * @Description:  市辖区特殊处理枚举
 */
public enum UserRegionAreaEnum {
    BEI_JING("110000", "110100","北京市"),
    GAS_STATION("120000", "120100","天津市"),
    LOGISTICS_COMPANY("310000", "310100","上海市"),
    GAS_COMPANY("500000", "500100","重庆市");

    private final String parentRegionCode;
    private final String regionCode;
    private final String regionName;

    UserRegionAreaEnum(String parentRegionCode, String regionCode,String regionName) {
        this.parentRegionCode = parentRegionCode;
        this.regionCode = regionCode;
        this.regionName = regionName;
    }

    public static UserRegionAreaEnum parse(String parentRegionCode) {
        return Arrays.stream(UserRegionAreaEnum.values()).filter(t -> t.parentRegionCode.equals(parentRegionCode)).findFirst().orElse(null);
    }

    public String getParentRegionCode() {
        return parentRegionCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }
}
