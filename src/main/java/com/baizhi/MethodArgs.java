package com.baizhi;

/**
 * Created by Administrator on 2019/8/9.
 * 测试方法引用
 */
public class MethodArgs {

    /*
    * 参数方法
    * Lambda (A arg0,B rest)->arg0.method(rest)
    * 方法引用 A :: method;
    * */    //匿名内部类
    I1 a1 = new I1() {
        @Override
        public void test(A a) {
            a.method();
        }
    };
    //Lambda 表达式
    I1 a2 = a -> a.method();
    //方法引用   由接口决定
    I1 a3 = A::method;
    /*
    * 默认按照参数顺序  把第一个参数当作对象，后续参数当作方法的参数
    * 要求   方法为非静态方法
    * */
    I2 a4 = (A a, String s) -> a.method(s);
    I2 a5 = A::method;

    I3 a6 = (A a, String b, String c) -> a.method(b, c);
    I3 a7 = A::method;
    //a1 -- a7 全部为对象  Lambda 只是匿名内部类的简化

    /*
    *   静态方法  将String 转换为Int 类型
    *   Lambda (args) -> ClassName.method(args);
    *   方法引用 ClassName::method;
     */

    I4 a8 = s -> Integer.parseInt(s);
    I4 a9 = Integer::parseInt;

    //同理
    I4 a10 = s -> System.out.print(s);
    I4 a11 = System.out::print;

}

interface I1 {
    void test(A a);
}

interface I2 {
    void test(A a, String s);
}

interface I3 {
    void test(A a, String s1, String s2);
}

interface I4 {
    void test(String s);
}

class A {

    public void method() {
        System.out.println("method");
    }

    public void method(String s) {
        System.out.println("method (String)");
    }

    public void method(String s1, String s2) {
        System.out.println("method s1  s2");
    }
}
