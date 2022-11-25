/* 필터 버튼 눌렀을 떄 */
$('.filterBtn').click(() => {
  $('.filter__window').css('display', 'block');
});
$('.filter__close').click(() => {
  $('.filter__window').css('display', 'none');
});

/* 카테고리 뒷배경 */
$('.cateWithImgArea .cateWithImgList li a i').each((idx, item) => {
  if (idx == 1) return;
  $(item).css('background-position-y', -440 - 40 * (idx - 1) + 'px');
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


class Cate {
  constructor(name, id, sub) {
    this.name = name;
    this.id = id;
    this.sub = sub;
  }
}
const cate0 = new Cate('전체', 55, []);
const cate1 = new Cate('메인요리', 656, [
  new Cate('밀키드', 1878),
  new Cate('밑반찬', 657),
  new Cate('나물', 1519),
  new Cate('소스/양념', 2578),
  new Cate('키즈', 1522),
]);
const cate2 = new Cate('진한 국/찌개', 1058, [
  new Cate('국', 1079),
  new Cate('찌개', 1078),
]);
const cate3 = new Cate('자연 담은 면', 3058, [
  new Cate('국수', 3078),
  new Cate('파스타', 3079),
]);
const cate4 = new Cate('영양가득 밥/죽', 719, [
  new Cate('밥', 729),
  new Cate('죽', 728),
]);
const cate5 = new Cate('샐러드/샌드위치', 718, [
  new Cate('샐러드', 2638),
  new Cate('샌드위치', 2639),
  new Cate('브런치박스', 2678),
]);
const cate6 = new Cate('베이커리', 1198, [
  new Cate('빵', 1218),
  new Cate('버터/치즈', 1219),
  new Cate('잼/시럽', 1679),
]);
const cate7 = new Cate('착한 간식/음료', 1699, [
  new Cate('식사대용', 1738),
  new Cate('영양간식', 1740),
  new Cate('커피/차/음료', 2098),
  new Cate('캔디/쿠키', 1739),
]);
const cate8 = new Cate('1Table', 1139, []);
const cate9 = new Cate('안심 키즈', 2598, [
  new Cate('간편식/국/반찬/소스', 2698),
  new Cate('간식/건강식품/음료', 2599),
]);
const cate10 = new Cate('시니어 건강', 818, [
  new Cate('고기', 821),
  new Cate('생선', 1538),
  new Cate('소프트프로틴', 4738),
]);
const cate11 = new Cate('비건/순식물성', 2018, [
  new Cate('비건', 2019),
  new Cate('순식물성', 2038),
]);

const cateList = [
  cate0,
  cate1,
  cate2,
  cate3,
  cate4,
  cate5,
  cate6,
  cate7,
  cate8,
  cate9,
  cate10,
  cate11,
];

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

  $('.cateWithImgList li a').click(function (e) {
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
    let target = cateList[idx];

    $('.subcateList li').remove();
    let base = '<li><a href="" val={subVal}>{subName}</a></li>';
    for (i in target.sub) {
      let sub = target.sub[i];
      $('.subcateList').append(
        base.replace('{subVal}', sub.id).replace('{subName}', sub.name)
      );
    }
    $('.subcateList li a').click((e) => {
      $('.subcateList li a').removeClass('active');
      $(e.target).addClass('active');
      e.preventDefault();
      $.ajax({
        type: 'GET',
        url:
          'http://localhost/api/productList?' + 'cateId=' + $(this).attr('val'),
        success: (res) => reDrawProduct(res['list']),
      });
    });
  });
}
function clickSubCate() {
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
  let hash = $(location).attr('hash').slice(1);
  for (let i in cateList) {
    let c = cateList[i];
    if (c.id == hash) {
      console.log(i);
      $(`.cateWithImgList li:nth-child(${i + 1})`).addClass('active');
      $.ajax({
        type: 'GET',
        url: 'http://localhost/api/productList?' + 'cateId=' + c.id,
        success: (res) => reDrawProduct(res['list']),
      });
      break;
    }
  }
});

function reDrawProduct(res) {
  // $('.itemList > li').remove();
  let baseLi = `
  <li>
    <div class="item">
      <div class="item__img">
        <a href="/v1/prodDetail?prodId={prodId}"
          ><img src="{prod_thumb}" alt=""
        /></a>
        <div class="img__badge">{prod_storage}</div>
      </div>
      <div class="item__title">
        <p>{prod_subname}</p>
        <h1>{prod_name}</h1>
      </div>
      <div class="item__bottom">
        <h1 class="item__price">{prod_marketPrice}</h1>
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
        .replace('{prod_id}', el['id'])
        .replace('{prod_thumb}', el['thumbImgUrl'])
        .replace('{prod_storage}', el['storage'])
        .replace('{prod_subname}', el['subName'])
        .replace('{prod_name}', el['name'])
        .replace('{prod_marketPrice}', el['marketPrice'])
    );
  });
}
