package com.baizhi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/8/11.
 */
public class TestStream_create {
    public static void main(String[] args) {
        //由值创建流
        Stream<String> abd = Stream.of("ABD", "DVD", "HFVD");
        System.out.println(abd.count());
        //由数组创建流i
        String[] str = {"ACDS","CDSV","VFDBGF"};
        Stream<String> stream = Arrays.stream(str);
        System.out.println(stream.count());
        //获取第n个质数
        int x = 3;
        IntStream intStream = IntStream.iterate(x,i -> i + 1);
        int asInt = intStream.filter(n -> {
            IntStream rangeClosed = IntStream.rangeClosed(2, (int) Math.sqrt(n));
            return rangeClosed.noneMatch(z -> n % z == 0);
            //跳过前n- 1  获得第一个   将OptionInt对象转为int
        }).skip(x - 1).findFirst().getAsInt();
        System.out.println(asInt);
    }
}
