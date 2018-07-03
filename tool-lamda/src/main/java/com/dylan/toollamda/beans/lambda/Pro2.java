package com.dylan.toollamda.beans.lambda;

public class Pro2 {

    public static void main(String[] args) {

        ISay2 say2 = new ISay2() {
            @Override
            public String sayHello2() {
                System.out.println("1111");
                return "listen to me";
            }
        };
        System.out.println("args = [" + say2.sayHello2() + "]");

    }
}
