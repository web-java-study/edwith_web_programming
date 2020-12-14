package com.company.cooking;

public class Cooking extends Chef {
 // 요리는 여러가지가 있다.
 public static void main(String[] args) {
     Cooking cooking = new Cooking();
     cooking.setCooking("Pasta");
     System.out.println(cooking.cooking);
 }
}
