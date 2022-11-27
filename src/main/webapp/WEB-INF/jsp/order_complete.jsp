<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/component/style.jsp" %>
<link rel="stylesheet" href="/css/order_complete.css" />
<script src="/js/order_complete.js" defer></script>
<title>OrderComplete</title>
</head>
<body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
	
    <!-- main -->
    <main>
      <div class="main__header">
        <h1>주문완료</h1>
        <h3>주문이 정상적으로 완료되었습니다.</h3>
        <p>
          주문하신 내역은
          <span>마이페이지 > 주문조회</span>
          에서 확인하실 수 있습니다.
        </p>
      </div>
      <div class="main__content">
        <section class="order__item__info">
          <div class="info__header">주문상품 정보</div>
          <ul class="item__list">
          <c:forEach var="prod" items="${order.orderProds}">
            <li class="item">
              <h1 class="item__header">${prod.prodName}</h1>
              <div class="item__body">
                <div class="body__left info__flex">
                  <div class="item__img">
                    <img src="${prod.thumbImgUrl}" alt="" />
                  </div>
                  <div class="wrap">
                    <p>옵션: ${prod.optName}</p>
                    <p>수량: ${prod.qty}개</p>
                  </div>
                </div>
                <div class="body__right">
                  <div class="info__flex">
                    <p>상품금액</p>
                    <p class="origin_price">${prod.originPrice}원</p>
                  </div>
                  <div class="info__flex">
                    <p>할인 금액</p>
                    <p class="discount">${prod.discountAmount}원</p>
                  </div>
                  <div class="info__flex right__resultPrice">
                    <p>결제예정금액</p>
                    <p class="discount_price">${prod.marketPrice}원</p>
                  </div>
                </div>
              </div>
            </li>
            
            </c:forEach>
            <!-- 
            <li class="item">
              <h1 class="item__header">[1Table]소곱창 오일 파스타</h1>
              <div class="item__body">
                <div class="body__left info__flex">
                  <div class="item__img">
                    <img src="../img/order_complete/item_img.jpg" alt="" />
                  </div>
                  <div class="wrap">
                    <p>옵션: [1Table]소곱창 오일 파스타</p>
                    <p>수량: 1개</p>
                  </div>
                </div>
                <div class="body__right">
                  <div class="info__flex">
                    <p>상품금액</p>
                    <p class="origin_price">11,500원</p>
                  </div>
                  <div class="info__flex">
                    <p>할인 금액</p>
                    <p class="discount">3,450원</p>
                  </div>
                  <div class="info__flex right__resultPrice">
                    <p>결제예정금액</p>
                    <p class="discount_price">8,050원</p>
                  </div>
                </div>
              </div>
            </li>
            
             -->
             
          </ul>
          <div class="item__bottom">
            <span>배송비</span> <span class="dep">무료배송</span>
          </div>
        </section>
        <section class="pay__price">
          <h1 class="info__header">결제금액</h1>
          <div class="info__body">
            <div class="total__itemPrice">
              <p class="head">총 상품금액</p>
              <p class="tail total_price">11,500원</p>
            </div>
            <div class="total__discountPrice">
              <p class="head">총 할인금액</p>
              <p class="tail total_discount">3,450원</p>
            </div>
            <div class="total__deliveryPrice">
              <p class="head">총 배송비</p>
              <p class="tail dep">0원</p>
            </div>
            <div class="total__resultPrice">
              <p class="head">총 결제 예정 금액</p>
              <p class="tail total_market">8,050원</p>
            </div>
          </div>
        </section>
        <section class="loc__info">
          <h1 class="info__header">배송지 정보</h1>
          <div class="info__body">
            <div class="receiver__name">
              <p class="head">받는분</p>
              <p class="tail">${order.receiverName}</p>
            </div>
            <div class="receiver__address">
              <p class="head">주소</p>
              <p class="tail">${order.receiverAddr}</p>
            </div>
            <div class="receiver__request">
              <p class="head">연락처</p>
              <p class="tail">${order.receiverTel}</p>
            </div>
          </div>
        </section>
      </div>
      <div class="main__bottom">
        <div class="home__btn"><a href="/v1/">홈으로</a></div>
        <div class="orderList__btn"><a href="/v1/orderList">주문조회</a></div>
      </div>
    </main>
    
    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>

</body>
</html>