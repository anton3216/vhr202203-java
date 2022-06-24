package com.qingqiao.vhr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String toLogin() throws IOException {
        ResponseBean error = ResponseBean.error("请先登录");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(error);
        return s;
    }
}
