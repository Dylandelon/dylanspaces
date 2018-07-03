package com.dylan.toollamda.beans.lambda;

import com.dylan.toollamda.service.IMyLamdaService;

public class MyAction {

    private int id;
    private String name;

    public MyAction() {
    }

    public MyAction(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addActionListen(IMyLamdaService myLamdaService){


    }

    @Override
    public String toString() {
        return "MyAction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
