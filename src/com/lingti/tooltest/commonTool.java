package com.lingti.tooltest;

import java.util.Random;

public class commonTool {
    public static String random4() {
        // 4位验证码，每一位可能是大写小写随机的字母和数字
        Random rd = new Random();
        StringBuilder sb = new StringBuilder(4);
        int[] rdInt = new int[4];
        for (int i = 0; i < rdInt.length; i++) {
            rdInt[i] = rd.nextInt(0, 2);
            if (rdInt[i] == 0) {
                char ch1 = (char)rd.nextInt('0', '9' + 1);
                sb.append(ch1);
            } else if (rdInt[i] == 1) {
                char ch2 = (char)rd.nextInt('a', 'z' + 1);
                char ch3 = (char)rd.nextInt('A', 'Z' + 1);
                int count = rd.nextInt(0, 2);
                if (count == 0) {
                    sb.append(ch2);
                } else if (count == 1) {
                    sb.append(ch3);
                }
            }
        }
        return sb.toString();
    }

    public static String random5() {
        // 5位验证码，由4位大写小写随机的字母和1位数字随机排列组成
        Random rd = new Random();
        StringBuilder sb = new StringBuilder(5);
        int[] rdInt = new int[5];
        int rdNum = rd.nextInt(0, 5);
        for (int i = 0; i < rdInt.length; i++) {
            if (i == rdNum) {
                char ch1 = (char)rd.nextInt('0', '9' + 1);
                sb.append(ch1);
            } else {
                char ch2 = (char)rd.nextInt('a', 'z' + 1);
                char ch3 = (char)rd.nextInt('A', 'Z' + 1);
                int count = rd.nextInt(0, 2);
                if (count == 0) {
                    sb.append(ch2);
                } else if (count == 1) {
                    sb.append(ch3);
                }
            }
        }
        return sb.toString();
    }
}
