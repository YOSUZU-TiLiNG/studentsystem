package com.lingti.beantest;

import java.util.ArrayList;

public class User {
    private String userName = "admin";
    private String passWord = "123456";
    private String identityCard = "123456789123456789";
    private String phoneNumber = "12345678912";

    public User() {
    }

    public User(String userName, String passWord, String identityCard, String phoneNumber) {
        this.userName = userName;
        this.passWord = passWord;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isValidUserName(String userName, ArrayList<User> list) {
        for (User user : list) {
            if (userName.equals(user.getUserName())) {
                System.out.println("用户名已存在");
                return false;
            }
        }
        if (userName.length() < 3 || userName.length() > 15) {
            System.out.println("用户名长度必须在3~15位之间");
            return false;
        }
        int count = 0;
        for (int i = 0; i < userName.length(); i++) {
            char ch = userName.charAt(i);
            if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                System.out.println("只能是字母加数字的组合");
                return false;
            }
            if (Character.isDigit(ch)) {
                count++;
            }
            if (count == userName.length()) {
                System.out.println("不能是纯数字");
                return false;
            }
        }
        return true;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public boolean isValidIdentityCard(String identityCard) {
        if (identityCard.length() != 18) {
            System.out.println("身份证号码长度应为18位");
            return false;
        }
        if (identityCard.charAt(0) == 0) {
            System.out.println("不能以0为开头");
            return false;
        }
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(identityCard.charAt(i))) {
                System.out.println("前17位，必须都是数字");
                return false;
            }
        }
        char ch17 = identityCard.charAt(17);
        if (!Character.isDigit(ch17) && ch17 != 'X' && ch17 != 'x') {
            System.out.println("最后一位应是数字，大写X或小写x");
            return false;
        }
        return true;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            System.out.println("手机号码长度应为11位");
            return false;
        }
        if (phoneNumber.charAt(0) == 0) {
            System.out.println("手机号码不能以0为开头");
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                System.out.println("手机号码必须都是数字");
                return false;
            }
        }
        return true;
    }


    public User isUserNameExist(String userName, ArrayList<User> list) {
        for (User listuser : list) {
            if (userName.equals(listuser.getUserName())) {
                return listuser;
            }
        }
        return null;
    }
}
