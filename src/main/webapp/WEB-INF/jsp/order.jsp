<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/component/style.jsp" %>
    <link rel="stylesheet" href="/css/order.css" />
     <script src="/js/order.js" defer></script>
    <title>Order</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
     <!-- Main -->
    <main>
      <div class="main__header">주문결제</div>
      <form method="post" action="/v1/order.do">
        <div class="main__content">
          <div class="main__left">
            <section class="client__sec">
              <div class="section__header">주문자 정보</div>
              <div class="section__content">
                <div class="input__flex client__name">
                  <div class="head">이름 <span>*</span></div>
                  <div class="tail"><input type="text" name="name" /></div>
                </div>
                <div class="input__flex client__email">
                  <div class="head">이메일 <span>*</span></div>
                  <div class="tail">
                    <input type="text" class="email__h" name="email_h" /> @
                    <input type="text" class="email_t" name="email_t" />
                  </div>
                </div>
              </div>
            </section>
            <section class="client__loc">
              <div class="section__header">배송지 정보</div>
              <div class="section__content">
                <ul class="loc__tabs">
                  <li class="active">배송지 선택</li>
                  <li>신규 배송지</li>
                </ul>
                <div class="input__flex receiver__name">
                  <div class="head">받는 분<span> *</span></div>
                  <div class="tail"><input type="text" name="rcv_name"/></div>
                </div>
                <div class="input__flex loc__detail">
                  <div class="head">주소 <span>*</span></div>
                  <div class="tail">
                    <div class="search__loc">
                      <input type="text" disabled />
                      <div class="search__btn"></div>
                    </div>
                    <input type="text" name="rcv_addr1" disabled />
                    <input type="text" name="rcv_addr2"/>
                  </div>
                </div>
              </div>
            </section>
            <section class="order_items">
              <div class="section__header">주문상품 확인</div>
              <div class="section__content">
                <ul class="itemList">
                <c:forEach var="entry" items="${prods}">
                  <li class="item" optn="${entry.optnId}" prod="${entry.prodId }">
                    <h1 class="item__header">
                      ${entry.prodName }
                    </h1>
                    <div class="item__content">
                      <div class="item__left">
                        <div class="item__img">
                          <img src="${entry.thumbUrl }" alt="" />
                        </div>
                        <div>
                          수량: <span class="count">${entry.stock }</span>개 </br>
                        	옵션: <span class="optnName">${entry.optnName }</span>
                        </div>
                      
                      </div>
                      <div class="item__right">
                        <div>
                          <div class="head">상품금액</div>
                          <div class="tail origin_price">${entry.originPrice*entry.stock }원</div>
                        </div>
                        <div>
                          <div class="head">할인금액</div>
                          <div class="tail discount">${(entry.marketPrice-entry.originPrice)*entry.stock }원</div>
                        </div>
                        <div>
                          <div class="head">결제예정금액</div>
                          <div class="tail discount_price">${entry.marketPrice*entry.stock }원</div>
                        </div>
                      </div>
                    </div>
                  </li>
                </c:forEach>
                  <!--  
                  <li>
                    <h1 class="item__header">
                      [vezzly] 새벽 5시에 갓 짠 진짜 우유식빵
                    </h1>
                    <div class="item__content">
                      <div class="item__left">
                        <div class="item__img">
                          <img src="/img/order/item_img.jpeg" alt="" />
                        </div>
                        수량: <span class="count">1</span>개
                      </div>
                      <div class="item__right">
                        <div>
                          <div class="head">상품금액</div>
                          <div class="tail origin_price">5,400원</div>
                        </div>
                        <div>
                          <div class="head">할인금액</div>
                          <div class="tail discount">1000원</div>
                        </div>
                        <div>
                          <div class="head">결제예정금액</div>
                          <div class="tail discount_price">4,400원</div>
                        </div>
                      </div>
                    </div>
                  </li>
                   -->
                </ul>
                <div class="delivery__price">
                  <p>배송비 <span class="de_p">3,000원</span></p>
                  <p>(30,000원 이상 구매시 무료배송)</p>
                </div>
              </div>
            </section>
          </div>
          <div class="main__rigth">
            <section>
              <div class="section__header">결제금액</div>
              <div class="section__content price__detail">
                <div>
                  <div class="head">총 상품금액</div>
                  <div class="tail total_price">5,400원</div>
                </div>
                <div>
                  <div class="head">총 할인금액</div>
                  <div class="tail total_discount">0원</div>
                </div>
                <div>
                  <div class="head">총 배송비</div>
                  <div class="tail dep">0원</div>
                </div>
              </div>
              <div class="section__content price__result">
                <div>총 결제 예정금액</div>
                <div>
                  <div class="rank__underline"></div>
                  <span class="total_market">5,400원</span>
                </div>
              </div>
              <div class="section__content orderBtn">
                <button><div class="order__submit">결제하기</div></button>
              </div>
            </section>
          </div>
        </div>
        <input type='hidden' name="prods"/>
      </form>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
