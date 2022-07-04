package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.Role;
import com.qingqiao.vhr.mapper.RoleMapper;
import com.qingqiao.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public Integer addRole(Role role) {
        role.setName("ROLE_" + role.getName());
        return roleMapper.insertSelective(role);
    }

    @Override
    public int deleteRole(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}
