<!-- author 이세아 -->
 
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/home.css" />
    <script src="/js/home.js" defer></script>
    <script src="/js/banner.js" defer></script>
    <%@include file="/WEB-INF/component/style.jsp" %>
    <title>Home</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    
 <div class="banner">
    <div class="container">
        <div class="img_wrap">
            <ul class="rollimgs">
               <li><img src="/img/main/main_banner.jpeg" alt=""></li>
     			<li><img src="/img/main/main_banner2.jpg" alt=""></li>
     			<li><img src="/img/main/main_banner3.jpg" alt=""></li>
     			<li><img src="/img/main/main_banner4.jpg" alt=""></li>
     			<li><img src="/img/main/main_banner5.jpg" alt=""></li>
          	  </ul>
         </div>
      </div>
  </div>

  <div class="floatbanner">
  	<ul>
     	<li><a href="/v1/discountProductList"><img src="/img/main/main_float.png" alt=""></a></li>
     </ul>
  </div>


    <main>
      <!-- CATEGORYAREA-->
      <div class="categoryArea">
        <div class="category__text">
          <p>건강은 밥상으로부터</p>
          <h1>그리팅이 자신있게 추천드려요</h1>
        </div>
        <div class="categoryList">
          <ul>
            <li><a val='55' href="">건강반찬</a></li>
            <li><a val='1058' href="">진한 국/찌개</a></li>
            <li><a val='3058' href="">자연 담은 면</a></li>
            <li><a val='719' href="">영양가득 밥/죽</a></li>
            <li><a val='718' href="">샐러드/샌드위치</a></li>
            <li><a val='1198' href="">베이커리</a></li>
            <li><a val='1699' href="">착한 간식/음료</a></li>
            <li><a val='1139' href="">1Table</a></li>
            <li><a val='2598' href="">안심 키즈</a></li>
            <li><a val='818' href="">시니어 건강</a></li>
            <li><a val='2018' href="">비건/순식물성</a></li>
          </ul>
        </div>
      </div>
      <!--ITEMSLIT-->
      <ul class="itemList">
       
      </ul>
      <div class="moreBtnArea">
        <a href="/v1/itemList"><div class="moreBtn">착한 간식/음료 전체보기 ></div></a>
      </div>
    </main>

     <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
