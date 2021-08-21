package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:51
 * @Description:
 */

/**
 *
 * 1。为了记录每个房间当前的棋局情况，我们需要给每个房间都创建一个 ChessBoard 棋局对 象
 * 2。因为游戏大厅中有成千上万的房间(实际上，百万人同时在线的游戏大厅也有很多)
 * 3。那保存这么多棋局对象就会消耗大量的内存。有没有什么办法来节省内存呢?
 * 方法：
 *  享元模式就可以派上用场了。
 *分析：
 * 1。像刚刚的实现方式，在内存中会有大量的相似对 象。这些相似对象的 id、text、color 都是相同的
 * 2。唯独 positionX、positionY 不同
 * 3。实际上，我们可以将棋子的 id、text、color 属性拆分出来，设计成独立的类，并且作为享元 供多个棋盘复用。
 * 4。这样，棋盘只需要记录每个棋子的位置信息就可以了。
 *
 */

public class ChessBoard {//棋局
    private Map<Integer,ChessPiece> chessPieces =  new HashMap<>();

    public ChessBoard(){
        init();
    }
    private void init(){
        chessPieces.put(1,new ChessPiece(1,"车",Color.BLACK,0,0));
        chessPieces.put(1,new ChessPiece(2,"马",Color.BLACK,0,1));
        //省略摆放其他棋子的代码
    }

    public void move(int chessPiecId,int toPositionX,int toPositionY){
        //省略
    }
}
