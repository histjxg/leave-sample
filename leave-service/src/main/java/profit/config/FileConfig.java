package profit.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 文件配置类
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2019年3月25日 下午7:42:34
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2019年3月25日 下午7:42:34
 */
@Configuration
// /Users/huangxiaogen/work/sourceTree/profit-01/profit-core/src/main/env/test/url.properties
@PropertySource(value = "classpath:profit/core/file.properties")
@Data
public class FileConfig {
    @Value("${excel.root.path}")
    private String rootPath;
    @Value("${excel.template.path}")
    private String templatePath;
    @Value("${excel.upload.path}")
    private String uploadPath;

}
