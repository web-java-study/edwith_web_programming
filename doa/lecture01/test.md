### Overloading(오버로딩) / Overriding(오버라이딩)
 - 오버로딩(Overloading): 같은 이름의 메서드를 가지면서 매개변수의 유형 및 개수가 다르다.
 아래는 오버로딩의 예제이다. 각 메서드의 이름은 같으나, 매개변수의 유형 및 개수가 다른 것을 확인할 수 있으며, 메서드 호출 시 매개변수를 입력하면 호출 매개변수에 따라 일치하는 자료형에 매칭되어 출력된다.
 
  example
  ```
  class Overloading{
    // test 메서드, 매개변수는 없음.
    void test(){ 
        System.out.println("매개변수없음");
    }
    
    // test 메서드, 두 매개변수를 정수형으로 받는다.
    void test(int a, int b){
        System.out.println("매개변수 : "+a+", "+b);
    }
    
    // test 메서드, 매개변수를 문자형으로 받는다.
    void test(String c){
        System.out.println("매개변수 : "+ c);
    }
}

public class OverloadingTest{

     public static void main(String []args){
     
        // overloading 객체를 생성한다.
        Overloading out = new Overloading();
        
        // 매개변수가 없는 test_01()을 호출한다.
        out.test();
        
        // 정수형 매개변수 test_02()을 호출한다.
        out.test(10, 20);
        
        // 문자형 매개변수 test_03()을 호출한다.
        out.test("Overloading Example");
        
     }
}
  ```
  
  실행결과
  ```
$javac OverloadingTest.java
$java -Xmx128M -Xms16M OverloadingTest
매개변수없음
매개변수 : 10, 20
매개변수 : Overloading Example
  ```
  
 - 오버라이딩(Overriding)
  상위 클래스가 가지고 있는 멤버의 변수가 하위 클래스로 상속된다.
  단순 멤버 변수 + 메소드까지 모두 복붙, 하위 클래스에서 메서드를 재정의하여 사용이 가능하다.
  즉, 부모 클래스의 메서드는 무시하고 자식 클래스의 메서드 기능을 사용.
  
 example
 ```
 class Overriding{
    public String name;
    public int age;
    
    // introduce 메서드
    public void introduce() {
        System.out.println("My name is "+name+", I'm "+age+" years old.");
    }
}

// Overriding Class(부모 클래스 상속)
class Job extends Overriding{
    
    String position;
    
    // 부모 클래스에 있는 introduce 메서드 재정의
    public void introduce() {
        super.introduce();
        System.out.println("I'm the "+position+".");
    }
}

public class OverridingTest {
    
    public static void main(String[] args) {
        
        // Job 객체 생성
        Job job = new Job();
        
        job.name = "choidoa";
        job.age = 24;
        job.position = "manager";
        
        job.introduce();
    }
}
 ```
 실행결과
 ```
$javac OverridingTest.java
$java -Xmx128M -Xms16M OverridingTest
My name is choidoa, I'm 24 years old.
I'm the manager.
 ```
 
 
 부모 클래스를 상속받은 overriding 클래스의 introduce 메서드에서 supper 제외
 ```
 class Overriding{
    public String name;
    public int age;
    
    // introduce 메서드
    public void introduce() {
        System.out.println("My name is "+name+", I'm "+age+" years old.");
    }
}

// Overriding Class(부모 클래스 상속)
class Job extends Overriding{
    
    String position;
    
    // 부모 클래스에 있는 introduce 메서드 재정의
    public void introduce() {
        //super.introduce();
        System.out.println("I'm the "+position+".");
    }
}

public class OverridingTest {
    
    public static void main(String[] args) {
        
        // Job 객체 생성
        Job job = new Job();
        
        job.name = "choidoa";
        job.age = 24;
        job.position = "manager";
        
        job.introduce();
    }
}
 ```
 
 실행결과
 ```
$javac OverridingTest.java
$java -Xmx128M -Xms16M OverridingTest
I'm the manager.
 ```
 
 - super 예약어를 사용하면 상위클래스의 생성자에도 접근할 수 있게 된다.
