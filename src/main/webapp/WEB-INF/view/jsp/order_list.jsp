<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <script
      src="https://kit.fontawesome.com/f5ed871e11.js"
      crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/order_list.css" />
<title>OrderList</title>
</head>
<body>
	<!-- HEADER Fragnent -->
	<%@include file="/WEB-INF/component/header.jsp"%>

	<!-- Main -->
    <main>
      <div class="main__left">
        <h1>마이페이지</h1>
        <div class="left__content">
          <ul class="shopping__log">
            <h3>나의 쇼핑내역</h3>
            <li><a href="">주문/배송 조회·변경</a></li>
          </ul>
          <ul class="interest_log">
            <h3>나의 관심내역</h3>
            <li><a href="">최근 본 상품</a></li>
            <li><a href="">관심상품</a></li>
          </ul>
          <ul class="post_log">
            <h3>나의 커뮤니티</h3>
            <li><a href="">나의 상품후기</a></li>
            <li><a href="">나의 상품문의</a></li>
          </ul>
          <ul class="post_log">
            <h3>회원정보</h3>
            <li><a href="">회원정보 수정</a></li>
            <li><a href="">로그인 기록 관리</a></li>
            <li><a href="">회원 탈퇴</a></li>
          </ul>
        </div>
      </div>
      
      <div class="main__center">
        <div class="center__header"><span>왕종휘</span>님 반갑습니다.</div>
        <div class="center__body">
          <h1>주문내역</h1>
          <div class="body__option">
            <div class="option__status input__flex">
              <div class="head">주문상태</div>
              <div class="tail">
                <select name="" id="">
                  <option value="">주문상태 전체</option>
                  <option value="">주문취소</option>
                  <option value="">배송준비</option>
                  <option value="">배송중</option>
                  <option value="">배송완료</option>
                </select>
              </div>
            </div>
            <div class="option__name input__flex">
              <div class="head">상품명</div>
              <div class="tail"><input type="text" /></div>
            </div>
            <div class="option__reset">
              <i class="fa-solid fa-arrow-rotate-left"></i>초기화
            </div>
            <div class="search__btn">조회</div>
          </div>
        </div>
        <ul class="order__list">
          <li class="order__item">
            <div class="order__head">
              <div class="head__left">
                주문일 : 2022-11-17 <span>상세보기 ></span>
              </div>
              <div class="head__right">주문취소</div>
            </div>
            <ul class="item__list">
              <li class="item">
                <div class="item__img">
                  <img src="../img/order_list/item__img.jpeg" alt="" />
                </div>
                <div class="item__info">
                  <p class="order__status">입금대기</p>
                  <h3>베지미트볼 파스타소스</h3>
                  <p class="desc">베이지트볼 파스타소스 250g</p>
                  <p class="price">5,500원 / 1개</p>
                </div>
              </li>
              <li class="item">
                <div class="item__img">
                  <img src="../img/order_list/item__img.jpeg" alt="" />
                </div>
                <div class="item__info">
                  <p class="order__status">입금대기</p>
                  <h3>베지미트볼 파스타소스</h3>
                  <p class="desc">베이지트볼 파스타소스 250g</p>
                  <p class="price">5,500원 / 1개</p>
                </div>
              </li>
            </ul>
          </li>
        </ul>
        <ul class="order__list">
          <li class="order__item">
            <div class="order__head">
              <div class="head__left">
                주문일 : 2022-11-17 <span>상세보기 ></span>
              </div>
              <div class="head__right">주문취소</div>
            </div>
            <ul class="item__list">
              <li class="item">
                <div class="item__img">
                  <img src="../img/order_list/item__img.jpeg" alt="" />
                </div>
                <div class="item__info">
                  <p class="order__status">입금대기</p>
                  <h3>베지미트볼 파스타소스</h3>
                  <p class="desc">베이지트볼 파스타소스 250g</p>
                  <p class="price">5,500원 / 1개</p>
                </div>
              </li>
              <li class="item">
                <div class="item__img">
                  <img src="../img/order_list/item__img.jpeg" alt="" />
                </div>
                <div class="item__info">
                  <p class="order__status">입금대기</p>
                  <h3>베지미트볼 파스타소스</h3>
                  <p class="desc">베이지트볼 파스타소스 250g</p>
                  <p class="price">5,500원 / 1개</p>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
</body>
</html>