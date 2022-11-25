$('.header__bottom .header__category .hover__menu > ul > li i').each(
  (idx, item) => {
    $(item).css('background-position-y', -275 - 25 * idx + 'px');
  }
);

/*
$(document).ready(() => {
  $.ajax({
    type: 'GET',
    url: 'http://localhost/api/productList',
    success: (res) => reDrawProduct(res['list']),
  });
  console.log('ttt');
});
*/

function reDrawProduct(res) {
  $('.itemList > li').remove();
  let baseLi = `
  <li>
    <div class="item">
      <div class="item__img">
        <a href=""
          ><img src="{prod_thumb}" alt=""
        /></a>
        <div class="img__badge">{prod_storage}</div>
      </div>
      <div class="item__title">
        <p>{prod_subname}</p>
        <h1>{prod_name}</h1>
      </div>
      <div class="item__bottom">
        <h1 class="item__price">{prod_marketPrice}원</h1>
        <div class="item__shoppingcart">
          <i class="fa-solid fa-cart-shopping"></i>
        </div>
      </div>
    </div>
  </li>
`;
  res.forEach((el) => {
    $('.itemList').append(
      baseLi
        .replace('{prod_thumb}', el['thumbImgUrl'])
        .replace('{prod_storage}', el['storage'])
        .replace('{prod_subname}', el['subName'])
        .replace('{prod_name}', el['name'])
        .replace('{prod_marketPrice}', el['marketPrice'])
    );
  });
}