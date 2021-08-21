package profit.jikeshijian.shejimoshi.zhizelianmoshi.ServletFilter;

import org.apache.catalina.core.ApplicationFilterConfig;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午5:32
 * @Description:
 */

/**
 *FilterChain 是如何实现的。
 *1.Servlet 只是一个规范，并不包含具体的实现，所以，Servlet 中 的 FilterChain 只是一个接口定义
 * 2.具体的实现类由遵从 Servlet 规范的 Web 容器来提供
 * 3.比如，ApplicationFilterChain 类就是 Tomcat 提供的 FilterChain 的实现类，源码如下所示。
 *4.为了让代码更易读懂，我对代码进行了简化，只保留了跟设计思路相关的代码片段。
 * 5.完整的代码你可以自行去 Tomcat 中查看。
 *
 *分析 下面代码：
 * 1。ApplicationFilterChain 中的 doFilter() 函数的代码实现比较有技巧，实际上是一个递归调 用。
 * 2。你可以用每个 Filter(比如 LogFilter)的 doFilter() 的代码实现，直接替换 ApplicationFilterChain 的第 12 行代码，一眼就能看出是递归调用了。

 *
 *
 */
public class ApplicationFilterChain  implements FilterChain {
    private int pos = 0; //当前执行到了哪个filter
    private int n; //filter的个数
    private ApplicationFilterConfig[] filters;
    private Servlet servlet;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (pos < n) {
            ApplicationFilterConfig filterConfig = filters[pos++];
//            Filter filter = filterConfig.getFilter();
//          Filter filter = filterConfig.getFilter();
//            filter.doFilter(request, response, this);
        } else {
            // filter都处理完毕后，执行servlet servlet.service(request, response);
        }
    }

    public void addFilter(ApplicationFilterConfig filterConfig) {
        for (ApplicationFilterConfig filter : filters) {
            if (filter == filterConfig) {
                return;
            }
        }
        if (n == filters.length) {//扩容
//            ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n + IN
//            System.arraycopy(filters, 0, newFilters, 0, n);
//            filters = newFilters;
        } filters[n++] = filterConfig;
    }

    /**
     * 1。这样实现主要是为了在一个 doFilter() 方法中，支持双向拦截，既能拦截客户端发送来的请 求
     * 2。也能拦截发送给客户端的响应，你可以结合着 LogFilter 那个例子
     * 3。
     * 4。
     *
     */
    //    @Override
//    public void doFilter(ServletRequest request, ServletResponse response) {
//        if (pos < n) {
//            ApplicationFilterConfig filterConfig = filters[pos++];
//            Filter filter = filterConfig.getFilter();
//            //filter.doFilter(request, response, this);
//            // 把filter.doFilter的代码实现展开替换到这里
//             System.out.println("拦截客户端发送来的请求.");
//             chain.doFilter(request, response);
//            // chain就是this
//            System.out.println("拦截发送给客户端的响应.")
//        } else {
//            // filter都处理完毕后，执行servlet servlet.service(request, response);
//        }
//    }
}
