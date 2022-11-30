/* 필터 버튼 눌렀을 떄 */
$('.filterBtn').click(() => {
  $('.filter__window').css('display', 'block');
});
$('.filter__close').click(() => {
  $('.filter__window').css('display', 'none');
});

/* 필터 윈도우 */
$('.filter__section ul li').each((idx, item) => {
  $(item).click(() => {
    $(item).toggleClass('active');
  });
});
$('.filter__reset').click(() => {
  $('.filter__section ul li').each((idx, item) => {
    $(item).removeClass('active');
  });
});

function drawCate() {
  let base = `
  <li>
  <a idx={cateIdx} val="{cateVal}" href=""
    ><span><i></i>{cateName}</span></a>
  </li>
  `;
  $('.cateWithImgList li').remove();
  for (let i in cateList) {
    $('.cateWithImgList').append(
      base
        .replace('{cateIdx}', i)
        .replace('{cateVal}', cateList[i].id)
        .replace('{cateName}', cateList[i].name)
    );
  }
  $('.cateWithImgArea .cateWithImgList li a i').each((idx, item) => {
    if (idx == 1) return;
    $(item).css('background-position-y', -440 - 40 * (idx - 1) + 'px');
  });

  $('.cateWithImgList li a').click(clickCate);
}
function clickCate(e) {
  $.ajax({
    type: 'GET',
    url:
      'http://localhost/api/productList?' + 'cateId=' + $(this).attr('val'),
    success: (res) => reDrawProduct(res['list']),
  });
  $('.cateWithImgList li').removeClass('active');
  $(this).parent().addClass('active');
  e.preventDefault();
  let idx = $(this).attr('idx');
  console.log(idx);
  let target = cateList[idx];

  $('.subcateList li').remove();
  let base = '<li><a href="" val={subVal}>{subName}</a></li>';
  for (i in target.sub) {
    let sub = target.sub[i];
    $('.subcateList').append(
      base.replace('{subVal}', sub.id).replace('{subName}', sub.name)
    );
  }
  $('.subcateList li a').click(clickSubCate);
}
function clickSubCate(e) {
  $('.subcateList li a').removeClass('active');
  $(this).addClass('active');
  e.preventDefault();
  $.ajax({
    type: 'GET',
    url: 'http://localhost/api/productList?' + 'cateId=' + $(this).attr('val'),
    success: (res) => reDrawProduct(res['list']),
  });
}

$(document).ready(() => {
  drawCate();
  let hash = $(location).attr('hash').slice(8);
  console.log(hash);
  if (typeof hash != undefined) {
    for (let i in cateList) {
      if (cateList[i].id == hash) {
        $(`.cateWithImgList li a[val=${hash}]`).parent().addClass('active');
        $('.subcateList li').remove();
        let base = '<li><a href="" val={subVal}>{subName}</a></li>';
        for (j in cateList[i].sub) {
          let sub = cateList[i].sub[j];
          $('.subcateList').append(
            base.replace('{subVal}', sub.id).replace('{subName}', sub.name)
          );
        }
        break;
      }
    }
  }
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
