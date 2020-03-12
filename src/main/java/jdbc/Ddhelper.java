package jdbc;

import model.Homework;

import java.sql.*;

public class Ddhelper {

    //声明Connection对象
    public static Connection con;
    //驱动程序名
    public static String driver = "com.mysql.cj.jdbc.Driver";
    //URL指向要访问的数据库名mysql（此处的test是你所use的那个database）
    public static String url = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC";
    //MySQL配置时的用户名
    public static String user = "root";
    //MySQL配置时的密码,此处为自己设置的密码
    public static String password = "000000";
   public static Connection getConnection() {
       try {
           //加载驱动程序
           Class.forName(driver);
           //1.getConnection()方法，连接MySQL数据库！！
           con = DriverManager.getConnection(url, user, password);
           if (!con.isClosed())
               System.out.println("Succeeded connecting to the Database!");

       } catch (ClassNotFoundException | SQLException e) {
           //数据库驱动类异常处理
           System.out.println("Sorry,can`t find the Driver!");
           e.printStackTrace();
       }
       return con;
   }

   public static void main(String[] args){
       System.err.println(getConnection());
   }
}
