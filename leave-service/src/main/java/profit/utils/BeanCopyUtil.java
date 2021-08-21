package profit.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 实体类属性赋值工具类
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2019年3月25日 下午8:29:52
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2019年3月25日 下午8:29:52
 */
public class BeanCopyUtil {

    static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<String, BeanCopier>();

    // BeanCopier这个代理类在创建的时候比较耗时，所以创建好的话最好存起来，下次使用的时候直接从map中取值
    // 使用BeanCopier出现的问题：如果srcObj和destObj中相同的属性名称，但是属性类型不一致就会报错
    public static void copy(Object srcObj, Object destObj) {
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, null);
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + "#" + destClazz.getName();
    }

}
