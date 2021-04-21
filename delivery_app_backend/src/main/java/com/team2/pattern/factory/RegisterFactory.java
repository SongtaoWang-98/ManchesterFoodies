package com.team2.pattern.factory;

public class RegisterFactory {
    public static PersonProfile getPersonProfile(String userName, String userPassword, String userTel, String userType) {
        if(userType.equals("Membership")) return new VipProfile(userName, userPassword, userTel, true);
        else return new UserProfile(userName, userPassword, userTel, false);
    }
}
