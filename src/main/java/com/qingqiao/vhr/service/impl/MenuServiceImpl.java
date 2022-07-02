package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.Hr;
import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.mapper.MenuMapper;
import com.qingqiao.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuByHrId() {
        // 获取当前登录的用户
        // castvar
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getMenuByHrId(hr.getId());
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Override
    public List<Menu> getAllMenusByRID(Integer rid) {
        return menuMapper.getAllMenusByRID(rid);
    }
}
