package com.cunyu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 村雨
 * @version : 1.0
 * @project : Java 实战
 * @package : com.cunyu
 * @className : Student
 * @createTime : 2021/7/31 17:09
 * @email : 747731461@qq.com
 * @公众号 : 村雨遥
 * @website : https://cunyu1943.github.io
 * @description :
 */
public class Student {
    public static Scanner scanner = new Scanner(System.in);
    //    班级
    private String grade;
    //    学号
    private long id;
    //    姓名
    private String name;
    //    高数
    private float math;
    //    英语
    private float english;
    //    体育
    private float sport;
    //    Java
    private float java;
    //    C++
    private float cPlusPlus;
    //    政治
    private float polity;
    //    算法
    private float algorithm;
    //    平均分
    private double average;

    public Student() {
    }

    public Student(String grade, long id, String name, float math, float english, float sport, float java, float cPlusPlus, float polity, float algorithm, double average) {
        this.grade = grade;
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
        this.sport = sport;
        this.java = java;
        this.cPlusPlus = cPlusPlus;
        this.polity = polity;
        this.algorithm = algorithm;
        this.average = average;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getSport() {
        return sport;
    }

    public void setSport(float sport) {
        this.sport = sport;
    }

    public float getJava() {
        return java;
    }

    public void setJava(float java) {
        this.java = java;
    }

    public float getcPlusPlus() {
        return cPlusPlus;
    }

    public void setcPlusPlus(float cPlusPlus) {
        this.cPlusPlus = cPlusPlus;
    }

    public float getPolity() {
        return polity;
    }

    public void setPolity(float polity) {
        this.polity = polity;
    }

    public float getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(float algorithm) {
        this.algorithm = algorithm;
    }

    public double getAvg(Student student) {
        return (student.getAlgorithm() + student.getcPlusPlus() + student.getEnglish() + student.getSport() + student.getJava() + student.getPolity() + student.getMath()) / 7;
    }

    public void setAverage(double average) {
        this.average = average;
    }


    /**
     * @param students 学生对象列表
     * @return
     * @description 录入学生信息
     * @date 2021/4/5 9:14
     * @author cunyu1943
     * @version 1.0
     */
    public void addScore(ArrayList<Student> students) {
        System.out.println("----------录入学生数据----------");
        System.out.println("请依次输入如下数据：");
        long id;
        while (true) {
            System.out.println("学号");
            id = scanner.nextInt();
            if (isValid(students, id)) {
                System.out.println("学号重复，请重新输入");
            } else {
                break;
            }
        }

        System.out.println("年级");
        String grade = scanner.next();
        System.out.println("姓名");
        String name = scanner.next();
        System.out.println("数学");
        float math = scanner.nextFloat();
        System.out.println("英语");
        float english = scanner.nextFloat();
        System.out.println("体育");
        float sport = scanner.nextFloat();
        System.out.println("Java");
        float java = scanner.nextFloat();
        System.out.println("C++");
        float cPlusPlus = scanner.nextFloat();
        System.out.println("政治");
        float polity = scanner.nextFloat();
        System.out.println("算法");
        float algorithm = scanner.nextFloat();

        //        创建对象，并设置属性，然后将其加入学生对象集合
        Student student = new Student();
        student.setId(id);
        student.setGrade(grade);
        student.setName(name);
        student.setMath(math);
        student.setAlgorithm(algorithm);
        student.setEnglish(english);
        student.setcPlusPlus(cPlusPlus);
        student.setJava(java);
        student.setSport(sport);
        student.setPolity(polity);
        //        获取平均分
        double avg = getAvg(student);
        student.setAverage(avg);
        //        添加到集合
        students.add(student);
        //        提示信息
        System.out.println("添加成功");
    }

    /**
     * @param students 学生对象集合
     * @param id       学号
     * @return true，学号重复；false 学号可用
     * @description 判断学号是否可用
     * @date 2021/4/5 9:19
     * @author cunyu1943
     * @version 1.0
     */
    public boolean isValid(ArrayList<Student> students, long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param students 学生对象集合
     * @return
     * @description 显示简单统计数据
     * @date 2021/4/5 10:08
     * @author cunyu1943
     * @version 1.0
     */
    public void showAvg(ArrayList<Student> students) {
        System.out.println("----------输出学生统计数据----------");
        if (students.size() == 0) {
            System.out.println("当前无数据，请先添加数据！");
        } else {
            System.out.println("班级\t\t学号\t\t姓名\t\t平均分");
            System.out.println("---------------------------------");
            for (Student student : students) {
                System.out.format("%s\t\t%d\t\t%s\t\t%.2f\n", student.getGrade(), student.getId(), student.getName(), student.getAvg(student));
            }
        }
    }

    /**
     * @param students 学生对象集合
     * @return
     * @description 查找对应学号学生的成绩信息
     * @date 2021/4/5 12:59
     * @author cunyu1943
     * @version 1.0
     */
    public void lookupStudent(ArrayList<Student> students) {
        System.out.println("----------查找学生成绩----------");
        if (students.size() == 0) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("请输入要查找学生的学号：");
            long id = scanner.nextLong();
            int flag = -1;
            Student student = new Student();
            //        查找对应学号，找到就退出
            for (int i = 0; i < students.size(); i++) {
                student = students.get(i);
                if (student.getId() == id) {
                    flag = i;
                    break;
                }
            }

            if (flag == -1) {
                System.out.println("未找到对应学号的学生，请确认后重新输入！");
            } else {
                System.out.println("对应学号的学生成绩如下：");
                System.out.println("班级\t\t学号\t\t姓名\t\t数学\t\t英语\t\t体育\t\tJava\t\tC++\t\t政治\t\t算法\t\t平均分");
                System.out.format("%s\t%d\t\t%s\t\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n", student.getGrade(), student.getId(), student.getName(), student.getMath(), student.getEnglish(), student.getSport(), student.getJava(), student.getcPlusPlus(), student.getPolity(), student.getAlgorithm(), student.getAvg(student));
                System.out.println("查找信息成功！");
            }
        }

    }

    /**
     * @param students 学生对象集合
     * @return
     * @description 修改对应学号学生的信息
     * @date 2021/4/5 12:59
     * @author cunyu1943
     * @version 1.0
     */
    public void modifyStudent(ArrayList<Student> students) {
        System.out.println("----------修改学生成绩----------");
        if (students.isEmpty()) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("请输入要修改学生的学号：");
            long id = scanner.nextLong();

            for (Student student : students) {
                if (id == student.getId()) {
                    System.out.println("请重新输入该学生的成绩");
                    System.out.println("数学");
                    float math = scanner.nextFloat();
                    System.out.println("英语");
                    float english = scanner.nextFloat();
                    System.out.println("体育");
                    float sport = scanner.nextFloat();
                    System.out.println("Java");
                    float java = scanner.nextFloat();
                    System.out.println("C++");
                    float cPlusPlus = scanner.nextFloat();
                    System.out.println("政治");
                    float polity = scanner.nextFloat();
                    System.out.println("算法");
                    float algorithm = scanner.nextFloat();

                    student.setMath(math);
                    student.setAlgorithm(algorithm);
                    student.setEnglish(english);
                    student.setcPlusPlus(cPlusPlus);
                    student.setJava(java);
                    student.setSport(sport);
                    student.setPolity(polity);
                    //                获取平均分
                    double avg = getAvg(student);
                    student.setAverage(avg);
                    System.out.println("修改成功！");
                } else {
                    System.out.println("未找到对应学号的学生，请确认后重新输入！");
                }
                break;
            }
        }
    }


