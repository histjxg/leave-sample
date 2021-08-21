package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午4:28
 * @Description:
 */

public class Character {
    private char c;
    private Font font;
    private int size;
    private int colorRGB;

    public Character(char c,Font font,int size,int colorRGB){
        this.c  = c;
        this.font = font;
        this.size = size;
        this.colorRGB  = colorRGB;
    }
}
