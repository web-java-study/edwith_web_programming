## 자바의 객체지향 프로그래밍

- 클래스, 객체, 인스턴스
- 상속
- 인터페이스
- 다형성
- 추상화

### class
```java
public class Student {}

Student son = new Student();
```

위의 코드는 가장 기본적인 클래스 선언과 사용 형태이며 `new Student()` 를 선언함으로써 객체가 만들어진다. son 은 객체라고 부를수있고 son 은 Student 의 인스턴스라고도 부를 수도 있다. 
  
위와같이 빈 클래스를 만들어두면 여러개의 객체를 생성할 수 있다.
```java
Student son = new Student();
Student son1 = new Student();
Student son2 = new Student();
```

### class 확장
```java
public class Student {
    // 객체변수, 인스턴스변수, 멤버 변수 라고도 부른다.
    String name;

    public static void main(String[] args) {
        Student son = new Student();
        System.out.println(son.name); // null
    }
}
```

아직 name 객체변수에 어떤값도 할당해주지 않았기때문에 출력값은 null이 나온다. 

```java
public class Student {
    // 객체변수, 인스턴스변수, 멤버 변수 라고도 부른다.
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student son = new Student();
        son.setName("brown");
        System.out.println(son.name); // brown
    }
}
```

위의 코드는 Student 클래스에 리턴값이 없는 setName 메소드를 생성하여 인자값으로 name을 전달받아 객체 변수에 인자로 넘어온값을 할당해준다. 그리고 main 메소드에서 생성한 객체에서 setName을 사용하여 값을 전달할 수 있다.
  
```java
public class Student {
    // 객체변수, 인스턴스변수, 멤버 변수 라고도 부른다.
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Student son = new Student();
        Student son2 = new Student();
        son.setName("brown");
        son2.setName("duck");
        System.out.println(son.name); // brown
        System.out.println(son2.name); // duck
    }
}
```

위의 코드는 각각 생성된 객체가 동일한 메소드를 호출하여 사용하는 코드이다. 위의 코드로 알수있는것은 객체변수는 공유되지않고 생성된 객체에 의해 개별적으로 메소드가 호출된다는걸 알 수 있다. 생성된 객체에 따라 변수나 메소드가 개별적으로 적용되기때문에 객체지향적이라고 불리우는 이유가된다.


### 추상클래스
추상클래스는 구체적이지 않은 클래스를 의미하며 새, 자동차, 가구 등이 추상클래스로 볼 수 있겠다. 새 라고하면 어떤사람은 독수리 어떤사람은 앵무새를 생각할 수 있고 자동차 했을경우 어떤사람은 스포츠카 어떤사람은 트럭 을 생각할 수도 있겠다. 
```java
public abstract class Car {
    public abstract void go();

    public void back() {
        System.out.println("후진");
    }
}

public class Truck extends Car {
    @Override
    public void go() {
        System.out.println("전진");
    }
}

public class TruckExam {
    Truck truck = new Truck();
    truck.go(); // 전진
    truck.back(); // 후진

    // Car car = new Car(); 추상클래스는 부모의 역할은 가능하지만 객체 생성은 할 수 없다.
}
```
추상클래스는 abstract를 사용하여 정의할 수 있다. 추상클래스에는 정의된 메소드 또는 아직 정의되지 않은 메소드를 갖고 있을 수 있고 자식 클래스에서 상속받아 메소드의 확장이 가능하다. 추상클래스를 상속받은 자식클래스는 객체로 생성이 가능하지만 추상클래스자체가 객체로써 생성하여 사용할수는 없다.

### 메소드
```java
public class MethodTest {
    public int sum(int a, int b) { // 메소드
        return a + b;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        MethodTest test = new MethodTest();
        int result = test.sum(a, b); // 메소드 호출

        System.out.println(result);
    }
}
```

자바스크립트를 사용할땐 매소드와 함수를 따로 불렀었다. 메소드는 객체 내부에 정의된 함수를 사용할땐 메소드라부르고 순수하게 함수 자체만 호출해서 사용할때는 함수라고 불렀었다. 
  
