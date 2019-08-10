package com.baizhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("liucy", 23, 89.7, "C1"));
        students.add(new Student("huxz", 32, 78.5, "C2"));
        students.add(new Student("kg", 19, 100.0, "C1"));
        students.add(new Student("liuh", 40, 56.5, "C2"));
        students.add(new Student("cpx", 26, 92.5, "C1"));

        //Lambda 表达式
        Filter f1 = new Filter() {
            @Override
            public boolean test(Student s) {
                return s.getScore() > 60;
            }
        };
        //运用Lambda 表达式 简化  前提 接口中只有一个方法实现  编译器会推断
        Filter f2 = (Student s) -> {
            return s.getScore() > 60;
        };
        Filter f3 = (Student s) -> s.getScore() > 60;
        Filter f4 = s -> s.getScore() > 60;

        List<Student> result = filterStudents(students, s -> s.getScore() > 60 && s.getClassNum().equals("C2"));
        for (Student student : result) {
            System.out.println(student);
        }

       /*
        //原始方法
        class Filter1 implements Filter{
            @Override
            public boolean test(Student s) {
                if(s.getClassNum().equals("C1")) return true;
                else return false;
            }
        }*/
        /*//可以用匿名内部类  第二个参数  筛选逻辑  此函数
        List<Student> result1 = filterStudents(students, new Filter1());
        for (Student student : result) {
            System.out.println(student);
        }*/
    }

    //过滤条件
    static List<Student> filterStudents(List<Student> list, Filter filter) {
        List<Student> result = new ArrayList<>();
        for (Student s : list) {
            //如果满足条件  放入集合
            if (filter.test(s)) result.add(s);
        }
        return result;
    }
}

//定义一个接口
interface Filter {
    boolean test(Student s);
}

class Student {
    private String name;
    private int age;
    private Double score;
    private String classNum;

    public Student() {
    }

    public Student(String name, int age, Double score, String classNum) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", classNum='" + classNum + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }
}