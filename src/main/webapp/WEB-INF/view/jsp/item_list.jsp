<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/f5ed871e11.js"
      crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/item_list.css" />
    <title>ItemList</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <%@include file="/WEB-INF/component/header.jsp" %>
    
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
        <li><a href=""></a>밀키트</li>
        <li><a href=""></a>밑반찬</li>
        <li><a href=""></a>나물</li>
        <li><a href=""></a>소스/양념</li>
        <li><a href=""></a>키즈</li>
      </ul>
    </div>
    <div class="cate__divider"></div>
    <main>
      <div class="countAndFilter">
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
        <li>
          <div class="item">
            <div class="item__img">
              <img src="/img//main/main_item_img.jpeg" alt="" />
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
          </div>
        </li>
        <li>
          <div class="item">
            <div class="item__img">
              <img src="/img//main/main_item_img.jpeg" alt="" />
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
          </div>
        </li>
        <li>
          <div class="item">
            <div class="item__img">
              <img src="/img//main/main_item_img.jpeg" alt="" />
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
          </div>
        </li>
        <li>
          <div class="item">
            <div class="item__img">
              <img src="/img//main/main_item_img.jpeg" alt="" />
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
          </div>
        </li>
        <li>
          <div class="item">
            <div class="item__img">
              <img src="/img//main/main_item_img.jpeg" alt="" />
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
          </div>
        </li>
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
