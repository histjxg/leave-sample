package profit.jikeshijian.shejimoshi.mobanmoshi.huidiao;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: huangxiaogen
 * @Date: 2020/07/18/下午7:41
 * @Description:
 */

/**
 *
 *JdbcTemplate源码：
 * 1。因为 JdbcTemplate 代码比较多，我只摘抄了部分相关代码，贴到了下面。
 * 2。其中， JdbcTemplate 通过回调的机制，将不变的执行流程抽离出来，放到模板方法 execute() 中
 * 3。将可变的部分设计成回调 StatementCallback，由用户来定制
 * 4。query() 函数是对 execute() 函数的二次封装，让接口用起来更加方便。
 *
 *
 */
public class JdbcTemplateDemo {
//    private JdbcTemplate jdbcTemplate;

    public User queryUser(long id){
        String sql = "select * from user where id="+id;
//        return jdbcTemplate.query(sql, new UserRowMapper()).get(0);
        return null;
    }
    class UserRowMapper implements RowMapper {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setTelephone(rs.getString("telephone"));
            return user;
        }

        @Override
        public int[] getRowsForPaths(TreePath[] path) {
            return new int[0];
        }
    }

}
