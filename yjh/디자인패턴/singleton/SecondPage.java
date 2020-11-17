package singleton;

public class SecondPage {
    // static 이기 때문에 따로 선언안해도 사용가능
    private Settings settings = Settings.getSettings();

    public void printSettings(){
        System.out.println(settings.getDarkMode() + " "+ settings.getFontSize());
    }
}
