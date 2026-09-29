package com.hf;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    /**
     * 方式一：HttpServletResponse 设置响应参数
     *
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //设置响应状态码
        response.setStatus(401);
        //设置响应头
        response.setHeader("name","ithema");
        //设置响应体
        response.getWriter().write("<h1>hello response</h1>");

    }

    /**
     * 方法二：ResponseEntity
     * @return
     */
    @RequestMapping("/response2")//Spring提供
    public ResponseEntity<String> response2(){
        return ResponseEntity.status(401).header("name","javaweb-ai")
                .body("<h1>hello response</h1>");

    }
}
