let banner = {
    rollId: null,
    interval: 2000,

    rollInit: function (newinterval) {
        if(parseInt(newinterval) > 0){
            this.interval = newinterval;
        }
        let firstitem = document.querySelector('.rollimgs li');
        if(firstitem){
            firstitem.classList.add('currentroll');
        }
        let seconditem = document.querySelectorAll('.rollimgs li')[1];
        if(seconditem){
            seconditem.classList.add('nextroll');
        }
        document.querySelector('.rollimgs li:last-child').classList.add('prevroll');
        this.rollId = setInterval(this.rollNext, this.interval);
    },
    
    rollNext: function () {
        if(document.querySelector('.prevroll')){
            document.querySelector('.prevroll').classList.remove('prevroll');
        }
        if(document.querySelector('.currentroll')){
            document.querySelector('.currentroll').classList.add('prevroll');
            document.querySelector('.currentroll').classList.remove('currentroll');
        }
        if(document.querySelector('.nextroll')){
            document.querySelector('.nextroll').classList.add('currentroll');
            document.querySelector('.nextroll').classList.remove('nextroll');
        }
        if(document.querySelector('.currentroll').nextElementSibling){
            document.querySelector('.currentroll').nextElementSibling.classList.add('nextroll');
        }else{
            document.querySelector('.rollimgs li').classList.add('nextroll');
        }
    }
}

document.addEventListener('DOMContentLoaded', function(){
    banner.rollInit(4000);
});


// floatbanner

$(window).scroll(function() {
  
    var current = $(window).scrollTop();
    var bannerTop = current + 300 + "px";

    $(".floatbanner").stop().animate({"top" : bannerTop}, 500);

}).scroll();