## Create Maven + Mysql + JSP Todo web application

### 필요한 dependency 라이브러리
- `maven-archtype-webapp` 으로 maven 프로젝트 생성
- servlet api 추가
- jstl 문법 사용하기위한 라이브러리 추가
- mysql 연결 라이브러리추가
- json 객체로 반환시키기 위한 의존성 라이브러리 추가

### Todo application 에서 필요한것
- 할일 등록
- 할일 수정
- 할일 삭제
- 할일 목록 출력
- 할일 등록 페이지
- 할일 목록 페이지

### DTO 패키지
DAO 에서 사용될 객체들에 대한 정의 

### DAO 패키지
DB의 연결과 데이터베이스 관련 로직 메소드들을 정의

### Servlet
jsp 에서 요청을 받아 어떤 처리를 할지에 대한 로직을 정의

## 진행상황
### 10/12
현재까지 진행상황  
- [x] 할일 등록 html 구성
- [x] 할일 목록 화면 html, css 구성
- [x] mysql 과 java 연결 설정
- [x] DTO, DAO 세팅중

### 10/19
진행상황
- [x] 프로젝트 리셋 후 재구축
- [x] DTO, DAO 세팅중
- [x] mysql 과 java 연결 설정
- [x] 프론트 => 서버로 get, post 요청 하여 console 에 출력되는 내용 확인

해야할것
- [ ] 화면구성
- [ ] css 적용 
- [ ] 등록한 할일 메인 jsp 에서 출력되도록
- [ ] 등록한 할일 type 변경시 서버 db update

### 10/21
진행상황
- [x] 서버에서 받아온 데이터로 화면 구성중
- [x] 등록한 할일 메인 jsp 에서 출력되도록
- [x] fetch api 사용하여 서버에 요청전달 
