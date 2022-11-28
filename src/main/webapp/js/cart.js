$('.list__item .qty__plus').click(function () {
  let id = $(this).parent().parent().attr('val');

  let count = $(this).siblings('.qty').text();
  let body = $(this).parent().siblings('.body__resultPrice').text();
  let perPrice =
    wonToInt($(this).parent().siblings('.body__resultPrice').text()) /
    parseInt(count);
  $(this)
    .siblings('.qty')
    .text(parseInt(count) + 1);
  $(this)
    .parent()
    .siblings('.body__resultPrice')
    .text((perPrice * (parseInt(count) + 1)).toLocaleString() + '원');

  calTotal();

  $.ajax({
    type: 'POST',
    url: 'http://localhost/api/updateCart',
    data: JSON.stringify({ optnId: id, stock: 1, userId:userId }),
    contentType: "application/json; charset=utf-8",
  });
});
$('.list__item .qty__minus').click(function () {
  let count = $(this).siblings('.qty').text();
  let id = $(this).parent().parent().attr('val');
  if (count > 1) {
    let perPrice =
      wonToInt($(this).parent().siblings('.body__resultPrice').text()) /
      parseInt(count);
    $(this)
      .siblings('.qty')
      .text(parseInt(count) - 1);
    $(this)
      .parent()
      .siblings('.body__resultPrice')
      .text((perPrice * (parseInt(count) - 1)).toLocaleString() + '원');

    calTotal();
    $.ajax({
      type: 'POST',
      url: 'http://localhost/api/updateCart',
      data: JSON.stringify({ optnId: id, stock:  -1, userId:userId }),
      contentType: "application/json; charset=utf-8",
    });
  }
});
$('i.fa-xmark').click(function(){
	let id = $(this).parent().attr('val');
	let prod = $(this).parent();
	prod.remove();
	calTotal();
	$.ajax({
      type: 'POST',
      url: 'http://localhost/api/removeCart',
      data: JSON.stringify({ optnId: id, userId:userId }),
      contentType: "application/json; charset=utf-8",
    });
	
})
function wonToInt(s) {
  return parseInt(s.substr(0, s.length - 1).replaceAll(',', ''));
}
function intToWon(s) {
  return s.toLocaleString() + '원';
}
function calTotal() {
  let total_origin = 0;
  let total_market = 0;
  $('.list__item').each(function () {
    let origin = wonToInt($(this).children('.body__price').text());
    let market = wonToInt($(this).children('.body__resultPrice').text());
    let count = parseInt($(this).children().children('.qty').text());
    total_origin += parseInt(origin * count);
    total_market += parseInt(market);
  });
  $('.total_origin').text(intToWon(total_origin));
  $('.total_market').text(intToWon(total_market));
  $('.total_margin').text(intToWon(total_origin - total_market));

  let more = 30000 - total_market;
  if (more > 0) {
    $('.more_price').text(more.toLocaleString() + '원');
    $('.more_price').siblings('span').text('추가하면');
  } else {
    $('.more_price').text(total_market.toLocaleString() + '원');
    $('.more_price').siblings('span').text('으로');
  }
  let radio = (total_market * 310) / 30000;
  if (radio > 310) {
    $('.range').width('100%');
  } else {
    $('.range').width(radio + 'px');
  }
}
$('.more__btn').click(function () {
  $(location).attr('href', '/v1/');
});
$('.bottom__btn').click(function () {
  $(location).attr('href', '/v1/order?isDir=N'); // 장바구니에서 꺼내옴
});
$(document).ready(() => {
  calTotal();
});
