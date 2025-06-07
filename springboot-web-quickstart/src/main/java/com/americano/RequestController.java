package com.americano;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {

        // 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式： " + method);

        // 获取请求url地址
        String url = request.getRequestURL().toString();
        System.out.println("请求url地址： " + url);

        String uri = request.getRequestURI();
        System.out.println("请求uri地址： " + uri);

        // 获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议： " + protocol);

        // 获取请求参数 - name, age
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("请求参数 - name: " + name + ", age: " + age);

        // 获取请求头 - Accept
        String accept = request.getHeader("Accept");
        System.out.println("请求头 - Accept: " + accept);

        return "OK";
    }
}
