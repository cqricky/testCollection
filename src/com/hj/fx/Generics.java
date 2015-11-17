package com.hj.fx;

/**
 * Created by caiqing on 15/11/17.
 */
public class Generics {



    public static void main (String args[]) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    public static void test1() {
        Info<Number> i1 = new Info<Number>(1);

        Info<Integer> i2 = new Info<Integer>(2);

        Info<Double> i3 = new Info<Double>(3.0);

        calculate(i1);

        calculate(i2);

        calculate(i3);
    }

    public static void test2() {
        Info<? extends Number> info = new Info<Number>(5);
        calculate(info);
//        info.setValue();
    }

    public static void test3() {
        Info<Number> i1 = new Info<Number>(1);

        Info<Integer> i2 = new Info<Integer>(2);

        Info<Double> i3 = new Info<Double>(3.0);

        fun(i1);
        fun(i2);
//        fun(i3);
    }

    public static void test4() {
        Info<? super Integer> info = new Info<Number>(5);
        fun(info);
        info.setValue(2);
        info.getValue();
    }

//    Number n = new Integer(1);

    public static void calculate(Info<? extends Number> info) {
        System.out.println(info.getValue());
    }

    public static void fun(Info<? super Integer> info) {
        System.out.println(info.getValue());
    }

}
