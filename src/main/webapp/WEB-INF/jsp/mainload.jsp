<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajax 로딩바 구현하기</title>
 
<script src="http://code.jquery.com/jquery-latest.min.js"></script><!-- 항상 최신버전의 JQuery를 사용가능하다. -->
 
<script type="text/javascript" language="javascript">
 
$(document).ready(function(){
	
   $('#Progress_Loading').hide(); //첫 시작시 로딩바를 숨겨준다.
})
.ajaxStart(function(){
	$('#Progress_Loading').show(); //ajax실행시 로딩바를 보여준다.
})
.ajaxStop(function(){
	$('#Progress_Loading').hide(); //ajax종료시 로딩바를 숨겨준다.
});
 
$(document).ready(function(){
	
    $.ajax({
        type : "GET", //전송방식을 지정한다 (POST,GET)
        url : "InputData.jsp?type=2",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
        error : function(){
            alert('통신실패!!');
        },
        success : function(Parse_data){
        	
            $("#Parse_Area").html(Parse_data); //div에 받아온 값을 넣는다.
            alert("통신데이터 값 : " + Parse_data);
        }
         
    });
}); 
 
</script>
 
</head>

<body>

<div id = "Progress_Loading"><!-- 로딩바 -->
<img src="Progress_Loading.gif"/>
</div>

<style type = "text/css"> <!-- 로딩바스타일 -->
body
{
 text-align: center;
 margin: 0 auto;
}
#Progress_Loading
{
 position: absolute;
 left: 50%;
 top: 50%;
 background: #ffffff;
}
</style>
    <div id="Parse_Area"></div> <!--받아온 데이터들이 들어갈 div -->
</body>
</html>