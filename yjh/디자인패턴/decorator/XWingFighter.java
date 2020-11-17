package decorator;

public class XWingFighter implements Fighter {
    @Override
    public void attack() {
        System.out.println("기본 공격");
    }
}
