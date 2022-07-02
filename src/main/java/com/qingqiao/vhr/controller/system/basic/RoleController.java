package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Role;
import com.qingqiao.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public String getAllRoles() throws JsonProcessingException {
        List<Role> roles = roleService.getAllRoles();
        return new ObjectMapper().writeValueAsString(roles);
    }
}
