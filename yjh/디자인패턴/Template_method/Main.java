package Template_method;

// 템플릿 메서드 과정
// 어떤일을 수행하는 몇가지 방법이 존재
// 전반적 과정에 공통된 절차가 있을 때
// 코드를 효율적으로 작성하기 위한 패턴

public class Main {
    public static void main(String[] args){
        new NaverMapView().initMap();
        new KakaoMapView().initMap();
    }
}
