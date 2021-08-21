package profit.jikeshijian.shujujiegou.String;

import java.util.LinkedList;
import java.util.Queue;

public class AcNode36 {


    public char data;
    public AcNode36[] children = new AcNode36[26]; // 字符集只包含a~z这26个字符 public boolean isEndingChar = false; // 结尾字符为true
    public int length = -1; // 当isEndingChar=true时，记录模式串长度
    public AcNode36 fail; // 失败指针
    public AcNode36 root; // 失败指针

    public boolean isEndingChar;

    public AcNode36(char data) {
        this.data = data;
    }

    public void buildFailurePointer() {
        Queue<AcNode36> queue = new LinkedList<>();

        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode36 p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode36 pc = p.children[i];
                if (pc == null)
                    continue;
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode36 q = p.fail;
                    while (q != null) {
                        AcNode36 qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                        }
                        break;
                    }
                    q = q.fail;
                    if (q == null) {
                        pc.fail = root;
                    }
                }

                queue.add(pc);
            }
        }
    }

    public void match(char[] text) { // text是主串
        int n = text.length;
        AcNode36 p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }

            p = p.children[idx];
            if (p == null)
                p = root; // 如果没有匹配的，从root开始重新匹配
            AcNode36 tmp = p;
            while (tmp != root) { // 打印出可以匹配的模式串
                if (tmp.isEndingChar == true) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }


}
