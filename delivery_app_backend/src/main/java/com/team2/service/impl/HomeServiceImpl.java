package com.team2.service.impl;

import com.team2.dao.RestaurantInfoDao;
import com.team2.entity.RestaurantInfo;
import com.team2.service.HomeService;
import com.team2.util.DataUtil;
import com.team2.vo.HomeVO;
import com.team2.vo.RestaurantVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private RestaurantInfoDao restaurantInfoDao;

    @Override
    public HomeVO findAllRestaurants() {
        List<RestaurantInfo> restaurantInfoList = restaurantInfoDao.findAllRestaurants();
        List<RestaurantVO> restaurantVOList = new ArrayList<>();

        for(RestaurantInfo r: restaurantInfoList) {
            restaurantVOList.add(new RestaurantVO(
                    r.getRestaurantId(),
                    r.getRestaurantName(),
                    r.getRestaurantDistance(),
                    DataUtil.calDeliveryFee(r.getRestaurantDistance()),
                    r.getRestaurantStars(),
                    DataUtil.evalComment(r.getRestaurantStars()),
                    r.getRestaurantStyle(),
                    r.getRestaurantImg(),
                    r.getDiscount()
            ));
        }
        return new HomeVO(restaurantVOList);
    }
}
