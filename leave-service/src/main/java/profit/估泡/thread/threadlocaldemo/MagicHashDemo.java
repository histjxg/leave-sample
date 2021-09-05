package profit.估泡.thread.threadlocaldemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 均衡散列在不同的地方
 */
public class MagicHashDemo {
    //黄金分割数
    private static final int HASH_INCREMENT = 0x61c88647;
    public static void main(String[] args) {
        magicHash(16);
        magicHash(32);
    }

    private static void magicHash(int size) {
        int hashCode = 0;
        for (int j = 0; j < size; j++) {
            hashCode = j*HASH_INCREMENT+HASH_INCREMENT;
            System.out.print((hashCode&(size-1))+"   ");
        }
        System.out.println("");
    }
}
