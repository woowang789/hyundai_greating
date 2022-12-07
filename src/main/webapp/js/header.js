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

function headerCate() {
  let s = '';
  let base_c = '<li>\n<a href="{url}"><i></i>{name}</a>\n';
  let base_cc = '<li><a href="{url}">{name}</a></li>';
  for (i in cateList) {
    if (i == 0) continue;
    let c = cateList[i];
    s +=
      base_c
        .replace('{url}', `/v1/productList#cateId=${c.id}`)
        .replace('{name}', c.name) + '\n<ul>\n';
    for (j in c.sub) {
      let cc = c.sub[j];
      s +=
        base_cc
          .replace('{url}', `/v1/productList#cateId=${cc.id}`)
          .replace('{name}', cc.name) + '\n';
    }
    s += '</ul>\n</li>\n';
  }
  $('.hover__menu').children().append(s);

  $('.header__bottom .header__category .hover__menu > ul > li i').each(
    (idx, item) => {
      $(item).css('background-position-y', -275 - 25 * idx + 'px');
    }
  );
}

$(document).ready(()=>{
	headerCate();
})

