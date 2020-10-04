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
    <h1>자기소개 사진 페이지입니다.</h1>

    <ul>
        <li>
            <img class="left" src="img/img_06.jpeg" alt="#">
            <div class="li-content">
                <h3>여행</h3>
                <p>
                    2018.09 - 2018.11<br>
                    첫 해외 여행
                </p>
            </div>
        </li>
        <li>
            <img class="left" src="img/img_01.jpeg" alt="#">
            <div class="li-content">
                <h3>활동</h3>
                <p>
                    2019.07 - 2019.08<br>
                    해커톤_MAYODAY
                </p>
            </div>
        </li>
    </ul>
</div>

<jsp:include page="./footer.jsp" flush="false"/>

</body>
</html>
