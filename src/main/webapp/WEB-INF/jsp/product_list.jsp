<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/component/style.jsp" %>
    <script src="/js/item_list.js" defer></script>
    <link rel="stylesheet" href="/css/item_list.css" />
    <title>ItemList</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp"></jsp:include>
    
    <div class="cateWithImgArea">
      <h1 class="cateTitle">건강마켓</h1>
      <ul class="cateWithImgList">
        <li>
          <a href=""
            ><span><i></i>전체</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>건강반찬</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>진한 국/찌개</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>자연 담은 면</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>영양 가득 밥/죽</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>샐러드/샌드위치</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>베이커리</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>착한 간식/음료</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>1Table</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>안심키즈</span></a
          >
        </li>
        <li>
          <a href=""
            ><span><i></i>시니어 건장</span></a
          >
        </li>
      </ul>
      <ul class="subcateList">
        <li><a href="">메인요리</a></li>
        <li><a href="">밀키트</a></li>
        <li><a href="">밑반찬</a></li>
        <li><a href="">나물</a></li>
        <li><a href="">소스/양념</a></li>
        <li><a href="">키즈</a></li>
      </ul>
    </div>
    <div class="cate__divider"></div>
    <main>
      <div class="countAndFilter">
        <div class="filter__window">
          <div class="filter__close"><i class="fa-regular fa-x"></i></div>
          <div class="filter__header">
            <h1>상품검색</h1>
            원하는 속성을 골라보세요
          </div>
          <div class="filter__section">
            <p>선호하는 재료가 있으신가요?</p>
            <ul>
              <li>소고기</li>
              <li>돼지고기</li>
              <li>닭고기</li>
              <li>생선</li>
              <li>해초</li>
              <li>해산물</li>
              <li>콩</li>
              <li>두부</li>
              <li>나물</li>
              <li>아보카도</li>
            </ul>
          </div>
          <div class="filter__section">
            <p>빼고싶은 재료가 있으신가요?</p>
            <ul>
              <li>대두</li>
              <li>땅콩</li>
              <li>호두</li>
              <li>잣</li>
              <li>밀</li>
              <li>메밀</li>
              <li>우유</li>
              <li>복숭아</li>
              <li>토마토</li>
              <li>고등어</li>
              <li>오징어</li>
              <li>알류</li>
              <li>새우</li>
              <li>게</li>
              <li>조개류</li>
              <li>소고기</li>
              <li>돼지고기</li>
              <li>닭고기</li>
            </ul>
          </div>
          <div class="filter__section">
            <p>선호하는 보관방법이 있으신가요?</p>
            <ul>
              <li>냉장</li>
              <li>냉동</li>
            </ul>
          </div>
          <div class="filter__btn">
            <div class="filter__reset">
              <i class="fa-solid fa-arrow-rotate-left"></i>초기화
            </div>
            <div class="filter__submit">선택완료</div>
          </div>
        </div>
        <div class="count">전체상품 <span>110</span></div>
        <div class="filter">
          <div class="soldoutRadio">
            <a href=""
              ><i class="fa-regular fa-circle-check"></i> 품절 상품제외</a
            >
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
