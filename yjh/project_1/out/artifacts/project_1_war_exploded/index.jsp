<%--
  Created by IntelliJ IDEA.
  User: junhyeok
  Date: 2020/09/30
  Time: 3:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>project_1</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <link rel="stylesheet" href="./project1.css">
</head>
<body>

<jsp:include page="./nav.jsp" flush="false"/>

<div class="content">
    <h1>자기소개 메인 페이지입니다.</h1>
    <p>
        자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.
        자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.자기소개 메인 페이지입니다.
    </p>
    <div>
        <a class="btn-big" href="profile.jsp" type="button">소개</a>
        <a class="btn-big" href="album.jsp" type="button">사진</a>
    </div>
    <img class="img-map" src="img/img_07.png" alt="">
</div>

<jsp:include page="./footer.jsp" flush="false"/>

</body>
</html>
