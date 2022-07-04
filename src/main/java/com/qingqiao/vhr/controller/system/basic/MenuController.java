package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/basic")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public String getAllMenus() throws JsonProcessingException {
        List<Menu> menus = menuService.getAllMenus();
        /*for (Menu menu : menus) {
            System.out.println("一级菜单↓");
            System.out.println(menu.getName());
            List<Menu> children = menu.getChildren();
            System.out.println("二级菜单↓");
            for (Menu child : children) {
                System.out.println(child.getName());
                List<Menu> children1 = child.getChildren();
                System.out.println("三级菜单↓");
                if(children1.size() > 0){
                    for (Menu menu1 : children1) {
                        System.out.println(menu1.getName());
                    }
                }
            }
        }*/
        return new ObjectMapper().writeValueAsString(menus);
    }

    @GetMapping("/menus/{rid}")
    public String getAllMenusByRID(@PathVariable Integer rid) throws JsonProcessingException {
        List<Menu> menus = menuService.getAllMenusByRID(rid);
        /*for (Menu menu : menus) {
            System.out.println("一级菜单↓");
            System.out.println(menu.getName());
            List<Menu> children = menu.getChildren();
            System.out.println("二级菜单↓");
            for (Menu child : children) {
                System.out.println(child.getName());
                List<Menu> children1 = child.getChildren();
                System.out.println("三级菜单↓");
                if(children1.size() > 0){
                    for (Menu menu1 : children1) {
                        System.out.println(menu1.getName());
                    }
                }
            }
        }*/
        return new ObjectMapper().writeValueAsString(menus);
    }
}
