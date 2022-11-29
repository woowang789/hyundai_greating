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

$('i.fa-heart').click(function() {
	let prodId = (new URLSearchParams(window.location.search)).get('prodId');
	if (userId != null && userId != undefined && userId != '') {
		console.log(userId + " = 유저아이디")
		$.ajax({
			type: 'POST',
			url: 'http://localhost/api/toggleInterest',
			data: JSON.stringify({ prodId: prodId, userId: userId }),
			contentType: "application/json; charset=utf-8",
			success: function(res) {
				$('i.fa-heart').toggleClass('active');
			}
		});
	} else {
		$(location).attr('href', '/v1/signin?redirect=' + $(location).attr('pathname') + $(location).attr('search'))
	}
})

$('.qty__plus').click(function() {
	let count = parseInt($(this).siblings('.qty').text());
	$(this).siblings('.qty').text(count + 1);
	calTotal()
})
$('.qty__minus').click(function() {
	let count = parseInt($(this).siblings('.qty').text());
	if (count > 0) {
		$(this).siblings('.qty').text(count - 1);
		calTotal()
	}
})

$('.item__shoppingcart').click(function() {
	let total = wonToInt($('.item__totlaPrice span').text());
	if (total > 0) {
		$('.dialog').css('display', 'block');
		$('.item').each(function() {
			let count = parseInt($(this).children('.item__qty')
				.children('.qty').text());
			let id = $(this).attr('val');
			console.log(count);
			if (count > 0) {
				$.ajax({
					type: 'POST',
					url: 'http://localhost/api/updateCart',
					data: JSON.stringify({ optnId: id, stock: count, userId: userId }),
					contentType: "application/json; charset=utf-8",
				});
			}
		})
	}
})
$('.item__order').click(function(){
	let total = wonToInt($('.item__totlaPrice span').text());
	let prods = [];
	if(total > 0){
		$('.item').each(function() {
			let count = parseInt($(this).children('.item__qty')
				.children('.qty').text());
			let id = $(this).attr('val');
			if (count > 0) {
				let prod = {"optnId":id, "qty":count};
				prods.push(prod);
			}
		})
		let param = {
		"prods" : prods
		};
		$(location).attr('href', '/v1/order?isDir=N&prods='+encodeURIComponent(JSON.stringify(param)));
	}
})
$('.to__home').click(function(){
	$(location).attr('href','/v1/');
})
$('.to__cart').click(function(){
	$(location).attr('href','/v1/cart');
})

function wonToInt(s) {
	return parseInt(s.substr(0, s.length - 1).replaceAll(',', ''));
}
function intToWon(s) {
	return s.toLocaleString() + '원';
}
function calTotal() {
	let total_price = 0;
	$('.item__list .item').each(function() {
		let price = wonToInt($(this).children('.item__price').text());

		let count = parseInt($(this).children('.item__qty').children('.qty').text());
		total_price += parseInt(price * count);
	});
	$('.item__totlaPrice span').text(intToWon(total_price));
}

$('.prod__info').click(function(){
	$('.infoTabs .infoTab.active').removeClass('active');
	$(this).addClass('active');
	
	$('.item__review').css('display','none');
	$('.item__info').css('display','block');
})
$('.prod__review').click(function(){
	$('.infoTabs .infoTab.active').removeClass('active');
	$(this).addClass('active');
	
	$('.item__info').css('display','none');
	$('.item__review').css('display','block');
})


