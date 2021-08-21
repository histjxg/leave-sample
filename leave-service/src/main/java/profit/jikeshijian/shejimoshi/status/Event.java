package profit.jikeshijian.shejimoshi.status;

import com.sun.xml.internal.rngom.digested.DValuePattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午7:21
 * @Description:
 */

public enum Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);
    private int value;

    private Event(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
