package Template_method;

public abstract class MapView {

    // 상속받을때 반드시 선언되어야하는 것
    protected abstract void connectMapServer();
    protected abstract void showMapOnScreen();
    protected abstract void moveToCurrentLocation();

    // 위에 내용을 사용하는 부분 override X
    public void initMap(){
        connectMapServer();
        showMapOnScreen();
        moveToCurrentLocation();
    }
}
