package adapter;

// 어댑터패턴
// 인터페이스가 서로 다른 객체들이
// 같은 형식 아래 작동할 수 있도록 하는 역할

public class Main {
    public static void main(String[] args){
        MyProgram myProgram = new MyProgram();
        myProgram.testProgram();
    }
}
