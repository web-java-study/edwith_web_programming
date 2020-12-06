package com.company;

class Increase {
    public void increase(Counter counter) {
        counter.count++;
    }
}

public class Counter {
    int count = 0;

    public static void main(String args[]) {
        Counter counter = new Counter();
        System.out.println(counter.count);

        Increase increase = new Increase();
        increase.increase(counter);
        System.out.println(counter.count);
    }
}
