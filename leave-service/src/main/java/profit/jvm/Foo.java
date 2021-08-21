package profit.jvm;
public class Foo {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }

    public static void main(String[] args) {
        String s = new String("abcpost123post456postabc");
        String a[] = s.split("post");
        if (a.length > 0) {
            for (int i = 1; i < a.length - 1; i++) {
                System.out.println(a[i]);
            }

        }
    }
}