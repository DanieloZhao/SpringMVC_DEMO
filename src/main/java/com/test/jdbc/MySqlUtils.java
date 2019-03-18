package com.test.jdbc;

import com.test.model.User;

import java.sql.*;

public class MySqlUtils {

    //声明Connection对象
    Connection con;
    //驱动程序名
    String driver = "com.mysql.cj.jdbc.Driver";
    //URL指向要访问的数据库名
    String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "123456";

    private static MySqlUtils m_MySqlUtils;

    public static MySqlUtils Instance()
    {
        if(m_MySqlUtils == null)
        {
            m_MySqlUtils = new MySqlUtils();
        }
        return m_MySqlUtils;
    }

    public void MySqlUtils()  {


    }


    //返回-1表示失败 0表示成功
    public User queryLoginnameAndPassword(String myLoginname, String myPassword)
    {
        User myUser = null;

        try {
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from user";    //从建立的login数据库的login——message表单读取数据
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");
            System.out.println("-----------------");

            String loginname = null;
            while(rs.next())
            {
                //获取stuname这列数据
                loginname = rs.getString("loginname");
                System.out.println(loginname);
                if(myLoginname.equals(loginname)&&myPassword.equals(rs.getString("password")))
                {
                    myUser = new User();
                    myUser.setPassword(myPassword);
                    myUser.setUsername(rs.getString("username"));
                    myUser.setLoginname(rs.getString("loginname"));
                    break;
                }

            }
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return myUser;
    }


    public void insertAUser(User myUser)
    {


        try {
            Class.forName(driver);
            System.out.println("111111111");
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "insert into user(loginname,password,username) values('"+myUser.getLoginname()+"','"+myUser.getPassword()+"','"+myUser.getUsername()+"')";    //插入数据
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
