package com.company;

public class ExceptionExam {
    public static void main(String[] args) {
        int i = 10;
        int j = 0; // 10을 0으로 나눌수 없어서 에러가 발생하고 실행 종료됨
        int result = i / j;
        System.out.println(result);
    }
}
