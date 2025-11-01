import com.lingti.beantest.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class studentSystem {
    public void initStudentSystem() {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop : while (true) {
            while (true) {
                System.out.println("学生管理系统");
                System.out.println("1：添加学生");
                System.out.println("2：删除学生");
                System.out.println("3：忘记密码");
                System.out.println("4：查询学生");
                System.out.println("5：退出登录");
                System.out.println("请输入您的选择:");
                switch (sc.nextInt()) {
                    case 1 :
                        addStudent(list);
                        break;
                    case 2 :
                        deleteStudent(list);
                        break;
                    case 3 :
                        changeStudent(list);
                        break;
                    case 4 :
                        searchStudent(list);
                        break;
                    case 5 :
                        System.out.println("即将退出登录");
                        break loop;
                    default:
                        System.out.println("没有这个选项");
                        break;
                }
            }
        }
    }
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        Student st = new Student();
        System.out.print("学生id:");
        int id = sc.nextInt();
        for (Student student : list) {
            if (id == student.getId()) {
                System.out.println("id已存在");
                return;
            }
        }
        st.setId(id);
        System.out.print("学生姓名:");
        st.setName(sc.next());
        System.out.print("学生年龄:");
        st.setAge(sc.nextInt());
        System.out.print("学生住址:");
        st.setAddress(sc.next());
        list.add(st);
    }

    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("需要删除的学生的id:");
        int id_delete = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id_delete == list.get(i).getId()) {
                list.remove(list.get(i));
                System.out.println("已删除该学生");
                return;
            }
        }
        System.out.println("id不存在");
    }

    public static void changeStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("需要更改的学生的id:");
        int id_change = sc.nextInt();
        for (Student student : list) {
            if (id_change == student.getId()) {
                System.out.println("请录入更改后的信息");
                System.out.print("学生id:");
                student.setId(sc.nextInt());
                System.out.print("学生姓名:");
                student.setName(sc.next());
                System.out.print("学生年龄:");
                student.setAge(sc.nextInt());
                System.out.print("学生住址:");
                student.setAddress(sc.next());
                return;
            }
        }
        System.out.println("id不存在");
    }

    public static void searchStudent(ArrayList<Student> list) {
        if (list.isEmpty() || list.get(0) == null) {
            System.out.println("当前无学生信息，请添加后再查询");
        } else {
            System.out.println("id\t\t\t姓名\t\t年龄\t家庭住址");
            for (Student student : list) {
                System.out.print(student.getId() + "\t\t\t");
                System.out.print(student.getName() + "\t");
                System.out.print(student.getAge() + "\t\t");
                System.out.println(student.getAddress());
            }
        }
    }
}
