package profit.exception;

/**
 * 通用的异常类（运行时异常）
 * 
 * @author: liguang[li_guang@suixingpay.com]
 * @date: 2018年11月14日 下午2:57:58
 * @version: V1.0
 * @review: liguang[li_guang@suixingpay.com]/2018年11月14日 下午2:57:58
 */
public class CommonRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int status;

    public CommonRuntimeException(String message, int status) {
        super(message);
        this.status = status;
    }

    /**
     * 获得信息
     * 
     * @return
     * @see Throwable#getMessage()
     */
    public int getStatus() {
        return status;
    }
}
