package profit.jikeshijian.bingfabiancheng;

public final class StringImmutabilityOne28 {
    /**
     *
     如果具备不可变性的类，需要提供类似修改的功能，具体该怎么操作呢？
     方法：
     1。创建一个新的不可变对象，这是与可变对象的一个重要区别
     2。可变对象往往是修改自己的属性。
     3。



    private final char value[];
    // 字符替换
    String replace(char oldChar,
            char newChar) {
        //无需替换，直接返回this
        if (oldChar == newChar){
            return this;
        }

        int len = value.length;
        int i = -1;
      //   avoid getfield opcode
        char[] val = value;
        //定位到需要替换的字符位置
        while (++i < len) {
            if (val[i] == oldChar) {
                break;
            }
        }
        //未找到oldChar，无需替换
        if (i >= len) {
            return this;
        }
        //创建一个buf[]，这是关键
        //用来保存替换后的字符串
        char buf[] = new char[len];
        for (int j = 0; j < i; j++) {
            buf[j] = val[j];
        }
        while (i < len) {
            char c = val[i];
            buf[i] = (c == oldChar) ?
                    newChar : c;
            i++;
        }
        //创建一个新的字符串返回
        //原字符串不会发生任何变化
        return new StringImmutabilityOne28(buf, true);

    }
     */
}
