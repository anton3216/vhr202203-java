package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.Employee;
import com.qingqiao.vhr.bean.ResponsePageBean;
import com.qingqiao.vhr.mapper.EmployeeMapper;
import com.qingqiao.vhr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public ResponsePageBean getAllEmps(Integer page, Integer size, String name) {
        if(page != null && page != 1){
            page = (page - 1) * size;
        }
        Integer total = employeeMapper.getTotal(name);
        List<Employee> allEmps = employeeMapper.getAllEmps(page, size, name);
        ResponsePageBean bean = new ResponsePageBean();
        bean.setData(allEmps);
        bean.setTotal(total);
        return bean;
    }

    @Override
    public int addEmp(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    @Override
    public int deleteEmp(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }
}
