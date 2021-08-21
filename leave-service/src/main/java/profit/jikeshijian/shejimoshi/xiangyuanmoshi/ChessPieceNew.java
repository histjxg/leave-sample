package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:59
 * @Description:
 */

public class ChessPieceNew {
    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;
    public ChessPieceNew(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    // 省略getter、setter方法
}
