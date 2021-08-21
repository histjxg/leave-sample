package profit.jikeshijian.shejimoshi.status;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:00
 * @Description:
 */

public enum  State {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);
    private int value;
    private State(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
