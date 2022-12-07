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
    console.log(prodId);

    $.ajax({
      type: 'POST',
      url: 'http://localhost/api/toggleInterest',
      data: JSON.stringify({ prodId: prodId, userId: userId}),
      contentType: "application/json; charset=utf-8",
      success: (res) => reDrawProduct(res['list']),
    });
  });
});
