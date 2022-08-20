1、注册

```
POST localhost:8383/register
```

参数

```json
registerForm
```

返回

```json
同登录
```

2、登录

```
POST localhost:8383/login
```

参数

```
loginForm
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        id: 1,
      	name: "Krystal",
      	code_msg: "SUCCESS"
    }
}
或者
{
    "code": 1,
    "msg": "fail",
    "data": {
        id: null,
      	name: null,
      	code_msg: "Wrong password" 
    }
}
```



3、餐厅列表

```
GET localhost:8383/home
```

参数

```json
无
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "restaurants": [
            {
                "id": 1,
                "name": "Nando's",
                "distance": 0.5,
                "delivery_fee": 1.25,
                "stars": 3.6,
                "comment": "General",
                "style": "Chicken",
                "img": "1",
                "discount": 1.0
            },
            {
                "id": 2,
                "name": "Burger King",
                "distance": 2.0,
                "delivery_fee": 5.0,
                "stars": 3.9,
                "comment": "General",
                "style": "Burgers",
                "img": "1",
                "discount": 0.75
            }
          ...
        ]
    }
}
```

4、某餐厅的菜单

```
GET localhost:8383/menu/1
```

参数

```json
id = 1
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "id": 1,
        "name": "Nando's",
        "distance": 0.5,
        "delivery_fee": 1.25,
        "stars": 3.6,
        "comment": "General",
        "style": "Chicken",
        "img": "../static/Nando's_poster.jpg",
        "description": "We might be famous for flame-grilled PERi-PERi chicken, but there’s plenty more where that comes from. From PERi-Salted Chips, crunchy Coleslaw, freshly grilled Corn on the Cob and minty Macho Peas, there’s enough to make just about any mouth water.",
        "discount": 1.0,
        "estimate_time": "10-20 minutes",
        "groups": [
            {
                "group": "Starters",
                "dishes": [
                    {
                        "id": 1,
                        "name": "Spicy Mixed Olives",
                        "description": "Spicy mixed olives co-starring mushrooms, garlic and red pepper.",
                        "price": 3.70,
                        "trend": null,
                        "img": "../static/Nando's_Olives.jpg"
                    },
                    {
                        "id": 2,
                        "name": "Halloumi Sticks & Dip",
                        "description": "Five chunky sticks of grilled halloumi with chilli jam for dipping.",
                        "price": 3.95,
                        "trend": null,
                        "img": "../static/Nando's_Halloumi.jpg"
                    }
                ]
            },
            {
                "group": "PERi-PERi Chicken",
                "dishes": [
                    {
                        "id": 3,
                        "name": "1/2 Chicken",
                        "description": "One breast and one leg, flame-grilled and infused with PERi-PERi. Served on the bone with crispy skin, in your choice of spice.",
                        "price": 7.75,
                        "trend": "Popular",
                        "img": "../static/Nando's_1/2Chicken.jpg"
                    },
                    {
                        "id": 5,
                        "name": "4 Boneless Chicken Thighs",
                        "description": "Flame-grilled with crispy skin. Infused with PERi-PERi and served in your choice of spice.",
                        "price": 7.95,
                        "trend": "Popular",
                        "img": "../static/Nando's_4Thighs.jpg"
                    }
                ]
            },
            {
                "group": "Burgers",
                "dishes": [
                    {
                        "id": 6,
                        "name": "Grilled Chicken Pitta",
                        "description": "Chicken breast infused with PERi-PERi and grilled to your favourite spice.",
                        "price": 6.75,
                        "trend": null,
                        "img": "../static/Nando's_Pitta.jpg"
                    }
                ]
            }
        ]
    }
}

{
    "code": 0,
    "msg": "success",
    "data": {
        "id": 2,
        "name": "Burger King",
        "distance": 2.0,
        "delivery_fee": 3.50,
        "stars": 3.9,
        "comment": "General",
        "style": "Burgers",
        "img": "../static/BurgerKing_poster.jpg",
        "description": "Elevating the humble burger to royal status, Burger King hardly needs an introduction. Founded in Miami in the 1950s, the Whopper® has reigned supreme in the UK since 1977.",
        "discount": 0.8,
        "estimate_time": "15 - 20 minutes",
        "groups": [
            {
                "group": "Starters",
                "dishes": []
            },
            {
                "group": "PERi-PERi Chicken",
                "dishes": []
            },
            {
                "group": "Burgers",
                "dishes": []
            },
            {
                "group": "Bundles",
                "dishes": [
                    {
                        "id": 8,
                        "name": "Bacon Double Duo",
                        "description": "2x Large Bacon Double Cheeseburger Meals",
                        "price": 13.99,
                        "trend": null,
                        "img": "../static/BurgerKing_BaconDoubleDuo.jpg"
                    },
                    {
                        "id": 9,
                        "name": "Feast for 4",
                        "description": "2x Whopper/Chicken Royale, 2x Bacon Double Cheeseburger, 2x Large Onion Rings, 2x Large Fries, 4x Reg Bottled Drinks, 1x 20pc Nuggets",
                        "price": 33.99,
                        "trend": null,
                        "img": "../static/BurgerKing_FeastFor4.jpg"
                    }
                ]
            },
            {
                "group": "Meals",
                "dishes": [
                    {
                        "id": 10,
                        "name": "Double Whopper Meal",
                        "description": "Two flame-grilled beef patties topped with juicy tomatoes, fresh cut lettuce, mayo, pickles, white onions and a swirl of ketchup on a soft sesame seed bun. Meals are served with large fries or onion rings and a soft drink of your choice.",
                        "price": 9.29,
                        "trend": "Popular",
                        "img": "../static/BurgerKing_DoubleWhopperMeal.jpg"
                    },
                    {
                        "id": 11,
                        "name": "Chicken Royale Meal",
                        "description": "Tasty chicken wrapped in a special crisp coating, topped with iceberg lettuce, mayo and crowned with a toasted sesame seed bun. Served with large fries or onion rings and a soft drink of your choice.",
                        "price": 7.99,
                        "trend": "Popular",
                        "img": "../static/BurgerKing_ChickenRoyaleMeal.jpg"
                    }
                ]
            },
            {
                "group": "Kids Meal",
                "dishes": [
                    {
                        "id": 12,
                        "name": "Chicken Nuggets Kids Meal",
                        "description": "Bite-sized Chicken Nuggets, coated in a crispy tempura. Served with a portion of fries or apple slices and a drink of your choice.",
                        "price": 4.79,
                        "trend": null,
                        "img": "../static/BurgerKing_ChickenKidsMeal.jpg"
                    }
                ]
            }
        ]
    }
}
```

