package profit.atguigu.JDK8;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormateThreadLocal {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat> (){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }

}
