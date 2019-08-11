package com.baizhi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/8/11.
 */
public class TestPractise {
    public static void main(String[] args) throws IOException {
        //读取文件
        Stream<String> lines = Files.lines(Paths.get("D:\\students.txt"), Charset.defaultCharset());

        //将String -- > Stu
        Stream<Stu> stuStream = lines.map(Stu::new);
        List<Stu> stus = stuStream.collect(Collectors.toList());

        //计算每班平均分
        Map<String, Double> avgScore = stus.stream().collect(Collectors.groupingBy(Stu::getClassNum, Collectors.averagingDouble(Stu::getScore)));
        avgScore.forEach((k,s)->{
            System.out.println(k+"的平均成绩为"+s);
        });
        //打印分数最高的男生名字
        String sex = stus.stream().filter(stu -> stu.getSex().equals("男")).max(Comparator.comparingDouble(Stu::getScore)).map(Stu::getName).get();
        System.out.println("分数最高的男生姓名为"+sex);
        //打印每班分数最高的前三
        Map<String, List<Stu>> collect = stus.stream().collect(Collectors.groupingBy(Stu::getClassNum));
        collect.forEach((k,l)->{
            System.out.println(k);
            l.stream().sorted(Comparator.comparingDouble(Stu::getScore).reversed()).limit(3).collect(Collectors.toList()).forEach(System.out::println);
        });
    }
}

class Stu {
    private String name;
    private String sex;
    private String classNum;
    private Double score;

    public Stu() {
    }

    public Stu(String s) {
        String[] ss = s.split("/");
        this.name = ss[0];
        this.sex = ss[1];
        this.classNum = ss[2];
        this.score = Double.parseDouble(ss[3]);
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", classNum='" + classNum + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }


    public String getSex() {
        return sex;
    }


    public String getClassNum() {
        return classNum;
    }


    public Double getScore() {
        return score;
    }

}
