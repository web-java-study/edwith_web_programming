package com.company;

public class Animal {
    int a;  // 객체변수 a

    public void vartest(Animal test) {
        test.a++;
    }

    public static void main(String[] args) {
        Animal myTest = new Animal();
        myTest.a = 1;
        myTest.vartest(myTest);
        System.out.println(myTest.a);
    }
}
