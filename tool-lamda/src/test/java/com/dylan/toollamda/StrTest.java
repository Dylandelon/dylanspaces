package com.dylan.toollamda;

import com.dylan.toollamda.beans.lambda.MyAction;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StrTest {

    @Test
    public void valueTest(){
        int a =2;
        func1(a);
        System.out.println(a);


    }

    void func1(int a){
        int b= 8;
        a=b;

    }
    @Test
    public void objTest(){
        MyAction myAction = new MyAction();
        myAction.setId(1);
        myAction.setName("my");
        func2(myAction);
        System.out.println("myAction:"+myAction.toString());
    }

    void func2(MyAction myAction) {
        myAction.setId(2);
        myAction.setName("myname");


    }
}
