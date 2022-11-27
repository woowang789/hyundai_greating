<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/component/style.jsp" %>
<link rel="stylesheet" href="/css/shoppingcart.css" />
<script src="/js/cart.js" defer></script>
<title>Shoppingcart</title>
</head>
<body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <%
    	String userId = "";
    	UserVO user =(UserVO) session.getAttribute("user");
    	if(user != null) userId = user.getId();
    	
    %>
    
    <script>
    	let userId = "<%=userId %>"
    </script>
	
	     <main>
      <h1 class="main__header">장바구니</h1>
      <div class="main__content">
        <div class="price__range">
          <p class="head">그리팅 안심배송 상품</p>
          <div class="range__back"><div class="range"></div></div>
          <p class="more">
            건강마켓 <span class="more_price">11,000원</span>
            <span>추가하면</span> 무료배송!
          </p>
          <div class="more__btn">더 담으로 가기</div>
        </div>
        <ul class="order__item__list">
          <li class="list__header">
            <div class="head__info">제품정보</div>
            <div class="head__price">판매금액</div>
            <div class="head__qty">수량</div>
            <div class="head__resultPrice">구매금액</div>
          </li>
          
          <c:forEach var="entry" items="${prods}">
          
          <li class="list__item" val="${entry.prodOptnId}">
            <div class="body__info">
              <div class="item__img">
                <img src="${entry.thumbUrl}" alt="" />
              </div>
              <p>${entry.prodName}</p>
            </div>
            <div class="body__price">${entry.originPrice}원</div>

            <div class="body__qty">
              <div class="qty__minus">-</div>
              <div class="qty">${entry.qty}</div>
              <div class="qty__plus">+</div>
            </div>
            <div class="body__resultPrice">${entry.marketPrice}원</div>
            <i class="fa-solid fa-xmark"></i>
          </li>
          </c:forEach>
          <!-- 
          <li class="list__item" val="1">
            <div class="body__info">
              <div class="item__img">
                <img src="../img/shoppingcart/item_img.jpeg" alt="" />
              </div>
              <p>[본가스시]제주 청귤 소바(2인분)</p>
            </div>
            <div class="body__price">9,500원</div>

            <div class="body__qty">
              <div class="qty__minus">-</div>
              <div class="qty">1</div>
              <div class="qty__plus">+</div>
            </div>
            <div class="body__resultPrice">7,500원</div>
            <i class="fa-solid fa-xmark"></i>
          </li>
          
           -->
        </ul>
        <div class="shoppingcart__notice">
          <p>
            ㆍ장바구니에 담긴 상품은 30일 동안 보관되며 30일 이후 자동
            삭제됩니다.
          </p>
          <p>ㆍ판매기간 또는 프로모션 종료 시 해당상품은 주문이 불가합니다.</p>
        </div>
      </div>
      <div class="main__bottom">
        <div class="bottom__header">
          총 상품금액 <span class="total_origin">26,700원</span>
          <i class="fa-solid fa-circle-minus"></i>
          총 할인금액<span class="total_margin">1,290원</span>
        </div>
        <div class="bottom__body">
          총 결제 예정 금액
          <div class="result__price">
            <span class="total_market"
              >25,410원
              <div class="price__underline"></div>
            </span>
          </div>
        </div>
        <div class="bottom__btn">구매하기</div>
      </div>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
</body>
</html>