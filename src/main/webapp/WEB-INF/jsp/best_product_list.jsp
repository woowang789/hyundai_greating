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
    <title>BestItemList</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <jsp:include page="../component/header.jsp">
    </jsp:include>
    
    <!--Best Category-->
    <ul class="bestCategory">
      <li><a href="" class="active">전체</a></li>
      <li><a href="">건강반찬</a></li>
      <li><a href="">진한 국/찌개</a></li>
      <li><a href="">자연 담은 면</a></li>
      <li><a href="">영양가득 밥/죽</a></li>
      <li><a href="">샐러드/샌드위치</a></li>
      <li><a href="">베이커리</a></li>
      <li><a href="">착한 간식/음료</a></li>
      <li><a href="">1Table</a></li>
      <li><a href="">안심 키즈</a></li>
      <li><a href="">시니어 건강</a></li>
      <li><a href="">비건/순식물성</a></li>
      <li><a href="">라이프</a></li>
    </ul>
    <!-- BestBanner -->
    <div class="bestBanner">
      <img src="../img/best_item_list/best_item_list_banner.jpeg" alt="" />
    </div>
    <main>
      <!--ITEMSLIT-->
      <ul class="itemList">
        <li>
          <div class="item">
            <div class="item__rank">
              <div class="rank__underline"></div>
              Best<span>01</span>
            </div>
            <div class="item__img">
              <a href=""
                ><img src="../img//main/main_item_img.jpeg" alt=""
              /></a>
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
            <div class="item__rank">
              <div class="rank__underline"></div>
              Best<span>01</span>
            </div>
            <div class="item__img">
              <a href=""
                ><img src="../img//main/main_item_img.jpeg" alt=""
              /></a>
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
            <div class="item__rank">
              <div class="rank__underline"></div>
              Best<span>01</span>
            </div>
            <div class="item__img">
              <a href=""
                ><img src="../img//main/main_item_img.jpeg" alt=""
              /></a>
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
            <div class="item__rank">
              <div class="rank__underline"></div>
              Best<span>01</span>
            </div>
            <div class="item__img">
              <a href=""
                ><img src="../img//main/main_item_img.jpeg" alt=""
              /></a>
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
      </ul>
    </main>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
