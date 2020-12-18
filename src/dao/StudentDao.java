package dao;

import pojo.Student;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 猫树
 * @date: 2020/12/18
 * @description:
 */
public class StudentDao {
    private static Map<String, Student> studentMap;
    private static int id = 1;

    static {
        //创建一个学生表
        studentMap = new HashMap<String, Student>();

        studentMap.put("1", new Student("1", "张三", 19, "男", "2000-05-29", "2020-12-18 20:15:17", "2020-12-18 20:15:17"));
    }

    //添加方法
    public void add(Student student) {
        if (student.getStudentId() == null) {
            student.setStudentId(++id + "");
        }

        student.setCreateTime(getTime());
        student.setUpdateTime(getTime());
        studentMap.put(student.getStudentId(), student);
    }

    //删除学生信息
    public void delete(String name) {
        for (int i = 1; i <= studentMap.size(); i++) {
            if (studentMap.get(i + "").getStudentName().equals(name)) {
                studentMap.remove(i + "");
            }
        }
    }

    //更改学生信息
    public void update(Student student) {
        student.setUpdateTime(getTime());
        studentMap.put(student.getStudentId(), student);
    }

    //获取所有学生信息
    public void select() {
        for (int i = 1; i <= studentMap.size(); i++) {
            System.out.println(
                    studentMap.get(i + "").getStudentId() + "\t"
                            + studentMap.get(i + "").getStudentName() + "\t"
                            + studentMap.get(i + "").getStudentAge() + "\t\t"
                            + studentMap.get(i + "").getStudentSex() + "\t\t"
                            + studentMap.get(i + "").getStudentBirthday() + "\t"
                            + studentMap.get(i + "").getCreateTime() + "\t\t"
                            + studentMap.get(i + "").getUpdateTime() + "\t"
            );
        }
    }

    //根据学生姓名查询
    public Student selectByName(String name) {
        String id = null;
        for (int i = 1; i <= studentMap.size(); i++) {
            if (studentMap.get(i + "").getStudentName().equals(name)) {
                id = i + "";
            }
        }
        return studentMap.get(id);
    }

    //获取时间
    private static String getTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
