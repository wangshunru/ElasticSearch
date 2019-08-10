package com.baizhi;

import java.util.Optional;

/**
 * Created by Administrator on 2019/8/9.
 */
public class TestOptional {
    public static void main(String[] args) {

        Man man = new Man();
        //ifPresent 如果存在值，则消费值
        man.wife.ifPresent(Woman::method);
    }
}

class Man{
    String name;
    //用Optional 包装之后 避免空指针异常
    Optional<Woman> wife = Optional.empty();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Woman> getWife() {
        return wife;
    }

    public void setWife(Optional<Woman> wife) {
        this.wife = wife;
    }
}
class Woman{
    private String name;
    public  void method(){
        System.out.println("Woman 中的 method()");
    }
}
