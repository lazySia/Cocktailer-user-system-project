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
    <link rel="stylesheet" href="css/mypage.css" />
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="jqueryUIplugin/jquery-ui.css" />
    <link rel="shortcut icon" href="imgs/favicon.ico" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/sub3.js"></script>
  </head>
  <body>
   <jsp:include page="../include/header.jsp" />
<c:forEach var="dto" items="${list}">
    <div class="container-mypage">
      <section class="infoupdate-form">
        <h2>My Page</h2>
        
        <form action="updateForm.do" method="POST">
          <div class="int-area">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" readonly value="${dto.id}" />
          </div>
          <div class="int-area">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" value="${dto.name}" autocomplete="off" required />
          </div>
          <div class="int-area">
            <label for="age">나이</label>
            <input type="number" id="age" name="age" value="${dto.age }" autocomplete="off" required />
          </div>
          <div class="int-area">
            <label for="phone">휴대폰 번호</label>
            <input type="tel" id="phone" name="phone" value="${ dto.phone }" autocomplete="off" required />
          </div>
          <div class="int-area">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" value="${ dto.email }" autocomplete="off" />
          </div>
          <div class="btn-area">
            <button id="btn" type="submit">회원정보 변경</button>
          </div>
        </form>
        
      </section>
      <section class="infoupdate-form pwd-form">
        <!-- <h2>비밀번호 변경</h2> -->
        <form action="updatePwd.do" method="POST">
          <div class="int-area">
            <label for="old-pwd">기존 비밀번호</label>
            <input type="password" id="old-pwd" name="old-pwd" autocomplete="off" required />
            <input type="hidden" name="id" value="${dto.id}">
          </div>
          <div class="int-area">
            <label for="pwd">새 비밀번호</label>
            <input type="password" id="pwd" name="pwd" autocomplete="off" required />
          </div>
          <div class="int-area">
            <label for="pwd2">비밀번호 확인</label>
            <input type="password" id="pwd2" name="pwd2" autocomplete="off" required />
          </div>
          <div class="btn-area">
            <button id="btn" type="submit">비밀번호 변경</button>
          </div>
        </form>
        <form action="withdraw.do" method="POST">
       		<div class="int-area">
	          	<input style="width:100%" type="password" id="pwd" name="pwd"  autocomplete="off" placeholder="비밀번호 확인" required>
	            <input type="hidden" name="id" value="${dto.id}">
            </div>
          	<div class="btn-area">
	          	<p style="color:#f00; text-align:center; margin-bottom:5px;">비밀번호 입력 후 아래 버튼을 누르면 계정이 완전히 삭제됩니다.</p>
          	  <button id="btn">회원탈퇴</button>
          	</div>
        </form>
      </section>
    </div>
    </c:forEach>
  </body>
</html>