자바에서는 클래스선언없이는 메소드도 함수도없기때문에 무조건 메소드체이닝을 사용해서 호출한다. 때문에 자바는 함수가 아니라 메소드밖에 없다. 생성된 클래스객체가 있어야 내부에 메소드를 선언하여 만들 수 있다.

```java
// 리턴값도있고 입력값도 있는 메소드
public int sum(int a, int b) {
    return a + b;
}

// 리턴값이 없는 메소드 and 입력값이 없는 메소드
public void test() {
    System.out.println("Hello");
}

// 리턴값은있고 입력값이 없는 메소드
public int number() {
    return 1;
}
```


### 메소드에 객체를 전달
> 메소드에 객체를 전달하면 메소드에서 객체변수 값의 변경이 가능하다.

위의 예제에서는 메소드에 값을 전달하는 예제로 사용하였는데 메소드는 객체도한 전달받아 사용 할 수 있다. 이때 메소드는 전달받은 객체의 객체변수값 자체에 대한 수정이 가능하게된다.

```java
class Increase {
    public void increase(Counter count) {
        count.count++;
    }
}

public class Counter {
    int count = 0;

    public static void main(String[] args) {
        Counter count = new Counter();
        System.out.println("init count: " + count.count); // 0

        Increase increase = new Increase();
        increase.increase(count);
        System.out.println("increase count: " + count.count); // 1
    }
}
```



## 상속
상속은 자식이 부모로부터 물려받는 무언가를 말한다. 자바에서 풀이를 하자면 자식클래스는 부모클래스가 가진 객제변수나 메소드를 상속받아 사용이 가능하다.
```java
public class Parent { // 부모클래스
    String name;

    public void setName(Sstring name) {
        this.name = name;
    }
}

public class Children extends Parent { // 부모객체를 상속받은 자식클래스

    public void sleep() {
        System.out.println(this.name + "zzz");
    }

    public static void main(String[] args) {
        Children children = new Children();
        children.setName("nami"); // 부모클래스의 setName 메소드를 사용
        System.out.println(children.name); // nami
        children.sleep(); // nami zzz
    }
}
```

### Is - A 관계
상속관계에 있을때 자식객체는 부모클래스의 자료형처럼 사용 할 수 있다.
```java
Parent children = new Children();
```

### 메소드 오버라이딩
자식객체를 상속받은 또다른 객체를 생성하여 그 내부에서 부모에게 있는 동일한 이름의 메소드를 수정하여 정의하게되면 자식클래스에서 선언된 메소드가 우선순위로 실행된다. 이렇게 구현하는 행위를 메소드오버라이딩 이라고 한다.

```java
public class FirstChildren extends Children {
    public void sleep() { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house");
    }

    public static void main(String[] args) {
        FirstChildren firstChildren = new FirstChildren();
        firstChildren.setName("bug"); // name = dog
        firstChildren.sleep(); // dog zzz in house
    }
}
```

### 메소드와 오버로딩
FirstChildren 클래스에 sleep 메소드가 존재하지만 동일한 이름의 메소드를 하나 더 만들 수 있다. 다만 메소드의 입력항목이 다를 경우에만 가능하다. 이러한 것은 메소드 오버로딩 이라고 한다.


```java
public class FirstChildren extends Children {
    public void sleep() { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house");
    }

    public void sleep(int hour) { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house" + hour + "hours");
    }

    public static void main(String[] args) {
        FirstChildren firstChildren = new FirstChildren();
        firstChildren.setName("bug"); // name = dog
        firstChildren.sleep(); // dog zzz in house
        firstChildren.sleep(3); // dog zzz in house 3 hours
    }
}
```

## 생성자
**생성자의 규칙**
- 클래스명과 메소드명이 동일하다.
- 리턴타입을 정의하지 않는다.

생성자를 사용하게되면 객체변수에 값을 무조건 할당해야지만 객체가 생성되도록 강제 할 수 있다.  


