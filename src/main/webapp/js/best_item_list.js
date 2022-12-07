$('.bestCategory div').click(function () {
  $('.bestCategory div').removeClass('active');
  $(this).addClass('active');
});

$(document).ready(() => {
  $.ajax({
    type: 'GET',
    url:
      'http://localhost/api/bestProductList?cateId=50',
    success: (res) => reDrawProduct(res['list']),
  });
});

function reDrawProduct(res) {
  $('.itemList > li').remove();
  let p = `
       <li>
          <div class="item" val="{prod_id}">
            <div class="item__rank">
              <div class="rank__underline"></div>
              Best<span>{idx}</span>
            </div>
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
              <div class="price_wrap">
              `;
   let discnt = `
                <span class="discnt_rate">{prod_discnt}%</span>
                <span class="origin_prcie">{prod_originPrice}원</span>
                `;
                
   let price = `
                <h1 class="item__price">{prod_marketPrice}원</h1>
              </div>
            </div>
           `;
   let mid = `
            <div class="item__value">
              <i class="fa-solid fa-award"></i>
              <span>{grts}</span>
            </div>
            `
            
    let f= `
          </div>
        </li>
	`;
  res.forEach((el,idx) => {
	if(el['discountRate'] == 0) discnt ='';
	if(el['grts'] == null) mid = ''; 
	let tmp = p+discnt+price+mid+f;
    $('.itemList').append(
	tmp  
		 .replace('{idx}', idx+1)
      .replaceAll('{prod_id}', el['id'])
        .replace('{prod_thumb}', el['prodImgUrl'])
        .replace('{prod_storage}', el['storage'])
        .replace('{prod_subname}', el['subName'])
        .replace('{prod_name}', el['name'])
        .replace('{prod_marketPrice}', el['marketPrice'].toLocaleString())
        .replace('{prod_discnt}', el['discountRate'])
        .replace('{prod_originPrice}',el['originPrice'].toLocaleString())
        .replace('{grts}',el['grts'])
    );
  });
}
$('.bestCategory div').click(function(){
	let val = $(this).attr('val');
	$.ajax({
    type: 'GET',
    url:
      'http://localhost/api/bestProductList?cateId='+val,
    success: (res) => reDrawProduct(res['list']),
  });
	
})
