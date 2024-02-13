package com.springMvcTest1;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component // 1. 스프링 컨테이너(메모리JVM) 에 빈(객체) 등록
           // 2. HTTP 랑 통신을 안함 @Mapping 필요없음
public class Test1Dao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public Test1Dao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test9", "root", "1234");
        }catch (Exception e ){   System.out.println(e); }
    }

    // 1.
    public boolean create( Test1Dto test1Dto ){
        System.out.println("Test1Dao.create");
        System.out.println("test1Dto = " + test1Dto);
        try {
            String sql = "insert into board( bcontent , bwriter ) values( ? , ? )";
            ps = conn.prepareStatement(sql);
            ps.setString( 1 , test1Dto.getBcontent());
            ps.setString(2 , test1Dto.getBwriter());
            ps.executeUpdate();
            return true;
        }catch ( Exception e ){
            System.out.println(e);
        }
        return false;
    }

    // 2.
    public ArrayList< Test1Dto > findAll( ){
        System.out.println("Test1Dao.findAll");
        ArrayList< Test1Dto > list = new ArrayList<>();
        try {
            String sql = "select * from board";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while ( rs.next() ){
                list.add( new Test1Dto(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                        )
                );
            }
        }catch ( Exception e ){
            System.out.println(e);
        }
        return list;
    }




}
