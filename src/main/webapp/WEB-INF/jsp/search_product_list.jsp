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
    <script src="/js/search_product_list.js" defer></script>
    <link rel="stylesheet" href="/css/item_list.css" />
    <title>SearchProductList</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <main>
      <div class="countAndFilter">
        <div class="count">전체상품 <span>110</span></div>
        <div class="filter">
          <div class="soldoutRadio">
            <a href=""
              ><i class="fa-regular fa-circle-check"></i> 품절 상품제외</a>
          </div>
          <div class="sortDropdown">
            <select name="" id="">
              <option value="">최신순</option>
              <option value="">인기순</option>
              <option value="">고객후기순</option>
              <option value="">높은가격순</option>
              <option value="">낮은가격순</option>
            </select>
          </div>
          <div class="filterBtn"><i class="fa-solid fa-filter"></i> 필터</div>
        </div>
      </div>
      <!--ITEMSLIT-->
      <ul class="itemList">
      
      <c:forEach var="el" items="${list}">
      	<li>
          <div class="item">
            <div class="item__img">
              <a href="">
                <img src="${el.thumbImgUrl }" alt="" />
              </a>
              <div class="img__badge">${el.storage}</div>
            </div>
            <div class="item__title">
              <p>${el.subName }</p>
              <h1>${el.name }</h1>
            </div>
            <div class="item__bottom">
             <div class="price_wrap">
             <c:if test="${el.discountRate != 0 }">
             	<span class="discnt_rate">${el.discountRate}%</span>
               <span class="origin_prcie">${el.originPrice}원</span>
             </c:if>
               <h1 class="item__price">${el.marketPrice}원</h1>
              </div>
            </div>
            <c:if test="${not empty el.grts }">
              <div class="item__value">
                <i class="fa-solid fa-award"></i>
                <span>프리미엄 식재</span>
            </div>
            </c:if>
          </div>
        </li>
      </c:forEach>

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
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
