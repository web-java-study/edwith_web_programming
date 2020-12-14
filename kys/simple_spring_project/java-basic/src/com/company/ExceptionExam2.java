package com.company;

public class ExceptionExam2 {
    public static void main(String[] args) {
        int i = 10;
        int j = 0;
        try { // try catch 구문 사용하면 프로그램이 종료되지 않고도 에러처리를 할 수 있다.
            int result = i / j;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다. " + e.toString());
        } finally {
            System.out.println("오류 발생 여부와 상관없이 무조건 발생하");
        }
    }
}
