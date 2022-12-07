$(document).ready(() => {
  let idx = getRandomIdx();
  let target = $(`.categoryList li:nth-child(${idx}) a`);
  target.addClass('active');
  editMoreBtn(target.text(), target.attr('val'));
  
  $.ajax({
    type: 'GET',
    url:
      'http://localhost/api/productList?cateId=' +
      $(`.categoryList li:nth-child(${idx}) a`).attr('val'),
    success: (res) => reDrawProduct(res['list']),
  });
  
});


function reDrawProduct(res) {
  $('.itemList > li').remove();
  let p = `
  <li>
    <div class="item" val="{prod_id}">
      <div class="item__img">
        <a href="/v1/productDetail?prodId={prod_id}"
          ><img src="{prod_thumb}" alt=""
        /></a>
        <div class="img__badge">{prod_storage}</div>
      </div>
      <div class="item__title">
        <p>{prod_subname}</p>
        <h1>{prod_name}</h1>
      </div>
        <div class="item__bottom">
           <div class='price_wrap'>
    `;
    let mid = `<span class='discnt_rate'>{prod_discnt}%</span>
    			<span class='origin_prcie'>{prod_originPrice}원</span>`

    let f=`
	             <h1 class="item__price">{prod_marketPrice}원</h1>      
	         </div>
	      </div>
	    </div>
	  </li>
	`;
  res.forEach((el) => {
	let tmp = '';
	if(el['discountRate'] == 0) tmp = p+f;
	else  tmp = p+mid+f;
    $('.itemList').append(
	tmp  
      .replaceAll('{prod_id}', el['id'])
        .replace('{prod_thumb}', el['prodImgUrl'])
        .replace('{prod_storage}', el['storage'])
        .replace('{prod_subname}', el['subName'])
        .replace('{prod_name}', el['name'])
        .replace('{prod_marketPrice}', el['marketPrice'].toLocaleString())
        .replace('{prod_discnt}', el['discountRate'])
        .replace('{prod_originPrice}',el['originPrice'].toLocaleString())
    );
  });
 
}

$('.categoryList a').click(function (e) {
  editMoreBtn($(this).text(), $(this).attr('val'));
  $('.categoryList a.active').removeClass('active');
  $(this).addClass('active');
  $.ajax({
    type: 'GET',
    url: 'http://localhost/api/productList?' + 'cateId=' + $(this).attr('val'),
    success: (res) => reDrawProduct(res['list']),
  });

  e.preventDefault();
  
  $('.item__shoppingcart').click(function () {
  $.ajax({
    type: 'POST',
    url: 'http://localhost/api/addCart',
    data: JSON.stringify({ prodId: $('this').attr('val') }),
    dataType: 'json',
  });
});
});

function getRandomIdx() {
  let len = $('.categoryList a').length;
  return Math.floor(Math.random() * len) + 1;
}
function editMoreBtn(cateName, cateId) {
  $('.moreBtn').text(cateName + ' 전체보기 >');
  $('.moreBtnArea a').attr('href', `/v1/productList#cateId=` + cateId);
}

$('.item__shoppingcart').click(function () {
  let id = $(this).parent().parent().attr('val');
  console.log(id);
  $.ajax({
    type: 'POST',
    url: 'http://localhost/api/addCart',
    data: JSON.stringify({ prodId: id }),
    dataType: 'json',
  });
});

