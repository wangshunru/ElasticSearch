package com.baizhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Administrator on 2019/8/9.
 */
//Lambda 表达式与泛型
public class FilterObject {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("1","zhang3","123",23,"女"));
        users.add(new User("2","li4","123",19,"女"));
        users.add(new User("3","wang5","123",31,"男"));
        users.add(new User("4","zhao6","123",27,"男"));
        users.add(new User("5","luo1","123",36,"男"));
        users.add(new User("6","huang2","123",29,"女"));
        users.add(new User("7","huang3","123",31,"女"));

        //使用Lambda 表达式
        FilterBest<User> f1 = (user -> user.getAge()>30 && user.getSex().equals("女"));
        //调用filterOnjects()
        List<User> result1 = filterOnjects(users, f1);
        for (User user : result1) {
            System.out.println(user);
        }

        //体现泛型
        FilterBest<Integer> f2 = (i -> i%2 == 0);
        List<Integer> integers = Arrays.asList(1,3,4,6,8,2,9,13);
        List<Integer> result2 = filterOnjects(integers, f2);
        for (Integer i : result2) {
            System.out.println(i);
        }

        //常见的函数式接口
        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });*/
        Thread t = new Thread(()-> System.out.println("我是Runnable 接口中run 方法的"));

        //排序
      /*  integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*/
        integers.forEach((i)-> System.out.println(i));


        //比较
        List<String> strings = Arrays.asList("A", "BB", "CCC", "DDDDDD", "ASDD");
      /*  strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });*/
        strings.sort((s1,s2)->s1.length()-s2.length());
        for (String s : strings) {
            System.out.println(s);
        }

    }
    //定义静态方法
    static  <T> List<T> filterOnjects(List<T> list,FilterBest<T> filterBest){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(filterBest.isTrue(t)){
                result.add(t);
            }
        }
        return result;
    }

}
interface  FilterBest<T>{
    boolean isTrue(T t);
}

class  User{
    private  String id;
    private  String name;
    private  String password;
    private  Integer age;
    private  String sex;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User() {
    }

    public User(String id, String name, String password, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}