package list.arrayList.implementation;

public class Main {
    public static void main(String[] args) {
        ArrayList numbers = new ArrayList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        ArrayList.ListIterator li = numbers.listIterator();
        while (li.hasNext()) {
            int number = (int)li.next();
            if(number == 30) {
                li.remove();
            }
        }
        System.out.println(numbers);

//        numbers.add(1, 15);
//        numbers.addFirst(5);
//        numbers.removeFirst();
//        numbers.removeLast();
//        System.out.println(numbers.size());
//        System.out.println(numbers.remove(1));
//        System.out.println(numbers);
//        System.out.println(numbers.get(0));
//        System.out.println(numbers.get(1));
//        System.out.println(numbers.get(2));
    }
}
