package com.qingqiao.vhr.controller.system.basic;

import com.qingqiao.vhr.service.MenuRoleService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/system/basic")
public class MenuRoleController {

    @Autowired
    private MenuRoleService menuRoleService;

//    @DeleteMapping("/menuRole/{rid}")
//    public boolean deleteMenuRoleByRid(@PathVariable Integer rid){
//        if(menuRoleService.deleteMenuRoleByRid(rid) > 0){
//            return true;
//        }
//        return false;
//    }

    @PostMapping("/menuRole")
    public boolean insertMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.insertMenuRole(rid,mids);
    }
}
