$('.option__reset').click(() => {
  $('.tail select option:eq(0)').prop('selected', true);
  $('.tail input').val('');
});

/* 
$(document).ready(() => {
  $.ajax({
    type: 'GET',
    url: 'http://localhost/api/orderList',
    success: (res) => orderList(res['list']),
  });
});
$('.search__btn').click(function () {
  $.ajax({
    type: 'GET',
    url: 'http://localhost/api/orderList?status=&name=',
    success: (res) => orderList(res['list']),
  });
});
*/

function orderList(res) {}


$('.input__btn.go_detail').click(function(){
	
})

$('.item__img').click(function(){
	console.log('t')
	let prodId = $(this).parent().parent().attr("prodId")
	$(location).attr('href',"/v1/productDetail?prodId="+prodId);
})


///api/insertComment
$('.input__btn.open_form').click(function(){
	let optnName = $(this).siblings('.info').children('.item__info').children('.desc').text();
	$('.reivew__optn span').text(optnName);
	$('.review__input').css('display','block')
	$('.modal__background').css('display','block')	
	
	let prodId = $(this).parent().attr('prodId');
	let optnId = $(this).parent().attr('optnId');
	let orderDate = $(this).parent().parent()
		.siblings('.order__head').children().children('span').text();
	
	$('.review__input').attr('prodId',prodId);
	$('.review__input').attr('optnId',optnId);
	$('.review__input').attr('orderDate',orderDate);
	
	let title = $('.dialog__content input').val()
	let content = $('.dialog__content textarea').val();
	
  
})
$('.review__cancel').click(function(){
	$('.review__input').css('display','none')
	$('.modal__background').css('display','none')	
})

$('.input__btn.has_review').click(function(){
	console.log('ttt');
	let prodId = $(this).parent().attr('prodId');
	$(location).attr('href','/v1/productDetail?prodId='+prodId);
})

$('.review__com').click(function(){
	let title = $('.dialog__content input').val()
	let text = $('.dialog__content textarea').val();
	if(title == '' || text=='') return;
	
	$('.review__input').css('display','none')
	$('.modal__background').css('display','none')	
	
	$('.dialog__content input').val('')
	$('.dialog__content textarea').val('')

	let prodId = $(this).parent().parent().attr('prodId');
	let optnId = $(this).parent().parent().attr('optnId');
	let orderDateLong = $(this).parent().parent().attr('orderDate');
	
	console.log(title, text, prodId,optnId, orderDateLong, userId);
	
	
	$.ajax({
    type: 'POST',
    url: 'http://localhost/api/insertComment',
    data: JSON.stringify({ "prodId":prodId, "optnId":optnId, "userId":userId,
    					"orderDateLong":orderDateLong, "title":title, "text":text  }),
    dataType: 'json',
    contentType: "application/json; charset=utf-8",
  /* 
    success: 
    function(){
		let btn = $(`.item[prodId=${prodId}][optnId=${optnId}] div.input__btn`);
		btn.removeClass('open_form');
		btn.addClass('has_review');
		btn.text('리뷰확인');
}
*/
	});
})