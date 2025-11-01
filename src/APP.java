import  com.lingti.tooltest.commonTool;
import com.lingti.beantest.User;

import java.util.ArrayList;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("-------------欢迎来到学生管理系统----------------");
            System.out.println("1：登录");
            System.out.println("2：注册");
            System.out.println("3：忘记密码");
            System.out.println("4：退出系统");
            System.out.println("请输入您的选择:");
            switch (sc.nextInt()) {
                case 1 :
                    System.out.println("请开始登录");
                    logIn(list);
                    break;
                case 2 :
                    System.out.println("请开始注册");
                    signIn(list);
                    break;
                case 3 :
                    System.out.println("请开始更改密码");
                    forgetThePassword(list);
                    break;
                case 4 :
                    System.out.println("即将退出");
                    System.exit(0);
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }
    }

    public static void logIn(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        // 录入用户名
        System.out.print("请输入用户名:");
        user.setUserName(sc.next());
        if (user.isUserNameExist(user.getUserName(), list) == null) {
            System.out.println("用户名未注册，请先注册");
            return;
        }
        // 判断验证码
        while (true) {
            String verificationCode = commonTool.random5();
            System.out.println("请输入验证码"+ verificationCode);
            if (sc.next().equals(verificationCode)) {
                break;
            } else {
                System.out.println("错误，请重新输入");
            }
        }

        // 录入密码
        for (User listuser : list) {
            if (user.getUserName().equals(listuser.getUserName())) {
                user.setPassWord(listuser.getPassWord());
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("请输入密码:");
            if (sc.next().equals(user.getPassWord())) {
                studentSystem st_system = new studentSystem();
                st_system.initStudentSystem();
                break;
            } else if (i < 2) {
                System.out.println("错误，请重新输入。还剩" + (2 - i) + "次机会");
            } else {
                System.out.println("密码错误");
            }
        }
    }

    public static void signIn(ArrayList<User> list) {
        // 注册
        Scanner sc = new Scanner(System.in);
        User user = new User();
        // 用户名输入
        System.out.print("请输入用户名:");
        user.setUserName(sc.next());
        if (!user.isValidUserName(user.getUserName(), list)) {
            System.out.println("注册失败");
            return;
        }
        // 密码输入
        System.out.print("请输入密码:");
        user.setPassWord(sc.next());
        System.out.print("请再次输入密码:");
        if (!sc.next().equals(user.getPassWord())) {
            System.out.println("密码不一致");
            System.out.println("注册失败");
            return;
        }
        // 身份证号码输入
        System.out.print("请输入身份证号码:");
        user.setIdentityCard(sc.next());
        if (!user.isValidIdentityCard(user.getIdentityCard())) {
            System.out.println("注册失败");
            return;
        }
        // 手机号输入
        System.out.print("请输入手机号码:");
        user.setPhoneNumber(sc.next());
        if (!user.isValidPhoneNumber(user.getPhoneNumber())) {
            System.out.println("注册失败");
            return;
        }
        list.add(user);
        System.out.println("注册成功");
    }

    public static void forgetThePassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        // 录入用户名
        System.out.print("请输入用户名:");
        user.setUserName(sc.next());
        if (user.isUserNameExist(user.getUserName(), list) == null) {
            System.out.println("用户名未注册，请先注册");
            return;
        }
        // 录入身份证号码和手机号码
        System.out.print("请输入身份证号码:");
        user.setIdentityCard(sc.next());
        System.out.print("请输入手机号码:");
        user.setPhoneNumber(sc.next());
        User listUser = user.isUserNameExist(user.getUserName(), list);
        if (!user.getIdentityCard().equals(listUser.getIdentityCard()) || !user.getPhoneNumber().equals(listUser.getPhoneNumber())) {
            System.out.println("账号信息不匹配，修改失败");
            return;
        }
        System.out.print("请输入更改后的密码:");
        listUser.setPassWord(sc.next());
    }
}
