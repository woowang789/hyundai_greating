
    window.onload = function () {
 	   $("#loading").hide();
    	}


    $(document).ready(function() {
    	  $('
    	Loading...
    	')
    	    .insertBefore('#content')
    	    .ajaxStart(function() {
    	     //호출이시작되면
    	      $(this).show();
    	      //보여준다
    	    }).ajaxStop(function() {
    	    //호출이 끝나면
    	      $(this).hide();
    	      //감춘다.
    	    });
    	});</script>


$(document).ready(function() {
	  $('
	now loading

	')
	    .insertBefore('#content)
	});</script>