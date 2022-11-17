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
    <link rel="stylesheet" href="/css/item_detail.css" />
    <title>ItemDetail</title>
  </head>
  <body>
    <!-- HEADER Fragnent -->
    <%@include file="/WEB-INF/component/header.jsp" %>
    
    <div class="itemImgAndInfo">
      <div class="itemImgArea">
        <div class="itemImg">
          <img src="/img/item_detail/item_img.jpeg" alt="" />
        </div>
      </div>
      <div class="itemInfoArea">
        <div class="info__title">
          <div class="subtitleAndLike">
            <p class="subtitle">서산 화식한우로 끓인</p>
            <i class="fa-regular fa-heart"></i>
          </div>

          <h1 class="title">[1Table] 화식한우 사골곰국</h1>
          <p class="origin">원산지 : 상세페이지 참고</p>
        </div>
        <div class="info__price">
          <span class="discountRate">15%</span>
          <span class="discountPrice">3,750원</span>
          <span class="originPrice">4,200원</span>
        </div>
        <div class="info__delivery info__flex">
          <div class="head">배송정보</div>
          <div class="tail">
            <span class="delivery__badge">일반배송</span>5pm 이전 결제시
            <span class="arrival__date">11월 14일(월) 도착 가능</span>
          </div>
        </div>
        <div class="info__deliveryPrice info__flex">
          <div class="head">배송비</div>
          <div class="tail"><span>3,000원</span> / 30,000원 이상 무료 배송</div>
        </div>
        <div class="info__seller info__flex">
          <div class="head">판매자</div>
          <div class="tail">
            <div class="seller__name">그리팅</div>
            <div class="seller__tel">
              tel. <span class="tel">1800-0700</span>
            </div>
          </div>
        </div>
        <ul class="info__btns">
          <li class="btn__addShoppingcart"><a href="">장바구니 담기</a></li>
          <li class="btn__order"><a href="">구매하기</a></li>
        </ul>
      </div>
    </div>
    <!-- InfoTabs -->
    <ul class="infoTabs">
      <li class="infoTab">상품정보</li>
      <li class="infoTab">상품후기</li>
      <li class="infoTab">상품문의</li>
      <li class="infoTab">교환반품</li>
    </ul>

    <!-- ItemInfo -->
    <div>
      <div class="item__info">
        <div class="info__value">
          <div class="value__title">
            <i class="fa-solid fa-award"></i>greating's value
          </div>
          <div class="value__itemName">[1Table] 화식한우 사골곰국</div>
          <ul class="value__icons">
            <li>
              <div class="value__icon">
                <img src="/img/item_detail/value_ingredient.png" alt="" />
              </div>
              <span>프리미엄 식재</span>
            </li>
          </ul>
        </div>
        <div class="info__simple">
          <ul class="simple__icons">
            <li>
              <div class="simple__icon">
                <img src="/img/item_detail/sime_icon.png" alt="" />
              </div>
              <span>소</span>
            </li>
          </ul>
          <div class="simple__capa simple__flex">
            <div class="head">용량</div>
            <div class="tail">400ml</div>
          </div>
          <div class="simple__kcal simple__flex">
            <div class="head">칼로리</div>
            <div class="tail">955kcal</div>
          </div>
          <div class="simple__origin simple__flex">
            <div class="head">원산지</div>
            <div class="tail">상세페이지 참고</div>
          </div>
        </div>
        <div class="info__intro">
          현대식품관의 건강한 식재료와 유명 맛집의 레시피가 더해진 프리미엄
          가정식 브랜드, 원테이블(1 Table)의 사골곰국을 소개해요. <br />
          <br />
          소의 뼈를 고아 만드는 곰탕은 그 어떤 요리보다 신선한 재료를 사용하는
          것이 중요한데요. 출하 6개월 전 부터 보리, 볏짚 등 곡물을 끓여 만든
          화식 사료와 삶지 않은 볏짚 및 목초, 무항생제 사료를 함께 먹고 자라
          육질이 부드럽고 고소한 맛이 특히 깊은 화식한우로 푹 끓인 곰국이에요.
          안심하고 먹을 수 있는 원테이블 사골곰국으로 가족의 한 끼 식사를 준비해
          보세요. <br />
        </div>
        <div class="item__img">
          <img src="/img/item_detail/item_detail_img1.jpeg" alt="" />
        </div>

        <div class="item__area">
          <div class="info__header">
            <h1><span>greating's packaging</span></h1>
            <p>이렇게 포장됩니다.</p>
          </div>
          <div class="packageImg">
            <img src="/img/item_detail/item_package.jpeg" alt="" />
          </div>
        </div>

        <div class="item__area">
          <div class="info__header">
            <h1><span>ingredients</span></h1>
            <p>모든 재료를 확인하세요</p>
          </div>

          <div class="IngredientsImg">
            <img src="/img/item_detail/item_ingredients.jpeg" alt="" />
          </div>
        </div>
      </div>
    </div>

    <!-- Footer Fragnent -->
    <%@include file="/WEB-INF/component/footer.jsp" %>
  </body>
</html>
