$('.option__reset').click(() => {
  $('.tail select option:eq(0)').prop('selected', true);
  $('.tail input').val('');
});
