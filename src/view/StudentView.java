package view;

import controller.StudentController;
import pojo.Student;

import java.util.Scanner;

/**
 * @author: 猫树
 * @date: 2020/12/18
 * @description:
 */
public class StudentView {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        boolean flag = false;
        System.out.println("=============================欢迎来到学生管理系统=============================");
        System.out.println("输入1可查询所有学生信息");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.nextInt() == 1) {
                System.out.println("id\t姓名\t年龄\t性别\t生日\t\t创建时间\t\t\t\t\t修改时间\t");
                studentController.select();
                flag = true;
            }
            while (flag) {
                System.out.println("\n\n1-按照学生姓名查询||2-增加||3-修改指定学生的信息||4-删除指定学生的信息||0-退出");
                int nextInt = scanner.nextInt();
                if (nextInt == 1){
                    System.out.println("输入学生姓名");
                    studentController.selectByName(scanner.next());
                    System.out.println("1-查询所有学生信||0-退出");
                    flag = false;
                }else if (nextInt == 2){
                    System.out.println("请输入学生姓名，年龄，性别，生日，用,隔开");
                    String nextLine = scanner.next();
                    String[] split = nextLine.split(",");
                    studentController.add(split[0],Integer.parseInt(split[1]),split[2],split[3]);
                    System.out.println("1-查询所有学生信||0-退出");
                    flag = false;
                }else if(nextInt == 3){
                    System.out.println("输入想要修改的学生姓名");
                    String oldName = scanner.next();
                    System.out.println("输入修改后的学生姓名，年龄，性别，生日，用,隔开");
                    String newStudent = scanner.next();
                    String[] split = newStudent.split(",");
                    System.out.println(split.length);
                    studentController.update(oldName,split[0],Integer.parseInt(split[1]),split[2],split[3]);
                    System.out.println("1-查询所有学生信||0-退出");
                    flag = false;
                }else if(nextInt == 4){
                    System.out.println("输入想要删除的学生姓名");
                    studentController.delete(scanner.next());
                    System.out.println("1-查询所有学生信||0-退出");
                    flag = false;
                }else if(nextInt == 0){
                    return;
                }
            }
        }
    }
}
