package com.company;

public class MyCalcExam {
    public static void main(String[] args) {
        MyCalc cal = new MyCalc();
        Calculator cal2 = new MyCalc();

        System.out.println(cal.exec(1, 2));
        System.out.println(cal2.exec(2, 3));
    }
}
