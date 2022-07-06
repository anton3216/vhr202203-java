package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.ResponsePageBean;

public interface EmployeeService {
    ResponsePageBean getAllEmps(Integer page, Integer size, String name);
}
