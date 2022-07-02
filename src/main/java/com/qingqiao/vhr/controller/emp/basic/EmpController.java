package com.qingqiao.vhr.controller.emp.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/basic/emp")
public class EmpController {
    @GetMapping("/")
    public void test1() {
        System.out.println("test emp");
    }
}
