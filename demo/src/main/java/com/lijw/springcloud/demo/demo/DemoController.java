package com.lijw.springcloud.demo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lijw
 * @date 2021/5/19 15:56
 */
@Controller
public class DemoController {

    @GetMapping("hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getRemoteAddr());
        System.out.println("this is hello");
//        response.sendRedirect("https://www.baidu.com");
        return "redirect:http://localhost:8080/hello2";
    }

    @GetMapping("hello2")
    public String hello2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getRemoteAddr());
        System.out.println("this is hello2");
//        response.sendRedirect("https://www.baidu.com");
        return "redirect:https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html";
    }
}
