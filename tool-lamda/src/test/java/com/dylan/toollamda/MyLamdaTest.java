package com.dylan.toollamda;

import com.dylan.toollamda.beans.Pearson;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
public class MyLamdaTest {

    @Test
    public void reducStram(){

        List<Integer> list = Arrays.asList(1,3,4);
//        int sum = 0;
//        list.forEach(e -> { sum += e.size(); }); // Illegal, close over values

        List<Integer> aList = new ArrayList<>();
        list.forEach(e -> { aList.add(e); }); // Legal, open over variables

        aList.forEach(e->{
            System.out.println("e:"+e);
        });

    }

    @Test
    public void reducStram1(){
        List<Integer> list = Arrays.asList(1,3,4);
        int sum = 0;

        // list.stream() 循环遍历次序返回，然后map接口函数是嵌入每一个循环中
        sum = list.stream().mapToInt(e->e).sum();
        System.out.println("sum:"+sum);

    }
    @Test
    public void reducStram2(){
        List<Integer> list = Arrays.asList(1,3,4);
        int sum = 0;

        // list.stream() 循环遍历次序返回，然后map接口函数是嵌入每一个循环中
        sum = list.stream().mapToInt(e -> e).reduce(0, (x, y) -> x + y);
        System.out.println("sum:"+sum);

    }
    @Test
    public void reducStram3(){
        Pearson[] pearsons = {new Pearson("jack",18),new Pearson("jim",24),new Pearson("bob",30)};

        Arrays.stream(pearsons).forEach(pearson -> {
            System.out.println("OREGIN"+pearson.getName());
        });
        Comparator<Pearson> comparable = Comparator.comparing(p->p.getName());
        Arrays.sort(pearsons,comparable);
        Arrays.stream(pearsons).forEach(pearson -> {
            System.out.println("CHAGE"+pearson.getName());
        });

    }
    @Test
    public void reducStram4(){
        Pearson[] pearsons = {new Pearson("jack",18),new Pearson("jim",24),new Pearson("bob",30)};

        Arrays.stream(pearsons).forEach(pearson -> {
            System.out.println("OREGIN"+pearson.getName());
        });
        // lambda的简写，也是等于一个匿名对象
        Comparator<Pearson> comparable = Comparator.comparing(Pearson::getName);
        Arrays.sort(pearsons,comparable);
        Arrays.stream(pearsons).forEach(pearson -> {
            System.out.println("CHAGE"+pearson.getName());
        });

    }
}
