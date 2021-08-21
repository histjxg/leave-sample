package profit.jvm;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVVE_HOOK =null;
    public void isAlive(){
        System.out.println("yes ,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVVE_HOOK= this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVVE_HOOK = new FinalizeEscapeGC();
        //对象的第一次成功拯救自己
        SAVVE_HOOK= null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVVE_HOOK!=null){
            SAVVE_HOOK.isAlive();
        }else {
            System.out.println("no, i  am is dead:(");
        }

        //下面这段代码与上面的完全相同，但是这次自救却失败啦
        SAVVE_HOOK = null;
        System.gc();
        //因为finalize方法的优先级很低，所以暂停0。5秒以等待它
        Thread.sleep(500);
        if (SAVVE_HOOK!=null){
            SAVVE_HOOK.isAlive();
        }else {
            System.out.println("no, i am dead :(");
        }
    }
}
