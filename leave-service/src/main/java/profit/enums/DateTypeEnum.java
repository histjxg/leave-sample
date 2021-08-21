package profit.enums;

import java.util.Calendar;

public enum DateTypeEnum {
    DAY(Calendar.DAY_OF_YEAR, "天"),
    MONTH(Calendar.MONTH, "月"),
    YEAR(Calendar.YEAR, "年"),
    HOUR(Calendar.HOUR, "时"),
    MINUTE(Calendar.MINUTE, "分"),
    SECOND(Calendar.SECOND, "秒"),;

    private int code;

    private String name;

    DateTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
