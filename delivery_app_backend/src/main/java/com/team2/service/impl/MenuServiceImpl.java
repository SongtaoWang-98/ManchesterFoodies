package com.team2.service.impl;

import com.team2.dao.DishInfoDao;

import com.team2.dao.RestaurantInfoDao;
import com.team2.entity.DishInfo;
import com.team2.entity.RestaurantInfo;
import com.team2.service.MenuService;
import com.team2.util.DataUtil;
import com.team2.vo.DishGroupVO;
import com.team2.vo.DishVO;
import com.team2.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private DishInfoDao dishInfoDao;

    @Autowired
    private RestaurantInfoDao restaurantInfoDao;

    @Override
    public MenuVO menuShow(Integer restaurantId) {
        List<DishGroupVO> dishGroupVOList = new ArrayList<>();
        List<String> groupList = dishInfoDao.findDishGroupsByRestaurantId(restaurantId);
        for(String s: groupList) {
            List<DishVO> dishVOList = new ArrayList<>();
            List<DishInfo> dishInfoList = dishInfoDao.findByRestaurantIdAndDishGroup(restaurantId,s);
            for(DishInfo dishInfo: dishInfoList) {
                dishVOList.add(new DishVO(
                        dishInfo.getDishId(),
                        dishInfo.getDishName(),
                        dishInfo.getDishDescription(),
                        dishInfo.getDishPrice(),
                        dishInfo.getDishTrend(),
                        dishInfo.getDishImg()
                ));
            }
            dishGroupVOList.add(new DishGroupVO(
                    s, dishVOList
            ));
        }

        RestaurantInfo restaurantInfo = restaurantInfoDao.findRestaurantById(restaurantId);
        return new MenuVO(
                restaurantInfo.getRestaurantId(),
                restaurantInfo.getRestaurantName(),
                restaurantInfo.getRestaurantDistance(),
                DataUtil.calDeliveryFee(restaurantInfo.getRestaurantDistance()),
                restaurantInfo.getRestaurantStars(),
                DataUtil.evalComment(restaurantInfo.getRestaurantStars()),
                restaurantInfo.getRestaurantStyle(),
                restaurantInfo.getRestaurantImg(),
                restaurantInfo.getRestaurantDescription(),
                restaurantInfo.getDiscount(),
                DataUtil.evalDeliveryTime(restaurantInfo.getRestaurantDistance()),
                dishGroupVOList);
    }
}
