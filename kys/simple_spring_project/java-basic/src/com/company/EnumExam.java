package com.company;

public class EnumExam {
    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";

    public static void main(String[] args) {
        Gender gender1;
        gender1 = Gender.MALE;
        gender1 = Gender.FEMALE;

        gender1 = "boy";
    }
}

enum Gender {
    MALE, FEMALE;
}
