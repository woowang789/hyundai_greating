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
