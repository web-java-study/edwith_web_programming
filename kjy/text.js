
var unde;

var arr=[];

console.log(unde==undefined ? true : false);
console.log(unde ? true : false);
console.log(toString.call(arr));


console.log(arr===undefined ? true : false);
console.log(arr===null ? true :false );
console.log(arr? true : false);
console.log(toString.call(arr));

console.log(typeof(arr)!==undefined ? true : false);

console.log(Array.isArray(arr)? true : false);
console.log(arr.length>0 ? true : false);


//Array check
if(Array.isArray(arr) && arr.length>0){
	console.log("굿");
}

if (typeof arr !== 'undefined' && arr.length > 0) {
    console.log("굿");
}

var getName = () => {
	return "kim";
}

console.log(getName());


function run(){
	
	console.log("start");
	setTimeout(()=>{
		var msg = "hello";
		console.log(msg);
		console.log("setTime")

	},1000);
}

run();




function check_time(){
	let times = [];
	let start = Date.now();
	setTimeout(function run(){
	
		times.push(Date.now()-start);
	
		if(start+100 < Date.now()){	
			console.log(times);
		}else{
			console.log(times);
			setTimeout(run);
		}
	});
}

check_time();

//jsp
//https://bnzn2426.tistory.com/18
//<%@ %> 지시어 : page, include, taglib
//<% %> 스크립트릿 태그 : <% %> 동적인 데이터를 if for 문 활용
//<%! %> 선언태그 : jsp 페이지에서 java 멤버변수 또는 메소드 선언시
//<%-- --%> 주석태그 : 주석처리하고 싶은 부분


//에러코드
//https://developer.mozilla.org/ko/docs/Web/HTTP/Status

//redirect 와 forward 의 차이 
//redirect는 페이지 변환
//forward 는 request 로 받은 데이터를 가공하거나 날것의 형태로 다른 서블릿으로 재전송하는 것

//el 표기법 나누기는 div 
//empty empty 는 배열, 맵, collection, 등 빈문자열 이외의 경우에는 false 를 리턴

//jstl 이 되지 않을때 
//설치전에 apache 공홈에서 1.25 jstl tag library jar 파일을 WebContent/lib 에 저장

//mysql 데이터 베이스 만들기
//create database 데이터베이스이름

//계정만들기
//create user 아이디@'%' identified by '비밀번호';

//권한주기 (local 접속 외 계정)
//grant all PRIVILEGES on 데이터베이스이름.* to 계정이름 @'%' identified by '비밀번호'
//권한주기 (local 접속계정)
//grant all PRIVILEGES on 데이터베이스이름.* to 계정이름 @'localhost' identified by '비밀번호'

//권한주기 8.0 mysql
//grant all privileges on 데이터베이스이름.* to 계정이름 @'%'
// grant all privileges on connectDB.* to connectuser@'%';
// grant all privileges on connectDB.* to connectuser@'localhost';
// grant all privileges on connectDB.* to connectuser@'127.0.0.1';
//FLUSH PRIVILEGES


//권한주기 mysql8.0 두번째 방법

//유저리스트 및 권한확인
//SELECT host,user,Grant_priv,Super_priv FROM mysql.user;
//https://dev.mysql.com/doc/refman/8.0/en/grant.html#grant-overview

//user 권한수정
//update mysql.user set Grant_priv='Y', Super_priv='Y' where user='connectuser';
//commit;
//flush privileges;

//jdbc 설정중 아래의 에러가 발생할경우
//establishing ssl connection without server's identity verification is not recommended
//DriverManager url 값을 tring dburl = "jdbc:mysql://localhost:3306/connectdb?allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul&useSSL=false"; 수정

// caching_sha2_password authentication plugin 
// ALTER USER 'yourusername'@'localhost' IDENTIFIED WITH mysql_native_password BY 'youpassword';
// mysqlbench -> user and privileges -> 해당계정 비번변경

//select 문
//String sql = "select name from employee";
//conn = ConnectDatabase.getConnection();
//Statement st = conn.createStatement();
//ResultSet rs = st.executeQuery(sql);

//stmt.execute(“query”);             //any SQL
//stmt.executeQuery(“query”);     //SELECT
//stmt.executeUpdate(“query”);   //INSERT, UPDATE, DELETE

//insert 문


//			conn = DBUtil.getConnection();
//			String sql = "insert into todo values(?, ? ,?)";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, 2);
//			int rs = ps.executeUpdate();

//java api 문서
//https://docs.oracle.com/javase/8/docs/api/


//REST API 설명
//https://medium.com/@dydrlaks/rest-api-3e424716bab
//https://beyondj2ee.wordpress.com/2013/03/21/%EB%8B%B9%EC%8B%A0%EC%9D%98-api%EA%B0%80-restful-%ED%95%98%EC%A7%80-%EC%95%8A%EC%9D%80-5%EA%B0%80%EC%A7%80-%EC%A6%9D%EA%B1%B0/

//REST API
//URI 소문자만 입력!! 특수문자는 하이픈-(o) 만 허용. 언더바_(X)

//REST API error
//db class exception, jackson class exception 은 
//https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations/2.11.2
//위 사이트에서 JAR 파일을 다운로드 받아 WEB-INF/LIB 에 저장한다

//chrome, ie  MIME 으로 인한 js, css 로드불가시 Servers -> web.xml 에 아래 프로퍼티 추가하기
/*<servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/</url-pattern>
        <url-pattern>*.js</url-pattern>
	    <url-pattern>*.css</url-pattern>
	    <url-pattern>*.jpg</url-pattern>
	    <url-pattern>*.gif</url-pattern>
	    <url-pattern>*.png</url-pattern>
	    <url-pattern>*.ico</url-pattern>
	    <url-pattern>*.swf</url-pattern>
</servlet-mapping>*/

