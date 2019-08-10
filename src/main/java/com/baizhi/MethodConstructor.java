package com.baizhi;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Administrator on 2019/8/9.
 * 测试构造方法的引用
 */
public class MethodConstructor {

    public static void main(String[] args) {

        //构造方法的引用
   /*     //  ()- T
        W1 s1 = () -> new Worker();
        W1 s2 = Worker::new;

        W2 s3 = s -> new Worker(s);
        W2 s4 = Worker::new;

        W3 s5 = (s, i) -> new Worker(s, i);
        W3 s6 = Worker::new;
*/
        //无需自己定义接口
        //使用java.lang.Function 包下的函数式接口
        //  无参  Lambda 表达式 ()->T
        Supplier<Worker> c = Worker::new;
        Worker worker1 = c.get();

        //一个参数  T ->R
        Function<String, Worker> cc = Worker::new;
        Worker worker2 = cc.apply("ABCD");

        //两个参数 T,V -> R
        BiFunction<String, Integer, Worker> ccc = Worker::new;
        Worker worker3 = ccc.apply("123", 456);
        //如果构造方法三个参数  需要自定义接口
        W4  w4 = (String s,int i,double d)->new Worker(s,i,d);
        W4 ww4 = Worker :: new;

    }
}

interface W1 {
    Worker method();
}

interface W2 {
    Worker method(String s);
}

interface W3 {
    Worker method(String s, int i);
}
interface W4{
    Worker method(String s,int i ,double d);
}
class Worker {
    public Worker() {
        System.out.println("Worker()");
    }

    public Worker(String s) {
        System.out.println("Worker(String)");
    }

    public Worker(String s, int i) {
        System.out.println("Worker(Sring int)");
    }
    public Worker(String s,int i,double d){
        System.out.println("Worker(String int double)");
    }
}
