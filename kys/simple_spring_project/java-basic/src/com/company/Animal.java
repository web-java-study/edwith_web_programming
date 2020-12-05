package com.company;

public class Animal {
    String name;

    public void setNAme(String name) {
        this.name = name;
    }

    public static void main(String args[]) {
        Animal cat = new Animal();
        cat.setNAme("body");
        System.out.println(cat.name);
    }
}
