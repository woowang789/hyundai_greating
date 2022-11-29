let flag = false;

$('.idCheckBtn').click(() => {
  let id = $('.id__input .tail input').val();
  console.log('input : ',id)
  $.ajax({
    type: 'POST',
    url: 'http://localhost/api/checkId',
    data: JSON.stringify({  userId:id }),
    contentType: 'application/json; charset=utf-8',
    success: function (res) {
      flag = JSON.parse(res.flag);
      if (flag) $('.checkBtn').css('background-color', '#818181');
      else alert('해당 아이디가 이미 존재함');
    },
  });
});

var regex = RegExp(/^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/);
let tmp = regex.test("2020-09-25");

$('.gender__input i').click(function () {
	let g = $(this).attr('val');
	$('input[name=gender]').val(g);
  $('.gender__input i.active').removeClass('active');
  $(this).addClass('active');
});
$('.id__input input').change(function (e) {
  flag = false;
  $('.checkBtn').css('background-color', '#918C01');
});
$('form').submit(function (e) {
  if ($('.pw__input input').val() == '' ||
   $('.id__input input').val() == '' ) {
	alert('아이디 & 비밀번호 확인');
    e.preventDefault();
    return;
  }
  if(!regex.test($('.birth__input input').val())){
	alert("날짜 형식이 올바르지 않음");
	 e.preventDefault();
    return;
	}
  if (!flag) {
	alert("아이디 중복확인 필요")
    e.preventDefault();
    return;
  }
  if($('input[name=gender]').val() != 'M' && 
  	$('input[name=gender]').val() != 'F'){
		alert("성별 선택 필요");
    	e.preventDefault();
    	return;
  }
  if ($('.pw__input input').val() != $('.pwCheck__input input').val()) {
	alert('비밀번호 체크란을 확인해주세요')
    e.preventDefault();
    return;
  }
  
  
  
});
