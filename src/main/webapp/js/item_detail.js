$('.option__select .select__header').click(modelToggle);
$('.info__btns .btn__addShoppingcart').click(modelToggle);
$('.info__btns .btn__order').click(modelToggle);
function modelToggle() {
  if ($('.select__header').hasClass('active')) {
    $('.select__body__wrap').css('display', 'none');
    $('.modal__background').css('display', 'none');
  } else {
    $('.select__body__wrap').css('display', 'block');
    $('.modal__background').css('display', 'block');
  }
  $('.option__select .select__header').toggleClass('active');
}

$('i.fa-heart').click(function(){
	let prodId = (new URLSearchParams(window.location.search)).get('prodId');
	if(userId != null && userId != undefined && userId!=''){
		console.log(userId+" = 유저아이디")
		$.ajax({
      type: 'POST',
      url: 'http://localhost/api/toggleInterest',
      data: JSON.stringify({ prodId: prodId, userId:userId }),
      contentType: "application/json; charset=utf-8",
      success: function(res){
			$('i.fa-heart').toggleClass('active');
		}
    });
	}else{
		$(location).attr('href','/v1/signin?redirect='+$(location).attr('pathname')+$(location).attr('search'))
	}
})

$('.qty__plus').click(function(){
	let marketPrice = wonToInt($(this).parent()
			.siblings('.item__price')
			.text());
	let count = parseInt($(this).siblings('.qty').text());
	$(this).siblings('.qty').text(count+1);
	calTotal()
})
$('.qty__minus').click(function(){
	let marketPrice = wonToInt($(this).parent()
			.siblings('.item__price')
			.text());
	let count = parseInt($(this).siblings('.qty').text());
	if(count > 0){
		$(this).siblings('.qty').text(count-1);
		calTotal()
	}
})


function wonToInt(s) {
  return parseInt(s.substr(0, s.length - 1).replaceAll(',', ''));
}
function intToWon(s) {
  return s.toLocaleString() + '원';
}
function calTotal() {
  let total_price = 0;
  $('.item__list .item').each(function () {
    let price = wonToInt($(this).children('.item__price').text());
    
    let count = parseInt($(this).children('.item__qty').children('.qty').text());
    total_price += parseInt(price * count);
  });
  $('.item__totlaPrice span').text(intToWon(total_price));

}