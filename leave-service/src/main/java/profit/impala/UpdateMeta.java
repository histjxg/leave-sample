package profit.impala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateMeta {

    static String JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    static String CONNECTION_URL = "jdbc:hive2://172.16.173.190:21050";

    public static void main(String[] args) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            Class.forName(JDBC_DRIVER);
            String user = "impala";

            String password = "8a4AFf90a0A";
            con = DriverManager.getConnection(CONNECTION_URL,user,password);
            ps = con.prepareStatement("select count(distinct t.trandt) profitValue from test_t_trandata_extend_part t where t.mno = '836393454110854'  and t.transts = 'S'   and cast(t.tranamt as decimal) >= cast('1' as decimal) and t.trandt between '20190921' and '20190926';");
            rs = ps.executeQuery();
           /* while (rs.next()) {
                System.out.println(rs.getString(1) + '\t' + rs.getLong(2));
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭rs、ps和con
        }
    }
}
