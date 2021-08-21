package profit.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 工具类
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2019年5月16日 下午3:57:06
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2019年5月16日 下午3:57:06
 */
@Configuration
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext contex) throws BeansException {
        applicationContext = contex;
    }

    public static ApplicationContext getContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        return (T) applicationContext.getBean(beanId);
    }

    public static Map<String, Object> getCommonDataMap() {
        return getBean("commonData");
    }

}
