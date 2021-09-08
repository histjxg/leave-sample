package profit.heima.cn.itcast.n2;

import lombok.extern.slf4j.Slf4j;
import profit.heima.cn.itcast.Constants;
import profit.heima.cn.itcast.n2.util.FileReader;

@Slf4j(topic = "c.Sync")
public class Sync {

    public static void main(String[] args) {
        FileReader.read(Constants.MP4_FULL_PATH);
        log.debug("do other things ...");
    }

}
