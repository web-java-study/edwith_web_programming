package com.company;

public class VariableScopeExam {
    int globalScope = 10;

    static int staticValue = 30;

    public void scopeTest(int value) {
        int localScope = 20;
        System.out.println(globalScope);
        System.out.println(localScope);
        System.out.println(value);
    }

    public void scopeTest2(int value2) {
//        System.out.println(localscope);
        System.out.println(globalScope);
//        System.out.println(value);
        System.out.println(value2);
    }

    public static void main(String[] args) {
//        System.out.println(globalScope);
//        System.out.println(localScopoe);
//        System.out.println(value);
        System.out.println(staticValue);

        VariableScopeExam v1 = new VariableScopeExam();
        System.out.println(v1.globalScope);
        VariableScopeExam v2 = new VariableScopeExam();
        v2.globalScope = 20;
    }
}
