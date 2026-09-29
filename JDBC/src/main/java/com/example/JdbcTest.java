package com.example;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args)  {
        String url = "jdbc:mysql://localhost:3306/web";
        String dbUser = "root";
        String dbPwd = "08230173Lhf";
        //查询
       String sql = "select id,username,password,name,age from user";
       try(Connection conn = DriverManager.getConnection(url,dbUser,dbPwd);
           PreparedStatement pstmt = conn.prepareStatement(sql);
           ResultSet rs = pstmt.executeQuery()){
           while(rs.next()){
               Integer id = rs.getInt("id");
               String username =rs.getString("username");
               String password = rs.getString("password");
               String name = rs.getString("name");
               Integer age = rs.getInt("age");
               System.out.printf("id:%d, username:%s, pwd:%s, name:%s, age:%d%n",
                       id, username, password, name, age);
           }
       }catch (Exception e) {
           e.printStackTrace();
       }
        System.out.println("                    ");
       //带条件查询
        String sql1 = "select id,username,password,name,age from user where id = ?";
       try(Connection conn = DriverManager.getConnection(url,dbUser,dbPwd);
           PreparedStatement pstmt = conn.prepareStatement(sql1)){
           // 给第一个占位符赋值，下标从1开始，不是0！
           pstmt.setInt(1,3);

           try(ResultSet rs = pstmt.executeQuery()){
               if(rs.next()){
                   System.out.println("查到:"+rs.getString("name"));
               }
           }
       } catch (Exception e){
           e.printStackTrace();
       }
        System.out.println("                    ");
       //新增INSERT
        /*
        String sql2 = "insert into user(username,password,name,age) values (?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPwd);
        PreparedStatement pstmt = conn.prepareStatement(sql2)){
            pstmt.setString(1, "sunquan");
            pstmt.setString(2, "666666");
            pstmt.setString(3, "孙权");
            pstmt.setInt(4, 30);

            // executeUpdate 返回影响行数
            int rows = pstmt.executeUpdate();
            System.out.println("新增行数：" + rows);
        }catch (Exception e){
            e.printStackTrace();
        }

         */
        //System.out.println("                    ");
        // 修改id=4的吕布年龄为29
        /*
        String sql3 = "update user set age=? where id=?";
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPwd);
             PreparedStatement pstmt = conn.prepareStatement(sql3)) {
            pstmt.setInt(1,29);
            pstmt.setInt(2,4);
            int rows = pstmt.executeUpdate();
            System.out.println("更新行数："+rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

         */
        //删除
        String sql4 = "delete from user where id = ?";
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPwd);
             PreparedStatement pstmt = conn.prepareStatement(sql4)) {
            pstmt.setInt(1, 8);
            int rows = pstmt.executeUpdate();
            System.out.println("删除行数："+rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
