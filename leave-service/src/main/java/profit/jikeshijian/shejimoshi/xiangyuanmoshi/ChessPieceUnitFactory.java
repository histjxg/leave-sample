package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:58
 * @Description:
 */

public class ChessPieceUnitFactory {

    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();
    static {
        pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK)); pieces.put(2, new ChessPieceUnit(2,"馬", ChessPieceUnit.Color.BLACK)); //...省略摆放其他棋子的代码...
    }
    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
