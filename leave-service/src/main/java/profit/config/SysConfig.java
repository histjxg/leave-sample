package profit.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 系统配置类
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2019年3月25日 下午7:43:05
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2019年3月25日 下午7:43:05
 */
@Configuration
///Users/huangxiaogen/work/sourceTree/profit-01/profit-core/src/main/env/test/url.properties
@PropertySource(value = "classpath:profit/core/url.properties")
@Data
public class SysConfig {

    @Value("${vbill.profitQuery.url}")
    private  String vbillProfitQueryUrl;
    @Value("${encryption.encryptions.url}")
    private String encryptionEncryptionsUrl;
    //字符集
    @Value("${vbillAuth.characterset}")
    private String characterset;
    //超时时间
    @Value("${vbillAuth.timeout}")
    private int timeout;
    //超时时间
    @Value("${encryption.phonenumbers.url}")
    private String encryptionPhonenumbersUrl;
    //超时时间
    @Value("${encryption.captcha.url}")
    private String encryptionCaptchaUrl;

}