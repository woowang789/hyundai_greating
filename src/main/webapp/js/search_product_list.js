

$(document).ready(() => {

});

function reDrawProduct(res) {
  $('.itemList > li').remove();

  res.forEach((el) => {
	  let baseLi = `
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
   `;
   
      if(el['discountRate'] != 0) baseLi += mid;
      baseLi+= f;
     if(el['grts'] != null){
		baseLi += 
		`<div class="item__value">
            <i class="fa-solid fa-award"></i>
            <span>{grts}</span>
         </div>`;
	  }
	  baseLi += "</div></li>"
     
      
    $('.itemList').append(
      baseLi
        .replaceAll('{prod_id}', el['id'])
        .replace('{prod_thumb}', el['thumbImgUrl'])
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
