/*

function wrapWindowByMask() {
 
       

        var maskHeight = $(document).height(); 
        var maskWidth = window.document.body.clientWidth;
        var mask = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
        var loadingImg = '';

        loadingImg += "<div id='loading-image' style='position:absolute; left:50%; top:40%; display:none; z-index:10000;'>";
 
        loadingImg += "<img src="../img/loading.gif"/> ";
       
        loadingImg += "</div>";  
 

        $('body')
 
            .append(mask)
 
            .append(loadingImg)
 
           
 
        $('#mask').css({
 
                'width' : maskWidth
 
                , 'height': maskHeight
 
                , 'opacity' : '0.3'
 
        }); 
 

        $('#mask').show();   
 

        $('#loading-image').show();
 
    }
 */
/*
<script>
function test(imageName) {
    LoadingWithMask('src=../img/loading.gif');
    setTimeout("closeLoadingWithMask()", 3000);
}
 
function LoadingWithMask(gif) {
    //화면의 높이와 너비를 구합니다.
    var maskHeight = $(document).height();
    var maskWidth  = window.document.body.clientWidth;
     
    //화면에 출력할 마스크를 설정해줍니다.
    var mask       = "<div id='mask' style='position:absolute; z-index:9000; background-color:#000000; display:none; left:0; top:0;'></div>";
    var loadingImg = '';
      
    loadingImg += " <img src='"+ gif + "' style='position: absolute; display: block; margin: 0px auto;'/>";
 
    //화면에 레이어 추가
    $('body')
        .append(mask)
 
    //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채웁니다.
    $('#mask').css({
            'width' : maskWidth,
            'height': maskHeight,
            'opacity' : '0.3'
    }); 
  
    //마스크 표시
    $('#mask').show();
  
    //로딩중 이미지 표시
    $('#loadingImg').append(loadingImg);
    $('#loadingImg').show();
}
 
function closeLoadingWithMask() {
    $('#mask, #loadingImg').hide();
    $('#mask, #loadingImg').empty();  
}*/

