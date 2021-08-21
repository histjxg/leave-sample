package profit.jikeshijian.shejimoshi.zhizelianmoshi.SpringInterceptor;

import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/19/下午5:51
 * @Description:
 */

/**
 * 1.它也是基于职责链模式实现的。其中，HandlerExecutionChain 类是职责链模式中 的处理器链。它
 *2.它的实现相较于 Tomcat 中的 ApplicationFilterChain 来说，逻辑更加清 晰，不需要使用递归来实现，
 *原因：
 * 1主要是因为它将请求和响应的拦截工作，拆分到了两个函数中 实现
 * 2。在 Spring 框架中，DispatcherServlet 的 doDispatch() 方法来分发请求，它在真正的业 务逻辑执行前后
 * 3。执行 HandlerExecutionChain 中的 applyPreHandle() 和 applyPostHandle() 函数，用来实现拦截的功能
 * 4。具体的代码实现很简单，你自己应该能脑补出来，这里就不罗列了
 *
 */
//public class HandlerExecutionChain {
//    private final Object handler;
//    private HandlerInterceptor[] interceptors;
//
//    public void addInterceptor(HandlerInterceptor interceptor) {
//        initInterceptorList().add(interceptor);
//    }
//
//    boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        HandlerInterceptor[] interceptors = getInterceptors();
//        if (!ObjectUtils.isEmpty(interceptors)) {
//            for (int i = 0; i < interceptors.length; i++) {
//                HandlerInterceptor interceptor = interceptors[i];
//                if (!interceptor.preHandle(request, response, this.handler)) {
//                    triggerAfterCompletion(request, response, null);
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndVie mv) throws Exception {
//        HandlerInterceptor[] interceptors = getInterceptors();
//        if (!ObjectUtils.isEmpty(interceptors)) {
//            for (int i = interceptors.length - 1; i >= 0; i--) {
//                HandlerInterceptor interceptor = interceptors[i];
//                interceptor.postHandle(request, response, this.handler, mv);
//            }
//        }
//    }
//
//    void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, Exception ex)
//            throws Exception {
//        HandlerInterceptor[] interceptors = getInterceptors();
//        if (!ObjectUtils.isEmpty(interceptors)) {
//            for (int i = this.interceptorIndex; i >= 0; i--) {
//                HandlerInterceptor interceptor = interceptors[i];
//                try {
//                    interceptor.afterCompletion(request, response, this.handler, ex);
//                } catch (Throwable ex2) {
//                    logger.error("HandlerInterceptor.afterCompletion threw exception", ex2);
//                }
//            }
//        }
//    }
//}
