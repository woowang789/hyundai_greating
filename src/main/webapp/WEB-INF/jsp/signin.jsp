<%@page import="vo.UserVO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/signin.css" />
    <script src="/js/signin.js" defer></script>
	<%@include file="/WEB-INF/component/style.jsp" %>
    <title>SignIn</title>
  </head>
  <body>
  <%
  		
  %>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>

    <!--Main -->
    <main>
      <div class="main__header">
        <h1>로그인</h1>
        <p>로그인을 하시면 다양한 혜택을 누리실 수 있습니다.</p>
      </div>
          <form method="post" action="/v1/signin.do">
          <c:if test="${not empty param.redirect}">
            <input type="hidden" value='${param.redirect}' name="redirect" />
	      </c:if>
	      <div class="main__input">
	        <input type="text" name='id' placeholder="아이디" />
	        <input type="text" name='pwd' placeholder="비밀번호" />
	      </div>
	      <!--
	      <div class="main__check">
	        <i class="fa-regular fa-circle-check"></i><span>아이디 저장</span>
	      </div>
	       -->
	      <input type="submit" value="로그인" class="main__signinBtn signin" />
	      </form>
	      <div class="main__signupBtn">회원가입</div>
	    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
