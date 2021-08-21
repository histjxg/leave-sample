package profit.bean;

import lombok.Data;

/**
* @author : 翁平<weng_ping@suixingpay.com>
* @version : V1.0
* @Description : 行政区划代码
* @date : 2019/8/27 0001 下午 13:57
*/

@Data

public class UserRegion {

    private String regionCode;

    private String regionName;

    private Integer regionLevel;

    private String parentRegionCode;

    private String shortName;



}
