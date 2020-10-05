## 체크리스트 및 내용 정리

**FE 기술요구사항**

- [x]  html layout tag를 사용
    - 시맨틱 태그(header, nav, section, article, aside, footer)
- [ ] classname은 일정한 컨벤션을 유지
    - 잘 모르겠음
- [x] 의미에 맞는 tag를 최대한 사용하되, div 사용은 최대한 자제할 것
- [x] position 속성과 float 를 사용해서 element를 배치하여야 함
    - flex 속성 사용
- [x] 라이브러리를 사용한 레이아웃은 안 됌
- [x] id와 class 등의 다양한 selector 문법을 활용
    - id 와 class를 사용하였으나, 현재는 내가 보기 편하도록 네이밍을 지정하였다. 변경이 필요하다.

**BE 기술요구사항**

- [x] Dynamic Web Project - 프로젝트 이름은 aboutme
- [x] aboutme 프로젝트의 webContent 폴더에 index.html, aboutme.html, photo.html 파일 작성
- [x] 서블릿 클래스 이름은 TodayServlet
- [x] 서블릿 URL 경로 [http://localhost](http://localhost)8080:/aboutmr/today
- [ ] 화면에 현재 시간과 메인화면 링크가 나오도록 페이지 작성

**index.html 페이지 요구사항**

- [x] index.html 파일을 생성
- [ ] 정렬과 배치, 간격을 일정하게 유지
- [x] 홈, 자기소개, 내사진, 몇시에요의 간격은 일정
    - 각 버튼 사이마다 margin-rigth 을 이용하여 간격을 동일하게 하였다.
- [x] 모든 콘텐츠는 가운데 정렬
    - 모든 콘텐츠는 text-align 속성을 이용하여 가운데 정렬을 하였다. 다르게 해야하나?
- [ ] 같은 list 태그를 사용하는 것들은 같은 높이와 넓이의 크기를 가져야 한다.
- [x] 네모난 UI는 그림자 효과
    - box-shadow 속성 이용
- [x] 지도는 이미지 형태로 추가
    - css 하위 폴더에 image 폴더를 추가하여 이미지 형태로 추가
- [x] 링크 해당하는 영역은 마우스를 올렸을 때 커서 모양이 손 모양으로 변경
    - cursor 속성을 이용하여 마우스 커서 모양 변경
- [ ] 푸터에는 URL 링크

**aboutme.html**

- [ ] index와 같이 간격과 배치를 동일하게 유지
- [x] 같은 수준의 태그에서는 같은 크기의 글자크기를 유지
- [ ] 우측 화면처럼 세 가지 영역으로 크게 나누어지고, 세 가지 영역간의 간격은 같아야 한다.

**photo.html**

- [ ] index와 같이 간격의 배치를 동일하게 유지
- [ ] 줄간격과 글자크기는 일관
- [x] 사진에는 테두리가 존재
- [x] header/footer 는 다른페이지와 같이 유지

**servlet**

- [ ] URL을 직접 호출하였을 때는 서블릿을 이용하여 현재시작이 출력되도록 구현, 현재시간은 java.time.LocalDateTime 클래스를 이용하여 구현하며, 몇시에요를 클릭하였을 때에도 해당 화면으로 이동

## 2020-10-03

index.html / main.css 페이지 작성 중

1. index 페이지를 개발자 도구를 이용하여 보다가, 잘못된 부분을 찾음
2. index.html h2 태그에 줄바꿈을 주지 않으면 상단바 왼쪽으로 이동하게 되는 현상
3. 각 버튼 내부의 여백이 동일하지 않음
4. 불필요한 CSS 속성은 삭제가 필요해보인다.
5. HTML 구조 설계가 올바르게 되었는지 좀 더 찾아보자.
6. class / id 이름 변경이 필요하다. 내가 보기 편하도록 해둠.
7. float 태그 X 
8. CSS 강의는 본 지 꽤 되었는데 잊어버린게 많다. 정리가 필요할 것 같음.

**프로젝트에 적용한 CSS 주요속성 정리**

float  : 특정 방향으로 배치하기 위한 속성

list-style-type : 목록의 볼릿을 삭제

border-radius : 모서리를 둥글게

box-shadow : 그림자 효과

cursor : 마우스의 커서를 변경

text-decoration : 하이퍼링크의 밑줄 제거

text-align : 정렬

border : 테두리

## 2020-10-04

**프로젝트 피드백 및 기타 내용정리**

1. 영역별로 색상을 입히고 시작을 하는게 좋음
2. Inline 태그와 block 태그
3. 태그별 Default 속성
4. hr 태그와 br 태그는 자제 → p 태그 사용, CSS 속성으로 br, hr 태그를 대체하는게 좋음
5. background-color → body
6. reset.css와 normalize.css (브라우저 기본 스타일 초기화)
7. float 으로 레이아웃을 잡지 않고, flex 를 사용
8. id는 고유한 것에만 지정
9. 전역에서 사용할 CSS 작성 → 각 페이지별 CSS
10.  * → 전체 태그에 모두 적용
11. CSS 우선순위
12. SCSS

**git**

git flow (git workflow)

[https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html)

**코딩컨벤션**

→ eslint airbnb

## 20201006

**html 구조 설계부터 다시해보았다.**

1. 네이밍 수정이 필요함
2. 자기소개 페이지의 텍스트 수직 가운데 정렬 필요
3. 이미지 왼쪽 정렬, 텍스트는 오른쪽으로 정렬되도록 수정 해야함

