package com.team2.pattern.factory;

public class VipProfile implements PersonProfile{
    private final String userName;
    private final String userPassword;
    private final String userTel;
    private final Boolean isVip;

    public VipProfile(String userName, String userPassword, String userTel, Boolean isVip) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userTel = userTel;
        this.isVip = isVip;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getUserPassword() {
        return this.userPassword;
    }

    @Override
    public String getUserTel() {
        return this.userTel;
    }

    @Override
    public Boolean getIsVip() {
        return this.isVip;
    }

    @Override
    public void showPersonProfile() {
        System.out.println("Welcome, new vip " + userName);
    }
}
