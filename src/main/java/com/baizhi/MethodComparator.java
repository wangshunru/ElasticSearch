package com.baizhi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * Created by Administrator on 2019/8/9.
 */
public class MethodComparator {
    public static void main(String[] args) {
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp("liucy",29,1000.0));
        emps.add(new Emp("huxz",31,2222.0));
        emps.add(new Emp("suns",37,1111.0));
        emps.add(new Emp("cpx",29,1234.8));
        emps.add(new Emp("liuh",30,1000.0));
        emps.add(new Emp("kg",26,4560.0));

        //比较器
        //匿名内部类
        Comparable<Emp> c1 = new Comparable<Emp>() {
            @Override
            public int compareTo(Emp o) {
                return o.getAge();
            }
        };
        //Lambda 表达式
        //Comparator 接口中有一个静态的方法  如下  将对象  ---》 返回int类型
        Comparator<Emp> c2 = Comparator.comparingInt(new ToIntFunction<Emp>(){
            @Override
            public int applyAsInt(Emp value) {
                return value.getAge();
            }
        });
        //返回Double 类型
        //Lambda 形式
        Comparator<Emp> c4 = Comparator.comparingInt(value -> value.getAge());
        Comparator<Emp> c3 = Comparator.comparingDouble(Emp::getSalary);
        //按照工资  倒序
        Comparator<Emp> c5 = Comparator.comparingDouble(Emp::getSalary).reversed();

        //先按照工资排序  如果工资相同 ，按照年龄
        Comparator<Emp>  c6 = Comparator.comparingDouble(Emp::getSalary);
        Comparator<Emp> c7 = Comparator.comparingInt(Emp::getAge);

        //组合排序
        emps.sort(c6.thenComparing(c7));

        /*//排序
        emps.sort(c3);*/
        //遍历
        emps.forEach(System.out::print);
    }

}

class Emp{
    private  String name;
    private  Integer age;
    private  Double salary;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public Emp() {
    }

    public Emp(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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
}


