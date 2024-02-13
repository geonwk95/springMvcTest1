package com.springMvcTest1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;


@RestController // 1. 스프링 컨테이너(메모리JVM) 에 빈(객체) 등록 // 왜?? 아래 메소드 쓸려고
            // 2. Restful : HTTP GET = @GetMapping /POST = @PostMapping/PUT = @PutMapping/DELETE = @DeleteMapping 요청을 찾는 클래스 --> 스프링이 정해둠
public class Test1Controller {
    @Autowired
    private Test1Dao test1Dao;

    // 1.
    @PostMapping("/test1/create")
    public boolean create( Test1Dto test1Dto ){
        System.out.println("Test1Controller.create");
        System.out.println("test1Dto = " + test1Dto);
        // DAO 호출

        boolean result = test1Dao.create( test1Dto );

        return result;
    }

    // 2.
    @GetMapping("/test1/findall")
    public ArrayList< Test1Dto > findAll( ){
        System.out.println("Test1Dao.findAll");


        ArrayList<Test1Dto> result = test1Dao.findAll();

        return result;
    }

}
