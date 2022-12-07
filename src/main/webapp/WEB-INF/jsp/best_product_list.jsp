<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/component/style.jsp" %>
    <link rel="stylesheet" href="/css/best_item_list.css" />
     <script src="/js/best_item_list.js" defer></script>
    <title>BestItemList</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <!--Best Category-->
    <ul class="bestCategory">
      <li><div  class="active">전체</div></li>
      <li><div val='55'>건강반찬</div></li>
      <li><div val='1058'>진한 국/찌개</div></li>
      <li><div val='3058'>자연 담은 면</div></li>
      <li><div val='719'>영양가득 밥/죽</div></li>
      <li><div val='718'>샐러드/샌드위치</div></li>
      <li><div val='1198'>베이커리</div></li>
      <li><div val='1699'>착한 간식/음료</div></li>
      <li><div val='1139'>1Table</div></li>
      <li><div val='2598'>안심 키즈</div></li>
      <li><div val='818'>시니어 건강</div></li>
      <li><div val='2018'>비건/순식물성</div></li>
    </ul>
    <!-- BestBanner -->
    <div class="bestBanner">
      <img src="../img/best_item_list/best_item_list_banner.jpg" alt="" />
    </div>
    <main>
      <!--ITEMSLIT-->
      <ul class="itemList">
      
      </ul>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
