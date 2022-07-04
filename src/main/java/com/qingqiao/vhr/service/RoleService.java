package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Integer addRole(Role role);

    int deleteRole(Integer id);
}
