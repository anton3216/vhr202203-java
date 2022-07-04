package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Role;
import com.qingqiao.vhr.service.RoleService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/role")
    public ResponseBean addRole(@RequestBody Role role) {
        if(roleService.addRole(role) == 1){
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @DeleteMapping("/role/{id}")
    public ResponseBean deleteRole(@PathVariable Integer id){
        if(roleService.deleteRole(id) == 1){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}
