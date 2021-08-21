package profit.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by yang_huang on 2017/2/8.
 */
public class UUIDUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 随机生成4位随机数
     * 
     * @return
     */
    public static String getRandom() {

        SecureRandom r = new SecureRandom();
        return String.valueOf(r.nextInt(9000) + 1000);
    }

    public static String getUUID20() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }

}
