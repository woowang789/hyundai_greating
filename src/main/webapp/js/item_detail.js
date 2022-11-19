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
