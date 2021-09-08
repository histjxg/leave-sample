package profit.heima.cn.itcast.n2;

import lombok.extern.slf4j.Slf4j;
import profit.heima.cn.itcast.Constants;
import profit.heima.cn.itcast.n2.util.FileReader;

@Slf4j(topic = "c.Async")
public class Async {

    public static void main(String[] args) {
        new Thread(() -> FileReader.read(Constants.MP4_FULL_PATH)).start();
        log.debug("do other things ...");
    }

}
