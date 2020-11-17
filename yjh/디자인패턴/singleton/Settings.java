package singleton;

public class Settings {

    // 생성자를 private 를 통해 제한함
    private Settings() {};


    // static 으로 선언된 것들은 객체가 얼마나 만들어지든
    // 메모리에 지정된 공간에 딱하나만 존재
    // 컴파일시 메모리 지정.

    // 초기값을 null로 설정
    private static Settings settings = null;

    public static Settings getSettings(){
        // 한번도 실행되지 않은 경우
        if (settings == null){
            // settings를 선언
            settings = new Settings();
        }
        // 한번이라도 선언되었다면 그 값을 반
        return settings;
    }


    private boolean darkMode = false;
    private int fontSize = 13;

    // 접근가능한 부분
    // 현재 상태와 상태 변경하는 기능
    public boolean getDarkMode() {return darkMode;}
    public int getFontSize() {return fontSize;}

    public void setDarkMode(boolean _darkMode){
        darkMode = _darkMode;
    }
    public void setFontSize(int _fontSize){
        fontSize = _fontSize;
    }

}
