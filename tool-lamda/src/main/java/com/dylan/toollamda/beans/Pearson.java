package com.dylan.toollamda.beans;

public class Pearson {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pearson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pearson() {
    }

    @Override
    public String toString() {
        return "Pearson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
