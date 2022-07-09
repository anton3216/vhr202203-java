package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Employee;
import com.qingqiao.vhr.bean.ResponsePageBean;

public interface EmployeeService {
    ResponsePageBean getAllEmps(Integer page, Integer size, String name);

    int addEmp(Employee employee);

    int deleteEmp(Integer id);
}
