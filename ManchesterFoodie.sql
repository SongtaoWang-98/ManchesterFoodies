-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: delivery_app
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_info`
--

DROP TABLE IF EXISTS `address_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_info` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `address` varchar(64) NOT NULL,
  `postcode` varchar(16) NOT NULL,
  `address_tel` varchar(16) NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `payment_info_user_info_user_id_fk` (`user_id`),
  CONSTRAINT `payment_info_user_info_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_info`
--

LOCK TABLES `address_info` WRITE;
/*!40000 ALTER TABLE `address_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_info`
--

DROP TABLE IF EXISTS `dish_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish_info` (
  `dish_id` int NOT NULL AUTO_INCREMENT,
  `restaurant_id` int NOT NULL,
  `dish_group` varchar(32) NOT NULL,
  `dish_name` varchar(32) NOT NULL,
  `dish_description` varchar(256) DEFAULT NULL,
  `dish_price` decimal(8,2) NOT NULL,
  `dish_trend` varchar(16) DEFAULT NULL,
  `dish_img` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`dish_id`),
  KEY `dish_info_restaurant_info_restaurant_id_fk` (`restaurant_id`),
  CONSTRAINT `dish_info_restaurant_info_restaurant_id_fk` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant_info` (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_info`
--

LOCK TABLES `dish_info` WRITE;
/*!40000 ALTER TABLE `dish_info` DISABLE KEYS */;
INSERT INTO `dish_info` VALUES (1,1,'Starters','Spicy Mixed Olives','Spicy mixed olives co-starring mushrooms, garlic and red pepper.',3.70,NULL,'../static/Nando\'s_Olives.jpg'),(2,1,'Starters','Halloumi Sticks & Dip','Five chunky sticks of grilled halloumi with chilli jam for dipping.',3.95,NULL,'../static/Nando\'s_Halloumi.jpg'),(3,1,'PERi-PERi Chicken','1/2 Chicken','One breast and one leg, flame-grilled and infused with PERi-PERi. Served on the bone with crispy skin, in your choice of spice.',7.75,'Popular','../static/Nando\'s_HalfChicken.jpg'),(5,1,'PERi-PERi Chicken','4 Boneless Chicken Thighs','Flame-grilled with crispy skin. Infused with PERi-PERi and served in your choice of spice.',7.95,'Popular','../static/Nando\'s_4Thighs.jpg'),(6,1,'Burgers','Grilled Chicken Pitta','Chicken breast infused with PERi-PERi and grilled to your favourite spice.',6.75,NULL,'../static/Nando\'s_Pitta.jpg'),(8,2,'Bundles','Bacon Double Duo','2x Large Bacon Double Cheeseburger Meals',13.99,NULL,'../static/BurgerKing_BaconDoubleDuo.jpg'),(9,2,'Bundles','Feast for 4','2x Whopper/Chicken Royale, 2x Bacon Double Cheeseburger, 2x Large Onion Rings, 2x Large Fries, 4x Reg Bottled Drinks, 1x 20pc Nuggets',33.99,NULL,'../static/BurgerKing_FeastFor4.jpg'),(10,2,'Meals','Double Whopper Meal','Two flame-grilled beef patties topped with juicy tomatoes, fresh cut lettuce, mayo, pickles, white onions and a swirl of ketchup on a soft sesame seed bun. Meals are served with large fries or onion rings and a soft drink of your choice.',9.29,'Popular','../static/BurgerKing_DoubleWhopperMeal.jpg'),(11,2,'Meals','Chicken Royale Meal','Tasty chicken wrapped in a special crisp coating, topped with iceberg lettuce, mayo and crowned with a toasted sesame seed bun. Served with large fries or onion rings and a soft drink of your choice.',7.99,'Popular','../static/BurgerKing_ChickenRoyaleMeal.jpg'),(12,2,'Kids Meal','Chicken Nuggets Kids Meal','Bite-sized Chicken Nuggets, coated in a crispy tempura. Served with a portion of fries or apple slices and a drink of your choice.',4.79,NULL,'../static/BurgerKing_ChickenKidsMeal.jpg'),(13,3,'Burger','Hamburger','Two fresh high-quality beef patties hot off the grill, on a soft, toasted bun.',7.95,NULL,'../static/FiveGuys_Hamburger.jpg'),(14,3,'Burger','Bacon Cheeseburger','Our regular two patty-burger with two strips of crispy apple-wood smoked bacon and two slices of melted American cheese.',9.95,'Popular','../static/FiveGuys_BaconCheeseburger.jpg'),(15,3,'Milkshakes','Five Guys Shake','Customise your milkshake with as many of our 11 Mix-ins as you want. For the adventurous, add free bacon bits. For health and safety reasons, if you suffer from a peanut allergy please do not order a milkshake.',5.70,'Popular','../static/FiveGuys_Shake.jpg'),(16,3,'Fries','Regular Five Guys Style\n\n','Hot, fresh boardwalk-style fries. Cut fresh, cooked twice and salted. Our fries are cooked in pure, tasty peanut oil.',5.05,'Popular','../static/FiveGuys_Fries.jpg');
/*!40000 ALTER TABLE `dish_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `cart_id` int NOT NULL,
  `restaurant_id` int NOT NULL,
  `address_id` int NOT NULL,
  `payment_method` varchar(16) NOT NULL,
  `create_time` datetime NOT NULL,
  `order_total` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_info_restaurant_info_restaurant_id_fk` (`restaurant_id`),
  KEY `order_info_user_info_user_id_fk` (`user_id`),
  KEY `order_info_address_info_address_id_fk` (`address_id`),
  CONSTRAINT `order_info_address_info_address_id_fk` FOREIGN KEY (`address_id`) REFERENCES `address_info` (`address_id`),
  CONSTRAINT `order_info_restaurant_info_restaurant_id_fk` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant_info` (`restaurant_id`),
  CONSTRAINT `order_info_user_info_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_info`
--

DROP TABLE IF EXISTS `restaurant_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant_info` (
  `restaurant_id` int NOT NULL AUTO_INCREMENT,
  `restaurant_name` varchar(32) NOT NULL,
  `restaurant_distance` double NOT NULL,
  `restaurant_stars` double DEFAULT NULL,
  `restaurant_style` varchar(32) NOT NULL,
  `restaurant_img` varchar(128) DEFAULT NULL,
  `restaurant_description` varchar(256) DEFAULT NULL,
  `discount` double DEFAULT '1',
  PRIMARY KEY (`restaurant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_info`
--

LOCK TABLES `restaurant_info` WRITE;
/*!40000 ALTER TABLE `restaurant_info` DISABLE KEYS */;
INSERT INTO `restaurant_info` VALUES (1,'Nando\'s',0.5,3.6,'Chicken','../static/Nando\'s_poster.jpg','We might be famous for flame-grilled PERi-PERi chicken, but there’s plenty more where that comes from. From PERi-Salted Chips, crunchy Coleslaw, freshly grilled Corn on the Cob and minty Macho Peas, there’s enough to make just about any mouth water.',1),(2,'Burger King',2,3.9,'Burgers','../static/BurgerKing_poster.jpg','Elevating the humble burger to royal status, Burger King hardly needs an introduction. Founded in Miami in the 1950s, the Whopper® has reigned supreme in the UK since 1977.',0.8),(3,'Five Guys',2.2,4.5,'Burgers','../static/FiveGuys_poster.jpg','Five Guys is how burgers & fries are meant to be. High-quality grain-fed beef, hand cut fries & as many toppings as you like in any combination you like. And that’s before you get to creating your own mix-&-match shakes.',1),(4,'Pizza Hut',1.5,4.6,'Pizza','../static/PizzaHut_poster.jpg','For the first time ever it’s Pizza Hut Restaurants – delivered! Get the restaurant quality Pizza, Sides and Desserts you love from the Hut, at home. Get stuck into our famous Pan and Stuffed Crust Pizzas or new favourites like our Vegan Pizza range!',1),(5,'Lameizi',1.2,4.8,'Chinese food','../static/Lameizi_poster.jpg','FREEBIES 下单满15镑即送！SPECIAL OFFER 特价优惠!',0.75),(6,'Chinese Red Chilli',2.6,4.4,'Chinese food','../static/ChineseRedChilli_poster.jpg','Red Chilli （Oxford Road）Restaurant offers traditional and contemporary Chinese food with over 10 years history. ',1),(7,'Pizza Express',3.1,4.4,'Pizza','../static/PizzaExpress_poster.jpg','With a menu full of favourites – our signature Dough Balls with garlic butter, the pepperoni-packed Classic American Hot or the thinner, crispier Romana Padana with goat\'s cheese, as well our new vegan pizzas and bundles - you’ll be spoilt for choice.',0.8),(8,'Nudo Sushi Box',1.1,3.8,'Japanese food','../static/NudoSushiBox_poster.jpg','Enjoy our wide range of delightful sushi products, ranging from our freshly prepared sashimi selections, futomaki and nigiri boxes, small eats, as well as a variety of soup noodle and hot food options only on Deliveroo !',1),(9,'All Stars',5,4.3,'Chicken','../static/AllStars_poster.jpg','ALL STARS CHICKEN is a classic burger shack, serving the freshest, juiciest and most mouth-watering burgers around.',0.9),(10,'Subway',1.2,3.5,'Sandwiches','../static/Subway_poster.jpg','Meal Deals',1);
/*!40000 ALTER TABLE `restaurant_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_cart`
--

DROP TABLE IF EXISTS `user_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cart_id` int NOT NULL,
  `user_id` int NOT NULL,
  `dish_id` int NOT NULL,
  `dish_num` int NOT NULL,
  `is_paid` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_cart_dish_info_dish_id_fk` (`dish_id`),
  KEY `user_cart_user_info_user_id_fk` (`user_id`),
  CONSTRAINT `user_cart_dish_info_dish_id_fk` FOREIGN KEY (`dish_id`) REFERENCES `dish_info` (`dish_id`),
  CONSTRAINT `user_cart_user_info_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_cart`
--

LOCK TABLES `user_cart` WRITE;
/*!40000 ALTER TABLE `user_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) NOT NULL,
  `user_password` varchar(16) NOT NULL,
  `user_tel` varchar(16) NOT NULL,
  `user_balance` decimal(8,2) DEFAULT '0.00',
  `is_vip` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-28 16:20:09
