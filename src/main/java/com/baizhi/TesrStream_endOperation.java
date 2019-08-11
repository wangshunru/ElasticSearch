package com.baizhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2019/8/11.
 */
public class TesrStream_endOperation {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees = Employee.createEmployees();
        //测试终端操作
        //返回总数
        System.out.println("测试 集合中元素 总数");
        long count = employees.stream().count();
        System.out.println(count);

        //返回第一个对象  返回值是用Option 包装过的对象  防止空指针异常
        System.out.println("测试  返回第一个元素");
        Optional<Employee> first = employees.stream().findFirst();
        Employee employee = first.get();
        System.out.println(employee);
        //返回任意元素  单线程 总是第一个  此方法是针对并行环境
        System.out.println("测试  fingAny 终端操作");
        Employee employee1 = employees.stream().findAny().get();
        System.out.println(employee1);

        //匹配 返回值boolean  参数 Predicate  ---->  boolean 类型
        //全部匹配
        boolean all = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println("雇员年龄是否都大于10"+all);
        //任意匹配
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 1000);
        System.out.println("雇员薪资是否有一个大于1000"+anyMatch);
        //都不匹配
        boolean noneMatch = employees.stream().noneMatch(e -> e.getAge() < 2);
        System.out.println("雇员年龄是否都不小于2"+noneMatch);

        //forEach 终端操作
        employees.stream().forEach(System.out::println);
    }
}
