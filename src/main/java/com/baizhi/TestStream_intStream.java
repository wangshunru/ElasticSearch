package com.baizhi;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/8/11.
 */
public class TestStream_intStream {
    public static void main(String[] args) {
        List<Employee> employees = Employee.createEmployees();
        //获得Integer 类型的Stream
        //如果后续再计算平均值  还需要进行拆箱和封箱
        Stream<Integer> integerStream = employees.stream().map(Employee::getAge);
        System.out.println(integerStream);
        //mapToDouble 无需封箱
        DoubleStream doubleStream = employees.stream().mapToDouble(Employee::getSalary);
        System.out.println(doubleStream);
        //1-99 的和 range 1-99
        IntStream range = IntStream.range(1, 100);
        System.out.println("1-99"+range.sum());
        //1-100的和  rangeClosed 1-100
        IntStream intStream = IntStream.rangeClosed(1, 100);
        System.out.println("1-100 的和"+intStream.sum());
        //判断一个数是否为质数
        Predicate<Integer> integerPredicate = n->{
            //2-根号下n
            IntStream is = IntStream.rangeClosed(2,(int)Math.sqrt(n));
            //判断是否为质数
            return is.noneMatch(i->n%i==0);
        };
        System.out.println(integerPredicate.test(100));
        System.out.println(integerPredicate.test(101));

    }
}
