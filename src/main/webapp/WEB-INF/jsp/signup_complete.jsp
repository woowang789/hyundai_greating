<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/signup_complete.css" />
	<%@include file="/WEB-INF/component/style.jsp" %>
    <title>Signup Complete</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp">
    </jsp:include>
    
    <!--Main -->
    <main>
      <div class="main__haeder">가입완료</div>
      <div class="main__content">
        <i class="fa-solid fa-clipboard-check"></i>
        <p><span>왕종휘</span>님 가입해주셔서 감사합니다.</p>
        <div class="content__divider"></div>
        <div class="content__desc">
          <p>지금부터 그리팅몰의 다양한 컨텐츠와 혜택을 누려보세요!</p>
          <p>가입 시 입력한 회원정보는</p>
          <p><span>마이페이지</span>에서 확인 및 수정하실 수 있습니다.</p>
        </div>
        <div class="content__btn">쇼핑 계속하기</div>
      </div>
    </main>
    
    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
