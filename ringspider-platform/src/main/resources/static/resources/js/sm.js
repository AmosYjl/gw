// JavaScript Document

		var lock = true;
		$(".menubtn").click(function(){
			if(lock){
				$(".nav").slideDown(300,function(){
					$(".nav ul").show(400)
				});
				$(".menubtn").css({"transform":"rotate(90deg)"})
				$(".menubtn span").css({"background-color":"#fff"})
				lock = false;
				
			}else{
				$(".menubtn").css({"transform":"rotate(0)"})
				$(".menubtn span").css({"background-color":"#78c959"})
				$(".nav").slideUp(300);
				$(".nav ul").hide(400);
				lock = true;
			}
		})