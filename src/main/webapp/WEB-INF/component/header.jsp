<%@page import="java.util.Iterator"%>
<%@page import="vo.UserVO"%>
<%@ page language="java"
    pageEncoding="UTF-8"%>
    
    
    <%
   
    	UserVO user = null;
    	if(session != null){
    		System.out.println("session exist");
    		
    		for(String val : session.getValueNames()){
    			System.out.println(val);
    		}
    		user = (UserVO) session.getAttribute("user");
    		if(user!= null){
    			System.out.println("user exist");
    			System.out.println(user.getName());
    		}
    	}
    
    %>

    
    <!-- Header -->
    <header>
      <div class="header__content">
        <div class="header__btn">
          <ul>
          <% 
          	if (user == null || user.getName() == null){
          %>
	            <li><a href="/v1/signin">로그인</a></li>
	            <li><a href="/v1/signup">회원가입</a></li>
           <%
          	}else{
          	%>
          		<li><a href="/v1/signin"><%=user.getName() %></a></li>
          	<%
          	}
          	%>
        
           
            <li><a href="">쿠폰/교환권</a></li>
            <li><a href="">고객센터</a></li>
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
            <li>
              <a href="/v1/itemList"><i></i>건강반찬</a>
              <ul>
                <li><a href="/v1/itemList">메인요리</a></li>
                <li><a href="/v1/itemList">밀키트</a></li>
                <li><a href="/v1/itemList">밑반찬</a></li>
                <li><a href="/v1/itemList">나물</a></li>
                <li><a href="/v1/itemList">소스/양념</a></li>
                <li><a href="/v1/itemList">키즈</a></li>
              </ul>
            </li>
            <li>
              <a href="/v1/itemList"><i></i>진한 국/찌개</a>
              <ul>
                <li><a href="/v1/itemList">국</a></li>
                <li><a href="/v1/itemList">찌개</a></li>
              </ul>
            </li>
            <li>
              <a href=""><i></i>자연 담은 면</a>
              <ul>
                <li><a href="">국수</a></li>
                <li><a href="">파스타</a></li>
              </ul>
            </li>
            <li>
              <a href=""><i></i>영양가득 밥/죽</a>
              <ul>
                <li><a href="">밥</a></li>
                <li><a href="">죽</a></li>
              </ul>
            </li>
            <li>
              <a href=""><i></i>샐러드/샌드위치</a>
              <ul>
                <li><a href="">샐러드</a></li>
                <li><a href="">샌드위치</a></li>
                <li><a href="">브런치박스</a></li>
              </ul>
            </li>
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
        <i class="fa-solid fa-cart-shopping"></i>
      </div>
    </div>
    <div class="header__divider"></div>