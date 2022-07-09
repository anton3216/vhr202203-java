package com.qingqiao.vhr.controller.emp.basic;

import com.qingqiao.vhr.bean.Employee;
import com.qingqiao.vhr.bean.ResponsePageBean;
import com.qingqiao.vhr.service.EmployeeService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/basic")
//@CacheConfig(cacheNames = "Employee")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
//    @Cacheable(key = "'getAllEmps'",unless = "#name != ''")
    public ResponsePageBean getAllEmps(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String name) {
        System.out.println(size);
        ResponsePageBean bean = employeeService.getAllEmps(page, size, name);
        return bean;
    }

    @PostMapping("/emp")
//    @CacheEvict(key = "'getAllEmps'")
    public ResponseBean insertEmp(@RequestBody Employee employee){
        // 在修改数据之前 删除缓存
        if(employeeService.addEmp(employee) > 0){
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @DeleteMapping("/emp/{id}")
//    @CachePut(key = "'getAllEmps'")
    public ResponseBean insertEmp(@PathVariable Integer id){
        if(employeeService.deleteEmp(id) > 0){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}
