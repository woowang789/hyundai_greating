<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/signin.css" />
    <!-- fontawesome -->
    <script
      src="https://kit.fontawesome.com/f5ed871e11.js"
      crossorigin="anonymous"></script>
    <title>SingIn</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <%@include file="/WEB-INF/component/header.jsp" %>

    <!--Main -->
    <main>
      <div class="main__header">
        <h1>로그인</h1>
        <p>로그인을 하시면 다양한 혜택을 누리실 수 있습니다.</p>
      </div>
      <div class="main__input">
        <input type="text" placeholder="아이디" />
        <input type="text" placeholder="비밀번호" />
      </div>
      <div class="main__check">
        <i class="fa-regular fa-circle-check"></i><span>아이디 저장</span>
      </div>
      <div class="main__signinBtn">로그인</div>
      <div class="main__signupBtn">회원가입</div>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
