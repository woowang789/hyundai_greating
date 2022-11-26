$('.option__reset').click(() => {
  $('.tail select option:eq(0)').prop('selected', true);
  $('.tail input').val('');
});

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

function orderList(res) {}
