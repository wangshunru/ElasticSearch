package com.baizhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/8/11.
 */
public class Employee {
    private  String name;
    private   Integer age;
    private  Double salary;
    private    String depa;

    public Employee() {
    }

    public Employee(String name, Integer age, Double salary, String depa) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.depa = depa;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", depa='" + depa + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepa() {
        return depa;
    }

    public void setDepa(String depa) {
        this.depa = depa;
    }
    public  static List<Employee> createEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三",15,3000.0,"科研"));
        list.add(new Employee("李斯",45,1234.0,"教学"));
        list.add(new Employee("王五",35,33456.0,"科研"));
        list.add(new Employee("罗伊",29,12367.0,"公关"));
        list.add(new Employee("胡歌",39,30000.0,"教学"));
        list.add(new Employee("杨幂",33,3478.0,"教学"));
        list.add(new Employee("迪丽热巴",28,67890.0,"科研"));
        list.add(new Employee("易烊千玺",19,121222.0,"科研"));
        list.add(new Employee("王源",20,121211.0,"教学"));
        list.add(new Employee("王凯",38,222222.0,"科研"));
        list.add(new Employee("源泉",42,33333.0,"教学"));
        list.add(new Employee("赵丽颖",30,34000.0,"公关"));
        list.add(new Employee("何炅",41,3127.0,"科研"));
        list.add(new Employee("谢娜",35,3890.0,"公关"));
        list.add(new Employee("吴昕",31,389.0,"科研"));
        list.add(new Employee("哪吒",3,30.0,"公关"));
        return list;
    }
}
