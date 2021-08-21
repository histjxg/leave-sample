package profit.jikeshijian.shejimoshi.celuemoshi;

import profit.jikeshijian.shejimoshi.mobanmoshi.huidiao.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:01
 * @Description:
 */
//策略接口：EvictionStrategy
// 策略类:LruEvictionStrategy、FifoEvictionStrategy、LfuEvictionStrategy...
// 策略工厂:EvictionStrategyFactory

public class UserCache {
    private Map<String, User> cacheData = new HashMap<>();
//    private EvictionStrategy eviction;
//    public UserCache(EvictionStrategy eviction) {
//        this.eviction = eviction;
//    }
}
