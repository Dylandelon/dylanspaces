package com.dylan.toollamda.controller;

import com.dylan.toollamda.beans.lambda.MyAction;
import com.dylan.toollamda.service.IMyLamdaService;

import java.util.List;

public class MyLamdaController {


    public void inline(){

        final String[] a = new String[1];

        MyAction myAction = new MyAction(1,"fly");
        myAction.addActionListen(new IMyLamdaService() {
            @Override
            public void actionPerformed(List list) {

                list.add(11);
                String b = list.get(0).toString();
                System.out.println("list = [" + b + "]");
                myAction.setName(b);
                a[0] = b;
                System.out.println("myAction:"+myAction.getName());
                // 所以很多return 返回后做为调用者的参数

            }
        });
        System.out.println("a[0]:"+a[0]);
        System.out.println("myAction:"+myAction.getName());
    }

    public static void main(String[] args) {
        MyLamdaController myLamdaController = new MyLamdaController();
        myLamdaController.inline();

    }


}
