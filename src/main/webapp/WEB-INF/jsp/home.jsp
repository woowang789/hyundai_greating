<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/home.css" />
    <link rel="stylesheet" href="/css/loading.css"> 
    <script src="/js/home.js" defer></script>
    <%@include file="/WEB-INF/component/style.jsp" %>
    <style type="text/css">
    #loading {
       height: 150vw;
    }
    #loading-image{
        margin-top: 200pt;
        height: 100pt;
        width: 100pt;
    }
    </style>
    <title>Home</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <%@include file="/WEB-INF/component/header.jsp" %>
    
    
    <div class="banner">
      <img src="/img/main/main_banner.jpeg" alt="" />
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
        <li>
          <div class="item">
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
          </div>
        </li>
        <li>
          <div class="item">
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
          </div>
        </li>
        <li>
          <div class="item">
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
          </div>
        </li>
        <li>
          <div class="item">
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
          </div>
        </li>
        <li>
          <div class="item">
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
          </div>
        </li>
      </ul>
      <div class="moreBtnArea">
        <a href="/v1/itemList"><div class="moreBtn">착한 간식/음료 전체보기 ></div></a>
      </div>
    </main>
<!--         <div id="loading">
        <img src="../img/loading.gif"/>
         </div>
    <script>
    window.onload = function () {
 	   $("#loading").hide();
    	}
    </script>
    <script type="text/javascript">
    $(document).ready(function() {
    	  $('
    	Loading...
    	')
    	    .insertBefore('#content')
    	    .ajaxStart(function() {
    	     //호출이시작되면
    	      $(this).show();
    	      //보여준다
    	    }).ajaxStop(function() {
    	    //호출이 끝나면
    	      $(this).hide();
    	      //감춘다.
    	    });
    	});</script>

<script>
$(document).ready(function() {
	  $('
	now loading

	')
	    .insertBefore('#content)
	});</script> -->

     <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>