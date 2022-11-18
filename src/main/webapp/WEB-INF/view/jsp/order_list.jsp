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
    <!-- Header -->
    <header>
      <div class="header__content">
        <div class="header__btn">
          <ul>
            <li><a href="">로그인</a></li>
            <li><a href="">회원가입</a></li>
            <li><a href="">쿠폰/교환권</a></li>
            <li><a href="">고객센터</a></li>
          </ul>
        </div>
        <div class="header__logo">
          <img src="../img/main/greating_logo.png" alt="" />
        </div>
        <div class="header__bottom">
          <div class="header__category">
            <a href=""><i class="fa-solid fa-bars"></i>카테고리</a>
          </div>
          <div class="header__menu">
            <ul>
              <li><a href="">브랜드 소개</a></li>
              <li><a href="">케어식단</a></li>
              <li><a href="">베스트</a></li>
              <li><a href="">할인</a></li>
              <li><a href="">기획전</a></li>
              <li><a href="">이벤트</a></li>
            </ul>
          </div>
          <div class="header__search">
            <input type="text" placeholder="검색어를 입력해주세요" />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>
          <div class="header__shoppingCart">
            <i class="fa-solid fa-cart-shopping"></i>
          </div>
        </div>
      </div>
      <div class="header__divider"></div>
    </header>

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
                  <option value="">배송준비</option>
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

    <!-- Footer -->
    <footer>
      <div class="footer__content">
        <ul class="footer__btn">
          <li><a href="">회사소개</a></li>
          <li><a href="">이용약관</a></li>
          <li><a href="">개인보호처리방침</a></li>
          <li><a href="">멤버심 프로그램</a></li>
        </ul>
        <div class="footer__info">
          <div class="info__left">
            <p class="left__title">고객센터</p>
            <p class="left__tel">1800-0700</p>
            <div class="left__desc">
              평일, 토요일 7:00~18:00 <br />
              공휴일 7시 ~ 13시 (일요일 휴무) <br />
              카카오톡 @그리팅 친구 추가하고 소식과 혜택을 받아보세요. <br />
            </div>
            <ul class="left__icon">
              <li>
                <a href=""><i class="fa-brands fa-instagram"></i></a>
              </li>
              <li>
                <a href=""><i class="fa-brands fa-youtube"></i></a>
              </li>
              <li><a href=""> </a></li>
              <li><a href=""> </a></li>
            </ul>
          </div>
          <div class="info__right">
            <p class="right__title">현대그린푸드</p>
            <div class="right__desc">
              대표이사 : 박홍진 | 사업장소재지 : 경기도 용인시 수지구 문인로
              30(동천동) 현대그린푸드 <br />
              사업자등록번호 : 211-81-08241 [사업자정보확인] | 통신판매신고번호
              : 제 2011-용인수지-0268 호 <br />
              개인정보보호책임자 : 김해곤 | 개인정보 관리 이메일 :
              hdgreenfood@hyundaigreenfood.com <br />
              호스팅 서비스 사업자 : (주)현대그린푸드 <br />
              그리팅의 개별 판매자가 등록한 상품(브랜드직송)에 대한 광고,
              상품주문, 배송, 환불의 의무와 책임은 <br />
              각 판매자가 부담하고, 그리팅은 통신판매 중개자로서의 의무와 책임을
              다합니다. <br />
            </div>
          </div>
        </div>
      </div>
    </footer>
</body>
</html>