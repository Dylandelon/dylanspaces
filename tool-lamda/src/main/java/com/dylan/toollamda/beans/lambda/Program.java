package com.dylan.toollamda.beans.lambda;

public class Program {
    public static void main(String[] args) {
        MyActionListen listen = new MyActionListen();
        ISay say = new ISay() {
            public void sayHello() {
                System.out.println("Hello java!");
                listen.setName("namelisten");
            }
        };
        // 体现出传递的是给对象的实现方法，没有被执行，直到被执行
        say.sayHello();
        System.out.println("args = [" + listen.getName() + "]");
        // 一个lambda表达式就是一个接口的实例，一个是实现，一个函数，一个代码块，不是立即执行的语句 ,相当于new
        // 上下文推导   一个lambda首先对应这一个函数式接口    int表达式，式因为已经给我写好了函数时接口
        // final  未被修改， 因为传递过去的表达式如果使用外部变量，还没被执行，其中的这个变量值不停的变化，没法子玩了
    }
}
