package com.baizhi;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/8/11.
 */
public class TestStream_Collector {
    public static void main(String[] args) {
        List<Employee> employees = Employee.createEmployees();
        //测试Collector 收集器  是一个接口<T,A,R>  T  参数泛型  A  随意  R-> 返回值类型
        //总数
        Long count = employees.stream().collect(Collectors.counting());
        System.out.println(count);
        //同
        long count1 = employees.stream().count();
        System.out.println(count1);
        //toList  转为集合
        List<Employee> list = employees.stream().collect(Collectors.toList());
        list.forEach(System.out::println);
        //转为 Set 集合
        Set<Employee> set = employees.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);
        //求和
        Integer allAges = employees.stream().collect(Collectors.summingInt(Employee::getAge));
        System.out.println("总年龄为"+allAges);
        Double allSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("总工资"+allSalary);
        //平均数
        Double avgAge = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println("平均年龄"+avgAge);
        Double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("平均工资"+avgSalary);
        //找出集合中年龄最小的  返回值 Optional<Employee>  流中可能是空的  防止空指针
        Employee employee = employees.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge))).get();
        System.out.println("年龄最小的雇员"+employee);
        //简化
        Employee employee1 = employees.stream().min(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println(employee1);
        //找出集合中工资最高的
        Employee employee2 = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println("工资最高的雇员"+employee2);
        //将流拼接为字符串  参数泛型 第一个装满字符串的流  第三个String
        //map  将对象 转为String
        String names = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println("所有雇员名字"+names);

    }
}
