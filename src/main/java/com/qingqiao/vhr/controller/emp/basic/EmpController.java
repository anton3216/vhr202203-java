package com.qingqiao.vhr.controller.emp.basic;

import com.qingqiao.vhr.bean.Employee;
import com.qingqiao.vhr.bean.ResponsePageBean;
import com.qingqiao.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    public ResponsePageBean getAllEmps(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String name) {
        System.out.println(size);
        ResponsePageBean bean = employeeService.getAllEmps(page, size, name);
        return bean;
    }
}
