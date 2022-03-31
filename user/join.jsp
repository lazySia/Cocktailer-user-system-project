<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="shortcut icon" href="imgs/favicon.ico" />
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/join.css" />
    <title>Cocktailer - 회원가입</title>
  </head>
  <style>
    a {
      text-decoration: none;
      color: #333;
      border: 0;
      outline: none;
    }
    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      padding: 0 20px 0 20px;
      height: 65px;
      background: #fff;
      box-shadow: 0 2px 2px -2px #999;
      z-index: 999;
    }
    .logoname {
      font-family: "Paytone One", sans-serif;
      font-size: 28px;
      color: #332b3b;
    }
    .logoname span {
      color: #f771d1;
    }
    .mainBtn {
      padding: 8px 32px 8px 32px;
      border-radius: 5px;
      font-size: 14px;
    }
    .mainBtn.mainBtn-color {
      background: #f771d1;
      color: #fff;
    }
    .mainBtn.mainBtn-color:hover {
      background: #f771d1cc;
      transition: all 0.3s ease-in-out;
    }
  </style>
  <body>
  
   <jsp:include page="../include/header.jsp" />

    <div class="container-login">
      <section class="login-form">
        <h2>Join Cocktailer</h2>
        <form action="join.do" method="POST">
          <div class="int-area">
            <input type="text" name="id" id="id" autocomplete="off" required />
            <label for="id">ID</label>
          </div>
          <div class="int-area">
            <input type="password" name="pwd" id="pwd" autocomplete="off" required />
            <label for="pwd">PASSWORD</label>
          </div>
          <div class="int-area">
            <input type="text" name="name" id="name" autocomplete="off" required />
            <label for="name">이름</label>
          </div>
          <div class="int-area">
            <input type="number" name="age" id="age" min="19" autocomplete="off" required />
            <label for="age">나이</label>
          </div>
          <div class="int-area">
            <input type="tel" name="phone" id="phone" autocomplete="off" required />
            <label for="phone">휴대폰 번호</label>
          </div>
          <div class="int-area">
            <input type="email" name="email" id="email" autocomplete="off" />
            <label for="email">이메일(선택)</label>
          </div>
          <div class="btn-area">
            <button id="btn" type="submit">Join</button>
          </div>
        </form>
        <div class="caption">
          <p>Already have an account?<a href="goLogin.do"> Log in →</a></p>
        </div>
      </section>
    </div>
    <script src="js/join.js"></script>
  </body>
</html>
