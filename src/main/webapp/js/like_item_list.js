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
