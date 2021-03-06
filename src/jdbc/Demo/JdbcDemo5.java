package jdbc.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行 DDL 语句
 */
public class JdbcDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "");
            //3、定义 sql
            String sql = "create table student2 (id int, name varchar(20))";
            //4、获取执行 sql 对象
            stmt = conn.createStatement();
            //5、执行 sql
            int count = stmt.executeUpdate(sql);
            System.out.println(count);

            if (count > 0) {
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
