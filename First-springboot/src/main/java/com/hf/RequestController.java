package com.hf;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//请求数据的获取
@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式:"+method);

        //获取请求URL地址
        String url = request.getRequestURL().toString();
        System.out.println("请求URL地址:"+url);
        String uri = request.getRequestURI();
        System.out.println("请求URI地址:"+uri);

        //获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议:"+protocol);

        //获取请求参数 - name,age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: "+name+",age: "+age);

        //获取请求头 - accept
        String accept = request.getHeader("accept");
        System.out.println("Accept: "+accept);

        return "ok";



    }
}
