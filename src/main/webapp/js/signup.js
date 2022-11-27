let flag = false;

$('.idCheckBtn').click(() => {
  let id = $('.id__input tail input').text();
  $.ajax({
    type: 'POST',
    url: 'http://localhost/api/checkId',
    data: JSON.stringify({ userId: id }),
    contentType: 'application/json; charset=utf-8',
    success: function (res) {
      flag = JSON.parse(res.flag);
      if (flag) $('.checkBtn').css('background-color', '#818181');
    },
  });
});
$('.gender__input i').click(function () {
  $('.gender__input i.active').removeClass('active');
  $(this).addClass('active');
});
$('.id__input input').change(function () {
  flag = false;
  $('.checkBtn').css('background-color', '#918C01');
});
$('form').submit(function (e) {
  if ($('.pw__input input').val() == '' || $('.id__input input').val() == '') {
    e.preventDefault();
    return;
  }
  if (!flag) {
    e.preventDefault();
    return;
  }
  if ($('.pw__input input').val() != $('.pwCheck__input input').val()) {
    e.preventDefault();
    return;
  }
});
