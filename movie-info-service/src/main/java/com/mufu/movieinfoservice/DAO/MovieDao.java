package com.mufu.movieinfoservice.DAO;

import com.mufu.movieinfoservice.models.HomePageVideos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://35.243.222.32/movie";

    private static final String USER = "root";
    private static final String PASS = "";


    public static List<HomePageVideos> retrieveMovie(List<String> predictedMovies) {
        List<HomePageVideos> res = new ArrayList<>();
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

            for(String movieId : predictedMovies) {
                String sql = "select * from movies where movieId = " + movieId;
//            System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);

                // 展开结果集数据库
                while(rs.next()){
                    // 通过字段检索
                    String title = rs.getString("title");
                    String genres = rs.getString("genres");
                    String youtubeEmbedId = rs.getString("youtubeEmbedId");
                    String imgUrl = rs.getString("imgUrl");
                    res.add(new HomePageVideos(movieId, title, genres, youtubeEmbedId, imgUrl));
                }
                rs.close();
            }
            // 完成后关闭
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
        System.out.println("Retrieve Movie Info done!");
        return res;
    }



//    public static HomePageVideos retrieveMovie(String movieId) {
//        HomePageVideos res = null;
//        Connection conn = null;
//        Statement stmt = null;
//        try{
//            // 注册 JDBC 驱动
//            Class.forName(JDBC_DRIVER);
//
//            // 打开链接
////            System.out.println("connect to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            // 执行查询
//            stmt = conn.createStatement();
//            String sql = "select * from movies where movieId = " + movieId;
////            System.out.println(sql);
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                String title = rs.getString("title");
//                String genres = rs.getString("genres");
//                String youtubeEmbedId = rs.getString("youtubeEmbedId");
//                String imgUrl = rs.getString("imgUrl");
//
//                res = new HomePageVideos(movieId, title, genres, youtubeEmbedId, imgUrl);
//
//                // 输出数据
////                System.out.println("movieId: " + movieId);
////                System.out.println("title: " + title);
////                System.out.println("genres: " + genres);
////                System.out.println("youtubeEmbedId: " + youtubeEmbedId);
////                System.out.println("imgUrl: " + imgUrl);
//            }
//            // 完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        }catch(SQLException se){
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        }catch(Exception e){
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        }finally{
//            // 关闭资源
//            try{
//                if(stmt!=null) stmt.close();
//            }catch(SQLException se2){
//            }// 什么都不做
//            try{
//                if(conn!=null) conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Retrieve Movie Info done!");
//        return res;
//    }

}