    /**
     * @param students 学生对象集合
     * @return
     * @description 删除学生成绩
     * @date 2021/4/5 14:28
     * @author cunyu1943
     * @version 1.0
     */
    public void deleteStudent(ArrayList<Student> students) {
        System.out.println("----------删除学生成绩----------");
        if (students.isEmpty()) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            System.out.println("输入要删除学生成绩的学号");
            long id = scanner.nextLong();

            int index = -1;
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (student.getId() == id) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("未找到对应学号学生信息，请确认后再删除！");
            } else {
                students.remove(index);
                System.out.println("----------删除成功----------");
            }
        }
    }

    /**
     * @param students 学生对象集合
     * @return
     * @description 显示所有学生成绩
     * @date 2021/4/5 14:30
     * @author cunyu1943
     * @version 1.0
     */
    public void showAllStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("当前无数据，请先添加数据");
        } else {
            System.out.println("----------所有学生成绩如下----------");
            System.out.println("班级\t\t学号\t\t姓名\t\t数学\t\t英语\t\t体育\t\tJava\t\tC++\t\t政治\t\t算法\t\t平均分");
            for (Student student : students) {
                System.out.format("%s\t%d\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n", student.getGrade(), student.getId(), student.getName(), student.getMath(), student.getEnglish(), student.getSport(), student.getJava(), student.getcPlusPlus(), student.getPolity(), student.getAlgorithm(), student.getAvg(student));
            }
        }
    }

    /**
     * @param students 学生对象集合
     * @return
     * @description 按照平均分排序
     * @date 2021/4/5 14:29
     * @author cunyu1943
     * @version 1.0
     */
    public void sortStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("当前无数据，请添加后重试");
        } else {
            for (int i = 0; i < students.size() - 1; i++) {
                if (students.get(i).getAvg(students.get(i)) < students.get(i + 1).getAvg(students.get(i + 1))) {
                    Student tmp = students.get(i);
                    students.set(i, students.get(i + 1));
                    students.set(i + 1, tmp);
                }
            }

            System.out.println("排序后的学生成绩");
            System.out.println("班级\t\t学号\t\t姓名\t\t数学\t\t英语\t\t体育\t\tJava\t\tC++\t\t政治\t\t算法\t\t平均分");
            for (Student student : students) {
                System.out.format("%s\t%d\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\n", student.getGrade(), student.getId(), student.getName(), student.getMath(), student.getEnglish(), student.getSport(), student.getJava(), student.getcPlusPlus(), student.getPolity(), student.getAlgorithm(), student.getAvg(student));
            }
        }
    }
}
