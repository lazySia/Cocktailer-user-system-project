<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

 <header>
      <a href="goIndex.do">
      <h1 class="logoname">COCK<span>TAILER</span></h1>
      </a>
      <div>
	 <c:set var="id" value="${id}" />
      	<c:if test="${!empty sessionScope.id}">
      	 <a href="mypage.do?id=${sessionScope.id}" class="mainBtn">MyPage</a>
      	 <a href="logout.do" class="mainBtn mainBtn-color">Logout</a>
      	</c:if> 
      	<c:if test="${empty sessionScope.id}">
        <a href="goLogin.do" class="mainBtn">Login</a>
        <a href="goJoin.do" class="mainBtn mainBtn-color">Join</a>
      </c:if> 
      </div>
    </header>