<%@page import="vo.ProductDetailVO"%>
<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/component/style.jsp" %>
    <script src="/js/item_detail.js" defer></script>
    <link rel="stylesheet" href="/css/item_detail.css" />
    <link rel="stylesheet" href="/css/loading.css">
       <style type="text/css">
    #loading {
       height: 150vw;
    }
    #loading-image{
        margin-top: 200pt;
        height: 100pt;
        width: 100pt;
    }
    </style>
  
    <title>ItemDetail</title>
  </head>
  <body>
    <div class="modal__background"></div>
      
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
    
    <!--  Dialog -->
    <div class="dialog">
    	<div class="dialog__content">
    		장바구니에 담았습니다.</br>
    		바로 확인하시겠습니까?
    	</div>
    	<div class="dialog__btns">
    		<div class="to__home">쇼핑 계속하기</div>
    		<div class="to__cart">장바구니로 이동</div>
    	</div>
    </div>
    
    <!--OtionSelect-->
    <div class="option__select">
      <div class="select__header">옵션선택</div>
      <div class="select__body__wrap">
        <div class="select__body">
          <ul class="item__list">
          <c:forEach var="entry" items="${detail.optnList}">
            <li class="item" val="${entry.id}">
              <p class="item__name">${entry.name}</p>
              <div class="item__qty">
                <div class="qty__minus">-</div>
                <div class="qty">0</div>
                <div class="qty__plus">+</div>
              </div>
              <p class="item__price">${detail.prod.marketPrice}원</p>
            </li>
          </c:forEach>
          <!-- 
            <li class="item">
              <p class="item__name">[분다버그]진저비어</p>
              <div class="item__qty">
                <div class="qty__minus">-</div>
                <div class="qty">0</div>
                <div class="qty__plus">+</div>
              </div>
              <p class="item__price">2,900원</p>
            </li>
             -->
          </ul>
        </div>
        <div class="item__totlaPrice">총 상품금액<span>0원</span></div>
        <div class="select__btn">
          <div class="item__like">
          <c:if test="${not isInterested}" >
            <i class="fa-solid fa-heart"></i>
           </c:if>
           <c:if test="${ isInterested}" >
            <i class="fa-solid fa-heart active"></i>
           </c:if>
            관심상품
          </div>
          <div class="item__shoppingcart">장바구니담기</div>
          <div class="item__order">바로구매</div>
        </div>
      </div>
    </div>
    <div class="itemImgAndInfo">
      <div class="itemImgArea">
        <div class="itemImg">
          <img src="${detail.imgUrl }" alt="" />
        </div>
      </div>
      <div class="itemInfoArea">
        <div class="info__title">
          <div class="subtitleAndLike">
            <p class="subtitle">${detail.prod.subName }</p>
            <c:if test="${not isInterested}" >
            	<i class="fa-solid fa-heart"></i>
            </c:if>
            <c:if test="${isInterested}" >
            	<i class="fa-solid fa-heart active"></i>
            </c:if>
          </div>

          <h1 class="title">${detail.prod.name }</h1>
          <p class="origin">원산지 : ${detail.origin}</p>
        </div>
        <div class="info__price">
        <c:if test="${detail.prod.discountRate != 0}">
          <span class="discountRate">${detail.prod.discountRate }%</span>
        </c:if>
        
          <span class="discountPrice">${detail.prod.marketPrice }원</span>
          
        <c:if test="${detail.prod.discountRate != 0}">
          <span class="originPrice">${detail.prod.originPrice }원</span>
        </c:if>  
        </div>
        <div class="info__delivery info__flex">
          <div class="head">배송정보</div>
          <div class="tail">
            <span class="delivery__badge">일반배송</span>5pm 이전 결제시
            <span class="arrival__date">11월 14일(월) 도착 가능</span>
          </div>
        </div>
        <div class="info__deliveryPrice info__flex">
          <div class="head">배송비</div>
          <div class="tail"><span>3,000원</span> / 30,000원 이상 무료 배송</div>
        </div>
        <div class="info__seller info__flex">
          <div class="head">판매자</div>
          <div class="tail">
            <div class="seller__name">${detail.seller.name}</div>
            <div class="seller__tel">
              tel. <span class="tel">${detail.seller.tel}</span>
            </div>
          </div>
        </div>
        <ul class="info__btns">
          <li class="btn__addShoppingcart">장바구니 담기</li>
          <li class="btn__order">구매하기</li>
        </ul>
      </div>
    </div>
    <!-- InfoTabs -->
    <ul class="infoTabs">
      <li class="infoTab active">상품정보</li>
      <li class="infoTab">상품후기</li>
      <li class="infoTab">상품문의</li>
      <li class="infoTab">교환반품</li>
    </ul>

    <!-- ItemInfo -->
    <div>
      <div class="item__info">
      <c:if test="${fn:length(detail.grtList) != 0}">
      
        <div class="info__value">
          <div class="value__title">
            <i class="fa-solid fa-award"></i>greating's value
          </div>
          <div class="value__itemName">${detail.prod.name }</div>
          <ul class="value__icons">
          <c:forEach var="entry" items="${detail.grtList}">
          <li>
              <div class="value__icon">
                <img src="${entry.iconurl }" alt="" />
              </div>
              <span>${entry.name }</span>
            </li>
          </c:forEach>
            <!-- 
            <li>
              <div class="value__icon">
                <img src="../img/item_detail/value_ingredient.png" alt="" />
              </div>
              <span>프리미엄 식재</span>
            </li>
             -->
          </ul>
        </div>
        </c:if>
        <div class="info__simple">
          <ul class="simple__icons">
          <c:forEach var="entry" items="${detail.igdtList}">
	          <li>
	              <div class="simple__icon">
	                <img src="${entry.iconUrl }" alt="" />
	              </div>
	              <span>${entry.name }</span>
	            </li>
          </c:forEach>
            
          </ul>
          <div class="simple__capa simple__flex">
            <div class="head">용량</div>
            <div class="tail">${detail.vol }ml</div>
          </div>
          <div class="simple__kcal simple__flex">
            <div class="head">칼로리</div>
            <div class="tail">${detail.cal }kcal</div>
          </div>
          <div class="simple__origin simple__flex">
            <div class="head">원산지</div>
            <div class="tail">${detail.origin}</div>
          </div>
        </div>
        <div class="info__intro">
          ${detail.text }
        </div>
        <c:forEach var="entry" items="${detail.contextUrls}">
        <div class="item__img">
          <img src="${entry}" alt="" />
        </div>
        </c:forEach>
        <div class="item__area">
          <div class="info__header">
            <h1><span>greating's packaging</span></h1>
            <p>이렇게 포장됩니다.</p>
          </div>
          <div class="packageImg">
            <img src="${detail.pkgUrl}" alt="" />
          </div>
        </div>

        <div class="item__area">
          <div class="info__header">
            <h1><span>ingredients</span></h1>
            <p>모든 재료를 확인하세요</p>
          </div>

          <div class="IngredientsImg">
            <img src="../img/item_detail/item_ingredients.jpeg" alt="" />
          </div>
        </div>
      </div>
      <div id="loading">
        <img id="loading-image" src="../img/loading.gif"/>
         </div>
         <script src="/js/loading.js" defer></script>
    <script>
    window.onload = function () {
 	   $("#loading").hide();
    	}
    </script>
   
   
    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>