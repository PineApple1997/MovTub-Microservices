package com.mufu.ratingsdataservice.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PredictionDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://35.243.222.32/movie";

    private static final String USER = "root";
    private static final String PASS = "";

    public static List<String> retrievePredictions(String user, int epoch) {
        List<String> res = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
//            System.out.println("connect to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            stmt = conn.createStatement();
            String sql = "select * from predictions where userId = '" + user + "' order by rating desc limit " + (epoch * 40) + " offset " + ((epoch - 1) * 40) + ";";
//            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                String userId = rs.getString("userId");
                String movieId = rs.getString("movieId");
                float predictedRating = rs.getFloat("rating");

                res.add(movieId);

                // 输出数据
//                System.out.print("userId: " + userId);
//                System.out.print(", movieId: " + movieId);
//                System.out.print(", predicted rating: " + predictedRating);
//                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Retrieve predictions done!");
        return res;
    }
}
