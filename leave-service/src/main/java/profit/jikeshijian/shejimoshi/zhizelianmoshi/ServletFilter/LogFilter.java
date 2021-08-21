package profit.jikeshijian.shejimoshi.zhizelianmoshi.ServletFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午5:27
 * @Description:
 */

/**
 * 说明：
 * 1。添加过滤器非常方便，不需要修改任何代码，定义一个实 现 javax.servlet.Filter 的类，再改改配置就搞定了，完全符合开闭原则
 * 2。那 Servlet Filter 是如何做到如此好的扩展性的呢?我想你应该已经猜到了，它利用的就是职责链模式。
 * 3。
 *
 *
 *
 *
 *
 */
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 在创建Filter时自动调用，
        // 其中filterConfig包含这个Filter的配置参数，比如name之类的(从配置文件中读取的)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("拦截客户端发送来的请求.");
        chain.doFilter(request, response);
        System.out.println("拦截发送给客户端的响应.");
    }

    @Override
    public void destroy() {
        // 在销毁Filter时自动调用
    }
}


// 在web.xml配置文件中如下配置: <filter>
//<filter-name>logFilter</filter-name>
//<filter-class>com.xzg.cd.LogFilter</filter-class>
//</filter>
//<filter-mapping>
//<filter-name>logFilter</filter-name>
//<url-pattern>/*</url-pattern>
//</filter-mapping>