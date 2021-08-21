package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午3:48
 * @Description:
 */

public class ChessPiece {//棋子
    private int id;
    private String text;
    private Color color;

    private int positionX;
    private int positionY;

    public ChessPiece(int id,String text,Color color,int positionX,int positionY){
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }


}
