package controller;

import dao.StudentDao;
import pojo.Student;

/**
 * @author: 猫树
 * @date: 2020/12/18
 * @description:
 */
public class StudentController {
    StudentDao studentDao = new StudentDao();

    public void add(String name, int age, String sex, String birthday) {
        studentDao.add(new Student(name, age, sex, birthday));
    }

    public void delete(String name) {
        studentDao.delete(name);
    }

    public void update(String oldName, String newName, int newAge, String newSex, String newBirthday) {
        Student student = studentDao.selectByName(oldName);
        student.setStudentName(newName);
        student.setStudentAge(newAge);
        student.setStudentSex(newSex);
        student.setStudentBirthday(newBirthday);
        studentDao.update(student);
    }

    public void selectByName(String name) {
        Student student = studentDao.selectByName(name);
        System.out.println(
                student.getStudentId() + "\t"
                        + student.getStudentName() + "\t"
                        + student.getStudentAge() + "\t"
                        + student.getStudentSex() + "\t"
                        + student.getStudentBirthday() + "\t"
                        + student.getCreateTime() + "\t"
                        + student.getUpdateTime() + "\t"
        );
    }

    public void select() {
        studentDao.select();
    }

}
