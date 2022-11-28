function wonToInt(s) {
	return parseInt(s.substr(0, s.length - 1).replaceAll(',', ''));
}
function intToWon(s) {
	return s.toLocaleString() + '원';
}

function total_cal() {
	let total_origin = 0;
	let total_discount = 0;
	let total_market = 0;
	$('.itemList .item__content .item__right').each(function() {
		let origin_price = wonToInt(
			$(this).children().children('.origin_price').text()
		);
		let discount_price = wonToInt(
			$(this).children().children('.discount_price').text()
		);
		let discount = wonToInt($(this).children().children('.discount').text());
		total_origin += origin_price;
		total_discount += discount;
		total_market += discount_price;
	});

	let de_p = 3000;
	if (total_market >= 30000) {
		de_p = 0;
		$('.de_p').text('무료');
	}

	$('.total_price').text(intToWon(total_origin));
	$('.total_discount').text(intToWon(total_discount));
	$('.dep').text(intToWon(de_p));
	$('.total_market').text(intToWon(total_market + de_p));
}
$(document).ready(() => {
	total_cal();
});

$('form').submit(function(e) {
	let prods = [];
	$('.item').each(function() {
		let optnId = $(this).attr('optn');
		let prodId = $(this).attr('prod');
		let stock = $(this).children().children().children()
			.children('span.count').text();
		let price = $(this).children().children()
			.children().children('.discount_price').text().slice(0, -1);
		let prod = {
			"optnId": optnId,
			"prodId": prodId,
			"stock": stock,
			"price": price
		};
		prods.push(prod);
	})
	let param = { "prods": prods };
	$('input[name=prods]').val(encodeURIComponent(JSON.stringify(param)));
	
})