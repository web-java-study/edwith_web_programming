package abstract_factory;

public class Main {
    public static void main(String[] args){
        new Console().LightFactory();
        new Console().DarkFactory();
    }
}
