package com.qingqiao.vhr.service.impl;
import com.qingqiao.vhr.bean.Department;
import com.qingqiao.vhr.mapper.DepartmentMapper;
import com.qingqiao.vhr.service.DeptService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepts() {
        return departmentMapper.getAllDepts();
    }

    @Override
    public int insertDept(Department department) {
        // 添加
        int i = departmentMapper.insertSelective(department);
        // 查询
        Department parentDept = departmentMapper.selectByPrimaryKey(department.getParentId());
        // 修改
        department.setDepPath(parentDept.getDepPath() + "." + department.getId());
        int i1 = departmentMapper.updateByPrimaryKeySelective(department);

        parentDept.setParent(true);
        int i2 = departmentMapper.updateByPrimaryKeySelective(parentDept);
        return i2;
    }

    @Override
    public ResponseBean deleteDept(Integer id) {
        // 查询当前部门是否有子部门
        // 查询当前部门是否有员工
        Department dept = departmentMapper.selectDeptById(id);
        if(dept.getEmployees().size() != 0){
            return ResponseBean.error("该部门下有员工,删除失败!");
        }else if(dept.getParent()){
            return ResponseBean.error("该部门下有子部门,删除失败!");
        }
        // 删除
        int i = departmentMapper.deleteByPrimaryKey(id);
        if(i > 0){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}
