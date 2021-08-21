package profit.jikeshijian.bingfaxitong40wen;

//@Aspect
//public class Tracer {
//    @Around(value = "execution(public methodsig)", argNames = "pjp") //executio
//    public Object trace(ProceedingJoinPoint pjp) throws Throwable {
//        TraceContext traceCtx = TraceContext
//                .get(); // 获取追踪上下文，上下文的初始 String requestId = reqCtx.getRequestId(); // 获取 requestId
//        String sig = pjp.getSignature().toShortString(); // 获取方法签名
//        boolean isSuccessful = false;
//        String errorMsg = "";
//        Object result = null;
//        long start = System.currentTimeMillis();
//        try {
//            result = pjp.proceed();
//            isSuccessful = true;
//            return result;
//        } catch (Throwable t) {
//            isSuccessful = false;
//            errorMsg = t.getMessage();
//            return result;
//        } finally {
//            long elapseTime = System.currentTimeMillis() - start;
//            Logs.info("rid : " + requestId + ", start time: " + start + ", elap
//        }
//    }
//}
