<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/component/style.jsp" %>
    <link rel="stylesheet" href="/css/discnt_product_list.css" />
     <script src="/js/discnt_product_list.js" defer></script>
    <title>BestItemList</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <!--Best Category-->
    <ul class="bestCategory">
      <li><div  class="active" val="50">전체</div></li>
      <li><div val='4'>80% 할인</div></li>
      <li><div val='5'>70% 할인</div></li>
      <li><div val='6'>60% 할인</div></li>
    </ul>
    <!-- BestBanner -->
    <div class="bestBanner">
      <img src="../img/best_item_list/best_item_list_banner.jpeg" alt="" />
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
