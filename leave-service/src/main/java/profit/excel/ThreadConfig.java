package profit.excel;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * BAP的数据库链接配置
 *
 * @author: zhangqiang[zhang_qiang@suixingpay.com]
 * @date: Jul 23, 2018 2:52:29 PM
 * @version: V1.0
 * @review: zhangqiang[zhang_qiang@suixingpay.com]/Jul 23, 2018 2:52:29 PM
 */
@Configuration
// 这是一个配置类，与@Service、@Component的效果类似。spring会扫描到这个类，@Bean才会生效，将ThreadPoolBean这个返回值类注册到spring上下文环境中
@EnableConfigurationProperties
// 通过这个注解,
// 将MyWebServerConfigurationProperties这个类的配置到上下文环境中,本类中使用的@Autowired注解注入才能生效
public class ThreadConfig {
    @Bean
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(500);
        threadPoolTaskExecutor.setKeepAliveSeconds(3000);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolTaskExecutor;
    }
}
