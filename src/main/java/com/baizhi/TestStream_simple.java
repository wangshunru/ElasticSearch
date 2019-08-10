package com.baizhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/8/9.
 */
public class TestStream_simple {

    public static void main(String[] args) {
        //截取数组前4个
        List<String> list = Arrays.asList("Liucy", "Huxz", "Suns", "Liangb", "Cpx", "Liuh", "Zhangkg", "Suns", "Huxz");
        System.out.println("截取前4 ");
        //将集合转化为流  数据源
        Stream<String> stream1 = list.stream();
        //中间线
        Stream<String> stream2 = stream1.limit(4);
        //终端操作
        List<String> strings = stream2.collect(Collectors.toList());
        strings.forEach(System.out::println);
        /*
        *   过滤长度为4 的字符串  并且 无重复
        * */
        //先过滤   过滤重复  终端
        System.out.println("过滤长度为4  且无重复");
        List<String> strings1 = list.stream().filter(s -> s.length() == 4).distinct().collect(Collectors.toList());
        strings1.forEach(System.out::println);

        /*
        *   对象类型的操作
        * */
        List<Student> students = new ArrayList<>();
        students.add(new Student("huxz", 23, 98.9, "C1"));
        students.add(new Student("suns", 32, 56.9, "C2"));
        students.add(new Student("cpx", 29, 78.6, "C1"));
        students.add(new Student("liucy", 34, 85.0, "C1"));
        //年龄小于30  的学生名字
        System.out.println("年龄小于30 的学生姓名");
        List<String> names = students.stream().filter(student -> student.getAge() < 30).map(Student::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
        //按照成绩排序
        System.out.println("学生对象 按照成绩排序");
        List<Student> scores = students.stream().sorted(Comparator.comparingDouble(Student::getScore)).collect(Collectors.toList());
        scores.forEach(System.out::println);

        /*
        *  查看集合由那些字母组成
        * */
        System.out.println("查看集合中的元素由哪些字母组成并排序");
        List<String> list1 = Arrays.asList("ABC", "DEF", "AGH", "XVY", "AGH", "KNG", "LOPU", "YTRS", "ACTG");
        Stream<String> stream4 = list1.stream().flatMap(s -> {
            //分割
            String[] ss = s.split("");
            //将数组转为Stream
            Stream<String> stream = Arrays.stream(ss);
            return stream;
        });
        //过滤重复
        Stream<String> stream3 = stream4.distinct().sorted();
        //终端操作
        List<String> list2 = stream3.collect(Collectors.toList());
        list2.forEach(System.out::println);
    }
}
