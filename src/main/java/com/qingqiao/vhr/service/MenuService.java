package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuByHrId();

    List<Menu> getAllMenus();
    List<Menu> getAllMenusByRID(Integer rid);
}
