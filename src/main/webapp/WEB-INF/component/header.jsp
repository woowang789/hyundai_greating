<%@page import="java.util.Iterator"%>
<%@page import="vo.UserVO"%>
<%@ page language="java"
    pageEncoding="UTF-8"%>
    
    
    <%
   		UserVO user = null;
    	if(session.getAttribute("user") != null)
    		user = (UserVO) session.getAttribute("user");
   	%>

    
    <!-- Header -->
    <header>
      <div class="header__content">
        <div class="header__btn">
          <ul>
          <% 
          	if (user == null){
          %>
	            <li><a href="/v1/signin">로그인</a></li>
	            <li><a href="/v1/signup">회원가입</a></li>
	            <li><a href="/v1/viewProductList">최근 본 상품</a></li>
           <%
          	}else{
          	%>
          		<li><a href="/v1/orderList"><%=user.getName()%></a></li>
          		<li><a href="/v1/signout">로그아웃</a></li>
          		<li><a href="/v1/cart">장바구니</a></li>
	            <li><a href="/v1/viewProductList">최근 본 상품</a></li>
          		<li><a href="/v1/likeProductList">관심 상품</a></li>
          	<%
          	}
          	%>
          </ul>
        </div>
        <div class="header__logo">
          <a href="/v1/"><img src="../img/main/greating_logo.png" alt="" /></a>
        </div>
      </div>
    </header>
    <div class="header__bottom">
      <div class="header__category">
        <a href=""><i class="fa-solid fa-bars"></i>카테고리</a>
        <div class="hover__menu">
          <ul>
            <h3>건강마켓</h3>
          </ul>
        </div>
      </div>
      <div class="header__menu">
        <ul>
          <li><a href="">브랜드 소개</a></li>
          <li><a href="">케어식단</a></li>
          <li><a href="/v1/bestItemList">베스트</a></li>
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
        <a href="/v1/cart"><i class="fa-solid fa-cart-shopping"></i></a>
      </div>
    </div>
    <div class="header__divider"></div>