```java
public class FirstChildren extends Children {
    public FirstChildren(String name) { // 클래스명과 동일한 메소드 생성
        this.setName(name);
    }

    public void sleep() { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house");
    }

    public void sleep(int hour) { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house" + hour + "hours");
    }

    public static void main(String[] args) {
        FirstChildren firstChildren = new FirstChildren("bug"); // 클래스를 생성하면서 name 인자를 넘겨주어야 오류가 발생하지 않는다.
        // firstChildren.setName("bug");
        firstChildren.sleep(); // dog zzz in house
        firstChildren.sleep(3); // dog zzz in house 3 hours
    }
}
```

**생성자 오버로딩**
메소드 오버로딩과 같은 개념으로 클래스내부에 서로 다른 입력값을 받는 생성자를 여러개 만들어 사용할 수 있다.


```java
public class FirstChildren extends Children {
    public FirstChildren(String name) {
        this.setName(name);
    }

    public FirstChildren(int type) { // 추가된 생성자
        if (type == 1) {
            this.setName("byte")
        } else if (type == 2) {
            this.setName("bit")
        }
    }

    public void sleep() { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house");
    }

    public void sleep(int hour) { // 부모클래스와 동일한 이름의 메소드
        System.out.println(this.name + "zzz in house" + hour + "hours");
    }

    public static void main(String[] args) {
        FirstChildren firstChildren = new FirstChildren("bug");
        FirstChildren byte = new FirstChildren(1); 
        System.out.println(firstChildren.name); // bug
        System.out.println(byte.name); // byte
    }
}
```

## 인터페이스

```java
public class Parent {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

class Child extends Parent {}
class Child2 extends Parent {}
class Child3 extends Parent {}

public class Teacher {
    public void teaching(Child child) {
        System.out.println("Teaching eng")
    }

    public void teaching(Child2 child2) {
        System.out.println("Teaching math")
    }

    public void teaching(Child3 child3) {
        System.out.println("Teaching programming");
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Child child = new Child();
        Child2 child2 = new Child2();
        Child3 child3 = new Child3();

        teacher.teaching(child); // Teaching eng
        teacher.teaching(child2); // Teaching math
        teacher.teaching(child3); // Teaching programming
    }
}
```

- 위의코드는 먼저 부모클래스에서 객체변수 네임을 선언하고 setName 메소드를 생성하였다.
- 자식은 여러명 있을 수 있고 모두 부모클래스를 상속받는다.
- Teacher 란 클래스를 생성하고 선생님은 각각의 아이에게 다른 과목을 가르친다.

여기서 만약 자식 또는 다른 부모의 자식 등 가르쳐야할 아이들이 많아지면 그때마다 teaching 메소드를 새롭게 생성해 주어야 한다. 바로 이러한 단점을 해소하기위해 인터페이스를 사용한다.

**Teaching.java (interface)**  
```java
public interface Teaching { // 인터페이스 정의
    public String getStudy();
}
```
  
**Parent.java (class)**  
```java
public class Parent {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
```
  
**Teacher.java (class)**  
```java
class Child extends Parent implements Teaching { // implements 로 인터페이스 적용
    public String getStudy() {
        return "end"
    }
}
class Child2 extends Parent implements Teaching {
    public String getStudy() {
        return "math"
    }
}
class Child3 extends Parent implements Teaching {
    public String getStudy() {
        return "programming"
    }
}

public class Teacher {
    public void teaching(Teaching teaching) { // 인터페이스 사용
        System.out.println("teaching " + teaching.getStudy());
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Child child = new Child();
        Child2 child2 = new Child2();
        Child3 child3 = new Child3();

        teacher.teaching(child); // Teaching eng
        teacher.teaching(child2); // Teaching math
        teacher.teaching(child3); // Teaching programming
    }
}
```

어떤 행동이나 어떤 값을 리턴해 줄지는 자식들이 갖고있고 인터페이스는 단지 어떤 메소드나 행위를 정의할지만 정해주게된다. 그 행동의 구체적인 내용은 자식이나 또는 다른 부모의 자식이 추가 될때 정의하면 선생클래스에서 매번 메소드를 생성해줄 필요는 없다. 즉 인터페이스를 사용하면 메소드오버로딩에 대해 신경쓰지 않아도 된다.