5、添加购物车

```
POST localhost:8383/cart/add?userId=1&dishId=1&dishNum=2
```

参数

```json
userId 用户id，登录时保存。 dishId 点击菜品的id   dishNum 菜的个数
```

返回

```json
成功
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
失败
{
    "code": 1,
    "msg": "fail",
    "data": "It exists in cart"
}
```

6、查看购物车

```
GET localhost:8383/cart?userId=1
```

参数

```json
userId 用户id，登录时保存
```

返回

```json
购物车不为空：
{
    "code": 0,
    "msg": "success",
    "data": {
        "restaurant": "Nando's",
        "time": "Less than 10 minutes",
        "items": [
            {
                "id": 6,
                "name": "Halloumi Sticks & Dip",
                "num": 2,
                "price": 7.90
            },
            {
                "id": 7,
                "name": "Grilled Chicken Pitta",
                "num": 8,
                "price": 54.00
            }
        ],
        "discount": 1.0,
        "cut_price": 0.000,
        "subtotal": 61.900,
        "delivery_fee": 0,
        "order_total": 61.900
    }
}
购物车为空：
{
code: 1,
msg: "fail",
data: "Empty"
}
触发购物车为空的唯一条件是删除购物车最后一个菜，此时应该重定向到菜单页
```

7、删除购物车一个菜

```
PUT localhost:8383/cart/delete?id=2
```

参数

```json
id 为购物车中该菜的id，在查看购物车属性中给出
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
```

8、删除购物车所有菜 在退出该餐厅时应该清空当前餐厅购物车，否则会出现问题

```
PUT localhost:8383/cart/deleteAll?userId=1
```

参数

```json
userId 用户id，登录时保存
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
```

9、修改

```
PUT localhost:8383/cart/update?id=1&dishNum=2
```

参数

```json
id 为购物车中该菜的id，在查看购物车属性中给出 dishNum 为修改后的菜数
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
```

10、添加地址

```
POST localhost:8383/address/add
```

参数

```json
addressForm 表单
其中属性：
userId 
name
address
postcode
tel
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
```

11、查看已保存地址

```
GET localhost:8383/address?userId=1
```

参数

```json
userId 用户id
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "addresses": [
            {
                "id": 4,
                "name": "fff",
                "address": "1111fdafa",
                "postcode": "kdasfd",
                "tel": "102038"
            },
            {
                "id": 5,
                "name": "ddd",
                "address": "aadddfff",
                "postcode": "lkjhdf",
                "tel": "123"
            },
            {
                "id": 6,
                "name": "ggg",
                "address": "ffffsss",
                "postcode": "343df",
                "tel": "321"
            }
        ]
    }
}
```

12、删除地址

```
PUT localhost:8383/address/delete?addressId=1
```

参数

```json
addressId 11中给的地址id
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
```

13、查看余额

```
GET localhost:8383/order/balance?userId=1
```

参数

```json
userId 用户id
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": 2000.00
}
```

14、创建订单

```
POST localhost:8383/order/create?userId=1&addressId=1&paymentMethod=balance
```

参数

```json
userId 用户id addressId 11中给的地址id paymentMethod 支付方式
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
或
{
    "code": 0,
    "msg": "fail",
    "data": "Insufficient balance"
}
```

15、查看订单列表

```
GET localhost:8383/order/all?userId=4
```

参数

```json
userId 用户id 
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": {
        "orders": [
            {
                "state": "Arrival",
                "restaurant": "Nando's",
                "img": "../static/Nando's_poster.jpg",
                "time": "20/04/2021",
                "total": 12.85
            }
          ...
        ]
    }
}
```



16、查看当前用户是否为VIP

```
GET localhost:8383/user/isVip?userId=1
```

参数

```json
userId 用户id 
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": true
}
或者
{
    "code": 0,
    "msg": "success",
    "data": false
}
```

17、充值

```
PUT localhost:8383/user/recharge?userId=1&amount=10
```

参数

```json
userId 用户id  amount 充值金额
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
```

18、开通会员

```
PUT localhost:8383/user/membership?userId=1&paymentMethod=card
```

参数

```json
userId 用户id  paymentMethod 支付方式
```

返回

```json
{
    "code": 0,
    "msg": "success",
    "data": "SUCCESS"
}
或者
{
    "code": 1,
    "msg": "fail",
    "data": "Insufficient balance"
}
```

