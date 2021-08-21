package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午4:00
 * @Description:
 */

/**
 * 1。在上面的代码实现中，我们利用工厂类来缓存 ChessPieceUnit 信息(也就是 id、text、color)。
 * 2。通过工厂类获取到的 ChessPieceUnit 就是享元。
 * 3。所有的 ChessBoard 对象共享 这 30 个 ChessPieceUnit 对象(因为象棋中只有 30 个棋子)
 * 4。在使用享元模式之前，记录 1 万个棋局，我们要创建 30 万(30*1 万)个棋子的 ChessPieceUnit 对象。
 * 5。利用享元模式，我们只需要创建 30 个享元对象供所有棋局共享使用即可，大大节省了内存。
 *代码结构：
 * 1。它的代码实现非常简单，主要是通过工厂模式
 * 2。在工厂类中，通过一个 Map 来缓存已经创建过的享元对象，来达到复用的目的。
 * 3。
 *
 *
 *
  */
public class ChessBoardNew {
    private Map<Integer, ChessPieceNew> chessPieces = new HashMap<>();
    public ChessBoardNew() {
        init();
    }
    private void init() {
        chessPieces.put(1, new ChessPieceNew(
                ChessPieceUnitFactory.getChessPiece(1), 0,0));
        chessPieces.put(1, new ChessPieceNew(
                ChessPieceUnitFactory.getChessPiece(2), 1,0)); //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId, int toPositionX, int toPositionY) { //...省略...
    }
}
