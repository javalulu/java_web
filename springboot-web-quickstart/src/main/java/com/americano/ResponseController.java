package com.americano;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {

    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {

        // 设置响应状态码
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // 设置响应头
        response.setHeader("name", "Jack");

        //设置响应体
        response.getWriter().write("<h1>hello response</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> response2() {
        return ResponseEntity
                .status(401)
                .header("name", "Irene")
                .body("<h2>hello response</h2>");
    }
}
