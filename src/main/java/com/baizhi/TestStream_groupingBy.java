package com.baizhi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/8/11.
 */
public class TestStream_groupingBy {
    public static void main(String[] args) {
        List<Employee> employees = Employee.createEmployees();
        //基础分组  Collector 第三个泛型Map<K,List<T>> 参数Function作用 T-> K 将返回值当作Map集合的key
        //按照部门分组
        System.out.println("按照部门分组");
        Map<String, List<Employee>> Bydepts = employees.stream().collect(Collectors.groupingBy(Employee::getDepa));
        //遍历 Map集合的遍历
        Bydepts.forEach((s,l)->{
            System.out.println(s);
            l.forEach(System.out::println);
        });


        //多级分组  参数 Function(<T,K> f,Collector<T,?,D> c) 返回值 Map<K,D>  第二个参数处理的map集合的List
        //计算每个部门的平均年龄
        System.out.println("计算每个部门的平均年龄");
        Map<String, Double> deptAvgAge = employees.stream().collect(Collectors.groupingBy(Employee::getDepa, Collectors.averagingInt(Employee::getAge)));
        deptAvgAge.forEach((k,l)->{
            System.out.println(k+":"+l);
        });
        //计算每个部门的年龄最大的员工
        System.out.println("计算每个部门的年龄最大的员工");
        Map<String, Optional<Employee>> deptByAgeMax = employees.stream().collect(Collectors.groupingBy(Employee::getDepa, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
        deptByAgeMax.forEach((k,e)->{
            System.out.println(k+":"+e.get());
        });
        //结果转换  上一案例 将Optional<Employee> -->  Employee 先收集再转换
        System.out.println("结果转换 分组 年龄最大的雇员");
        Map<String, Employee> OptionToEmp = employees.stream().collect(Collectors.groupingBy(Employee::getDepa,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Employee::getAge)),
                        Optional::get
                )
        ));

        OptionToEmp.forEach((k,e)->{
            System.out.println(k+":"+e);
        });

        //先转换再收集
        System.out.println("将大写字母 先转为小写  再用，分割输出");
        List<String> strings = Arrays.asList("LIUCY","HUXZ","SUNS");
        String s = strings.stream().collect(Collectors.mapping(String::toLowerCase, Collectors.joining(",")));
        System.out.println(s);
        //分区  map集合  key 为boolean
        System.out.println("分区 年龄大于 小于23 的平均工资");
        Map<Boolean, Double> collect = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 23, Collectors.averagingDouble(Employee::getSalary)));
        collect.forEach((k,d)->{
            System.out.println(k+":"+d);
        });
    }
}
