package com.company;

public class CarExam {

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car();

        c1.name = "봃보";
        c1.number = 1234;

        c2.name = "경찰차";
        c2.number = 3333;

        c1.move("앞으로가기");
        c2.move("뒤로가기");

        System.out.println(c1.name);
        System.out.println(c2.name);
    }
}
