<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@include file="/WEB-INF/component/style.jsp" %>
    <link rel="stylesheet" href="/css/view_item_list.css" />
    <script src="/js/view_item_list.js" defer></script>
    <script src="/js/jquery.cookie.js"></script>  
<title>Like Item</title>
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
        <!--Main-->
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
        <div class="center__header"><span><%=user.getName() %></span>님 반갑습니다.</div>
        <div class="center__body">
          <div class="body__header">
            <div class="select__all">
              <i class="fa-regular fa-circle-check"></i>
              <p>전체선택</p>
            </div>
            <div class="delete__selected">
              <i class="fa-solid fa-trash-can"></i>
              <p>삭제</p>
            </div>
          </div>
          <ul class="itemList">
          
          <c:forEach var="el" items="${prods}">
          <li>
              <div class="item" val="${el.id}">
                <div class="item__img">
                  <img src="${el.prodImgUrl }" alt="" />
                  <div class="img__badge">${el.storage }</div>
                </div>
                <div class="item__title">
                  <p>${el.subName }</p>
                  <h1>${el.name}</h1>
                </div>
                <div class="item__bottom">
	                <div class='price_wrap'>
	                <c:if test="${el.discountRate != 0}">
	                  <span class='discnt_rate'>${el.discountRate}%</span>
	    			  <span class='origin_prcie'>${el.originPrice}원</span>
	                </c:if>
	                  <h1 class="item__price">
	                  <fmt:formatNumber value="${el.marketPrice}" pattern="#,###" />원</h1>
	                </div>
                </div>
                <c:if test="${not empty el.grts}">
                <div class="item__value">
                  <i class="fa-solid fa-award"></i>
                  <span>${el.grts }</span>
                </div>
                </c:if>
                <div class="check__btn">
                  <i class="fa-solid fa-circle-check"></i>
                </div>
              </div>
            </li>
          </c:forEach>
            <!-- 
            <li>
              <div class="item" val="123">
                <div class="item__img">
                  <img src="../img//main/main_item_img.jpeg" alt="" />
                  <div class="img__badge">냉장</div>
                </div>
                <div class="item__title">
                  <p>집에서 즐기는 베트남식 샌드위치</p>
                  <h1>부드러운 소불고기 반미 샌드</h1>
                </div>
                <div class="item__bottom">
                  <h1 class="item__price">2,900원</h1>
                  <div class="item__shoppingcart">
                    <i class="fa-solid fa-cart-shopping"></i>
                  </div>
                </div>
                <div class="item__value">
                  <i class="fa-solid fa-award"></i>
                  <span>프리미엄 식재</span>
                </div>
                <div class="check__btn">
                  <i class="fa-solid fa-circle-check"></i>
                </div>
              </div>
            </li>
            -->
          </ul>
          <div class="pagingArea">
            <ul class="paging">
              <li><a href="">1</a></li>
              <li><a href="">2</a></li>
              <li><a href="">3</a></li>
              <li><a href="">4</a></li>
              <li><a href="">5</a></li>
              <li><a href="">6</a></li>
              <li><a href="">7</a></li>
              <li><a href="">></a></li>
              <li><a href="">>></a></li>
            </ul>
          </div>
        </div>
      </div>
    </main>

	<!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
</body>
</html>