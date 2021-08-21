package profit.jikeshijian.shejimoshi.xiangyuanmoshi;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/12/下午4:37
 * @Description:
 */

public class EditorNew {
    private List<CharacterNew> chars = new ArrayList<>();
    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        CharacterNew character = new CharacterNew(c, CharacterStyleFactory.getStyle(font,size,colorRGB));
                chars.add(character);
    }
}
