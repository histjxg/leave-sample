package profit.jikeshijian.shejimoshi.celuemoshi;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午2:04
 * @Description:
 */
// 运行时动态确定，根据配置文件的配置决定使用哪种策略
public class ApplicationRuntime {
    public static void main(String[] args) throws Exception {
//        EvictionStrategy evictionStrategy = null;
        Properties props = new Properties();
        props.load(new FileInputStream("./config.properties"));
        String type = props.getProperty("eviction_type");
//        evictionStrategy = EvictionStrategyFactory.getEvictionStrategy(type);
//        UserCache userCache = new UserCache(evictionStrategy);
        //...
     }
}
