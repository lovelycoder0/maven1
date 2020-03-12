package jdbc;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbc {
    public static List<Student> selectAll() {
        //定义连接数据库
        Connection con=Ddhelper.getConnection();
        //要执行的SQL语句
        String sql = "select * from student";

        List<Student> list = new ArrayList<>();
        //遍历查询结果集
        try {
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();

            //ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            int id=0;
            int stuid=0;
            int homeid=0;

            while (rs.next()) {
                Student sh = new Student();

                sh.setStuid(rs.getInt("stuid"));
                sh.setStuname(rs.getString("stuname"));
                list.add(sh);

            }

        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }

        return list;
    }

    public static void add(Student sh){
        //定义连接数据库
        Connection con=Ddhelper.getConnection();
        //要执行的SQL语句
        String sql = "insert into student(stuid,stuname) values(?,?) ";

        try {
            //创建statement类对象，用来执行SQL语句！！
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,sh.getStuid());
            pst.setString(2,sh.getStuname());


            int count = pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }

    }

    public static void main(String[] args) {
        List<Student> list=selectAll();
        for (Student sh:list){
            System.out.println(sh.getStuid());
        }
    }
}

