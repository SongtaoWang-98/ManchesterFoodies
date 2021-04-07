package com.team2.service.impl;

import com.team2.dao.DishInfoDao;

import com.team2.entity.DishInfo;
import com.team2.service.MenuService;
import com.team2.vo.DishVO;
import com.team2.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private DishInfoDao dishInfoDao;

    @Override
    public MenuVO menuShow(int id) {
        List<DishInfo> dishInfoList = dishInfoDao.findByRestaurant(id);
        List<DishVO> dishVOList = new ArrayList<>();
        for(DishInfo d: dishInfoList) {
            dishVOList.add(new DishVO(
                    d.getDishId(),
                    d.getDishName(),
                    d.getDishPrice(),
                    d.getDishTaste(),
                    d.getDishImg()
            ));
        }
        return new MenuVO(dishVOList);
    }
}
