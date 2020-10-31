package strategy;

// 전략패턴이란
// 특정 컨텍스트에서 알고리즘을 별도로 분리하는 설계 방법을 의미합니다.
// 특정한 기능을 수행하는데에 있어 다양한 알고리즘이 적용될 수 있는 경우,
// 이 다양한 알고리즘을 별도로 분리하는 설계 방법을 의미합니다.


class aa implements SearchStrategy{
    @Override
    public void search() {
        System.out.println("aa");
    }
}
public class Main {
    public static void main(String[] args){
          MyProgram myProgram = new MyProgram();
          myProgram.testProgram();

          aa a = new aa();
          a.search();
    }
}
