package com.dylan.toollamda;

import com.dylan.toollamda.beans.Pearson;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Stream<Pearson>  stream = Arrays.stream(pearsons);
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
    @Test
    public void reducStram5(){
        Pearson[] pearsons = {new Pearson("jack",18),new Pearson("jim",24),new Pearson("bob",30)};

        Stream<Pearson>  stream = Arrays.stream(pearsons);

        Optional<Pearson> fistBob = stream.filter(s -> s.getName()=="bob")
                .findFirst();

        System.out.println("fistBob:"+fistBob.toString()+fistBob.get().getName());

    }
    @Test
    public void reducStram6(){
        List<Pearson> list = Arrays.asList(new Pearson("jack", 18), new Pearson("jim", 24), new Pearson("bob", 30));


        int sum = list.parallelStream()
                .filter(s -> s.getName().contains("j"))
                .mapToInt(s -> s.getAge())
                .sum();
        System.out.println("sum:"+sum);

    }

    @Test
    public void reducStram7(){
        List<Pearson> list = Arrays.asList(new Pearson("jack", 18),
                new Pearson("lily", 24),new Pearson("jim", 24), new Pearson("bob", 30));


        Map<Integer,List<Pearson>> map =list.stream()
                .filter(s -> s.getAge() >18)
                .collect(Collectors.groupingBy(s -> s.getAge()));



        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
    }
    @Test
    public void reducStram8(){
        List<Pearson> list = Arrays.asList(new Pearson("jack", 18),
                new Pearson("lily", 24),new Pearson("jim", 24), new Pearson("bob", 30));
//        Comparator.comparing()

        list.sort(Comparator.comparing(p -> p.getName()));
        list.forEach(t -> System.out.println("t:"+t.toString()));
    }
}
