package profit.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by histjxg on 2017/12/28.
 */
@Slf4j
public class LogUtils {
    private static Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

    /**
     * 该方法把指定信息字符串记录到日志中
     *
     * @throws Exception
     */
    public static void info(String info) {
        if (null != info) {
//            log.info();
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String str = methodName + ":  " + lineNumber + "   日志信息:";
            logger.info(str + info);
        } else {
            logger.info(info);
        }

    }

    /**
     * 该方法把指定信息字符串记录到日志中
     *
     * @throws Exception
     */
    public static void info(String info, Exception e) {
        if (null != info) {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String str = methodName + ":  " + lineNumber + "   日志信息:";
            logger.info(str + info, e);
        } else {
            logger.info(info, e);
        }

    }

    /**
     * 该方法把指定信息字符串记录到日志中
     *
     * @throws Exception
     */

    /**
     * 该方法把指定的错误信息字符串记录到日志中
     *
     * @throws Exception
     */
    public static void error(String error) {
        if (null != error) {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String str = methodName + ":  " + lineNumber + "   日志信息:";
            logger.info(str + error);
        } else {
            logger.error(error);
        }

    }

    /**
     * 该方法把指定的Exceptiopn对象，包含异常堆栈信息记录到日志中
     */
    public static void error(Exception e) {
        if (null != e.getMessage()) {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String str = methodName + ":  " + lineNumber + "   日志信息:";
            logger.error(str + e.getMessage(), e);
        } else {
            logger.error(e.getMessage(), e);
        }

    }

    /**
     * 该方法把指定的Exceptiopn对象，包含异常堆栈信息记录到日志中，并指定异常其他描述
     */
    public static void error(String error, Exception e) {
        if (null != error) {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
            String str = methodName + ":  " + lineNumber + "   日志信息:";
            logger.error(str + error, e);
        } else {
            logger.error(error, e);
        }

    }

}
