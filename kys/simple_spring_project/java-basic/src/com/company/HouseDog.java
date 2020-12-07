package com.company;

class Child extends Parent implements Teaching { // implements 로 인터페이스 적용
    public String getStudy() {
        return "end";
    }
}
class Child2 extends Parent implements Teaching {
    public String getStudy() {
        return "math";
    }
}
class Child3 extends Parent implements Teaching {
    public String getStudy() {
        return "programming";
    }
}

public class HouseDog {
    public void teaching(Teaching teaching) { // 인터페이스 사용
        System.out.println("teaching " + teaching.getStudy());
    }

    public static void main(String[] args) {
        HouseDog teacher = new HouseDog();
        Child child = new Child();
        Child2 child2 = new Child2();
        Child3 child3 = new Child3();

        teacher.teaching(child); // Teaching eng
        teacher.teaching(child2); // Teaching math
        teacher.teaching(child3); // Teaching programming
    }
}
