package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:58
 * @Description:
 */

public class ChessPieceUnit {//享元类
    private int id;
    private String text;
    private Color color;
    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color {
        RED, BLACK
    }
    // ...省略其他属性和getter方法...

}
