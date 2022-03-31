<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cocktailer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/program.css" />
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="jqueryUIplugin/jquery-ui.css" />
    <link rel="shortcut icon" href="imgs/favicon.ico" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="jqueryUIplugin/jquery-ui.js"></script>

    <script src="js/sub3.js"></script>
  </head>
  <body>
   <jsp:include page="../include/header.jsp" />

	<c:forEach var="dto" items="${list}">
    <section class="third">
      <div class="contentbox">
        <!--제일바깥그림자박스-->
        <div class="ap-bg">
          <!--와인장배경-->
          <div class="contactbox">
            <!--contactus,폼 감싸는 박스-->
            <div class="contact-us">
              <h6>Contact Us</h6>
              <div class="us-cont">
                <p>광주 북구 경양로 170</p>
                <p>cocktailer@naver.com</p>
                <p>tel. 062-123-4567</p>
                <p>평일 10:30 ~ 20:30</p>
              </div>
            </div>
            <form action="programForm.do" method="POST">
            <div class="app-form">
              <ul>
                <li>
                  <p><input type="radio" name="pname" value="a" checked /> 칵테일 클래스</p>
                  <p><input type="radio" name="pname" value="b"/> 럼 공장 투어</p>
                  <p><input type="radio" name="pname" value="c"/> 럼 시음 투어</p>
                </li>
                <li>
                  <p><input type="text" name="name" placeholder="신청자 이름 입력" class="leftbox" value="${dto.name }" /></p>
                  <p><input type="text" name="phone" placeholder="전화번호 입력" class="rightbox" value="${dto.phone }"/></p>
                  <input type="hidden" name="id" value="${dto.id}" />
                </li>
                <li>
                  <p><input type="number" name="numofpeople" placeholder="인원수 입력" class="leftbox" /></p>
                  <p><input type="text" id="date" name="date" class="rightbox" placeholder="희망 날짜 선택" /><img src="./imgs/application-icon.png" class="datebox" /></p>
                </li>
                <li><button>신청 하기</button></li>
              </ul>
            </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    </c:forEach>
  </body>
</html>
