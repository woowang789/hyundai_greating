$('.check__btn i').each((idx, item) => {
  $(item).click(() => {
    $(item).toggleClass('active');
  });
});

$('.select__all').click(() => {
  if ($('.select__all i').hasClass('active')) {
    $('.check__btn i').each((idx, item) => {
      $(item).removeClass('active');
    });
  } else {
    $('.check__btn i').each((idx, item) => {
      $(item).addClass('active');
    });
  }
  $('.select__all i').toggleClass('active');
});

$('.delete__selected').click(function () {
  $('.itemList .item .check__btn i.active').each(function () {
    let prodId = $(this).parent().parent('.item').attr('val');
    $(this).parent().parent().parent().remove();
	deleteCookie(prodId);
  });
});
function deleteCookie(key){
	let cookie = $.cookie('viewProds');
	if(cookie == undefined) return;
	let array = cookie.split('/');
	
	const idx = array.indexOf(key);
	if(idx != -1) array.splice(idx,1);
	$.cookie('viewProds',array.join('\/'));
	
}