package com.team2.service;

import com.team2.enums.StatusCode;
import com.team2.vo.CartVO;

public interface CartService {
    StatusCode addItem(Integer userId, Integer dishId, Integer dishNum);
    StatusCode deleteItem(Integer id);
    StatusCode deleteAllInCart(Integer userId);
    StatusCode updateItem(Integer id, Integer dish_num);
    CartVO viewCart(Integer userId);
}
