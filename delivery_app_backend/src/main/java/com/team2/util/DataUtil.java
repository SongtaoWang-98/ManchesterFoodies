package com.team2.util;

import java.math.BigDecimal;

public class DataUtil {
    public static BigDecimal calDeliveryFee(double distance) {
        return BigDecimal.valueOf(distance * 2.5);
    }

    public static String evalComment(double stars) {
        String comment;
        if(stars >= 4.8) comment = "Perfect";
        else if(stars >= 4.5) comment = "Excellent";
        else if (stars >= 4.0) comment = "Good";
        else if (stars >= 3.5) comment = "General";
        else comment = "Bad";
        return comment;
    }

    public static String evalDeliveryTime(double distance) {
        if(distance <= 0.5) return "Less than 10 minutes";
        else if(distance <= 1.0) return "10 - 15 minutes";
        else if(distance <= 2.0) return "15 - 20 minutes";
        else if(distance <= 3.0) return "20 - 30 minutes";
        else return "More than 30 minutes";
    }
}
