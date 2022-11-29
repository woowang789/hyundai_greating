<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/signup.css" />
    <script src="/js/signup.js" defer></script>
    <%@include file="/WEB-INF/component/style.jsp" %>

    <title>Signup</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <!-- main -->
    <main>
      <form method="post" action="/v1/signup.do">
        <div class="main__header">정보입력</div>
        <div class="main__content">
          <div class="content__header">회원 정보 입력 (필수)</div>
          <div class="content__body">
            <div class="name__input input__flex">
              <div class="head">이름</div>
              <div class="tail">
                <input type="text" name="name" />
                <p>* 한글은 10자, 영문은 20자 이내로 입력해 주세요</p>
              </div>
            </div>
            <div class="id__input input__flex">
              <div class="head">아이디</div>
              <div class="tail">
                <input type="text" name="id" />
                <div class="idCheckBtn checkBtn">중복확인</div>
                <p>
                  * 6자리 이상의 영문 혹은 영문, 숫자를 조합하여 입력해 주세요
                </p>
              </div>
            </div>
            <div class="pw__input input__flex">
              <div class="head">비밀번호</div>
              <div class="tail">
                <input type="password" name="pw" />
                <p>
                  * 영문, 대소문자, 숫자, 특수문자 중 3개 이상을 조합하여 8자리
                  이상 입력해 주세요
                </p>
              </div>
            </div>
            <div class="pwCheck__input input__flex">
              <div class="head">비밀번호 확인</div>
              <div class="tail">
                <input type="password" name="pw_check" />
              </div>
            </div>
            <div class="email__input input__flex">
              <div class="head">이메일</div>
              <div class="tail">
                <input type="text" name="e_h" /> @
                <input type="text" name="e_t" />
              </div>
            </div>
            <div class="birth__input input__flex">
              <div class="head">생년월일</div>
              <div class="tail">
                <input type="text" name="birth" placeholder="예 : 2022-12-31" />
              </div>
            </div>
            <div class="gender__input input__flex">
            <input type="hidden" name="gender">
              <div class="head">성별</div>
              <div class="tail">
                <div class="gender__male">
                  <i class="fa-regular fa-circle-check" val="M"></i>남성
                </div>
                <div class="gender__female">
                  <i class="fa-regular fa-circle-check" val="F"></i>여성
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="main__btns">
          <div class="signup__cancel">취소</div>
          <button class="signup__submit">회원가입</button>
        </div>
      </form>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
