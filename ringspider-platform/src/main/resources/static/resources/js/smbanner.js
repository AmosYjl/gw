// JavaScript Document
function MobileCarousel(oId){
			this.carousel = document.querySelector("#" + oId);
			this.lis = document.querySelectorAll("#" + oId +" ul li");
			this.xiaoyuandians = document.querySelectorAll("#" + oId +" ol li");
			this.ul = document.querySelector("#" + oId +" ul");
			this.images = document.querySelectorAll("#" + oId +" ul li img");

			var self = this;
			
			this.init();

			this.carousel.addEventListener("touchstart",function(event){
				self.touchstartHandler.call(self,event);
			},false);
			this.carousel.addEventListener("touchmove",function(event){
				self.touchmoveHandler.call(self,event);
			},false);
			this.carousel.addEventListener("touchend",function(event){
				self.touchendHandler.call(self,event);
			},false);

		  	window.addEventListener("resize",function(){
		  		self.init.call(self);
		  	},false);
		}

		//鍒濆鍖�
		MobileCarousel.prototype.init = function(){
			this.w = parseFloat(getComputedStyle(this.carousel)["width"]);

			this.idx = 0;
			this.nextIdx = 1;
			this.prevIdx = this.lis.length - 1;

			//璁剧疆楂樺害
			this.carousel.style.height = this.w * (890 / 1917) + "px";

			this.lis[0].style.transition = "none";
			this.lis[0].style.webkitTransform = "translate3d(0px,0,0)";
			for(var i = 1 ; i < this.lis.length ; i++){
				this.lis[i].style.transition = "none";
				this.lis[i].style.webkitTransform = "translate3d(" + this.w + "px,0,0)";
			}
		}
		//瑙︽懜寮€濮�
		MobileCarousel.prototype.touchstartHandler = function(event){
			event.preventDefault();
			this.startTime = new Date();
			var finger = event.touches[0];
 			this.startX = finger.clientX;
 			this.lis[this.idx].style.webkitTransition = "none";
 			this.lis[this.prevIdx].style.webkitTransition = "none";
 			this.lis[this.nextIdx].style.webkitTransition = "none";
 			this.lis[this.idx].style.webkitTransform = "translate3d(" + 0 + "px,0,0)";
			this.lis[this.nextIdx].style.webkitTransform = "translate3d(" + this.w + "px,0,0)";
			this.lis[this.prevIdx].style.webkitTransform = "translate3d(" + -this.w + "px,0,0)";

		}
		//瑙︽懜绉诲姩
		MobileCarousel.prototype.touchmoveHandler = function(event){
			event.preventDefault();
			var finger = event.touches[0];
			this.dx = finger.clientX - this.startX;

 			this.lis[this.idx].style.webkitTransform = "translate3d(" + (0 + this.dx) + "px,0,0)";
 			this.lis[this.nextIdx].style.webkitTransform = "translate3d(" + (this.w + this.dx) + "px,0,0)";
 			this.lis[this.prevIdx].style.webkitTransform = "translate3d(" + (-this.w + this.dx) + "px,0,0)";
		 
		}

		//瑙︽懜缁撴潫
		MobileCarousel.prototype.touchendHandler = function(event){
			event.preventDefault();
			var endDuaring = new Date() - this.endTime;
			this.endTime = new Date();
			var touchDuaring = this.endTime - this.startTime;
			
			if(endDuaring < 300){
				var transitionString = "none";
			}else{
				var transitionString = "all 0.3s cubic-bezier(0.56, 1.24, 1, 0.98) 0s";
			}

			//鍒ゆ柇姝ゆ椂鏄惁婊戝姩瀹屾垚
			if((this.dx >= this.w / 3) || (this.dx > 10 && touchDuaring < 200)){
				//鍚戝彸婊戝姩鎴愬姛
				this.lis[this.idx].style.webkitTransition = transitionString;
				this.lis[this.idx].style.webkitTransform = "translate3d(" + this.w + "px,0,0)";
				this.lis[this.prevIdx].style.webkitTransition = transitionString;
				this.lis[this.prevIdx].style.webkitTransform = "translate3d(" + 0 + "px,0,0)";

				//淇″彿閲忕殑鏀瑰彉
 				this.nextIdx = this.idx;
 				this.idx = this.prevIdx;
 				this.prevIdx--;
 				if(this.prevIdx < 0){
 					this.prevIdx = this.lis.length - 1;
 				}
			}else if((this.dx <= -this.w / 3) || (this.dx < -10 && touchDuaring < 200)){
				//鍚戝乏婊戝姩鎴愬姛
				this.lis[this.idx].style.webkitTransition = transitionString;
				this.lis[this.idx].style.webkitTransform = "translate3d(" + -this.w + "px,0,0)";
				this.lis[this.nextIdx].style.webkitTransition = transitionString;
				this.lis[this.nextIdx].style.webkitTransform = "translate3d(" + 0 + "px,0,0)";
 				
 				//淇″彿閲忕殑鏀瑰彉
 				this.prevIdx = this.idx;
 				this.idx = this.nextIdx;
 				this.nextIdx++;
 				if(this.nextIdx > this.lis.length - 1){
 					this.nextIdx = 0;
 				}
			}else{
				//娌℃湁鎴愬姛锛屽脊鍥炴潵
				this.lis[this.idx].style.webkitTransition = "all 0.3s cubic-bezier(0.56, 1.24, 1, 0.98) 0s";
				this.lis[this.idx].style.webkitTransform = "translate3d(" + 0 + "px,0,0)";
				this.lis[this.nextIdx].style.webkitTransition = "all 0.3s cubic-bezier(0.56, 1.24, 1, 0.98) 0s";
				this.lis[this.nextIdx].style.webkitTransform = "translate3d(" + this.w + "px,0,0)";
				this.lis[this.prevIdx].style.webkitTransition = "all 0.3s cubic-bezier(0.56, 1.24, 1, 0.98) 0s";
				this.lis[this.prevIdx].style.webkitTransform = "translate3d(" + -this.w + "px,0,0)";
			}

			//搴忓垪鍦嗙偣
			for(var i = 0 ; i < this.xiaoyuandians.length ; i++){
				this.xiaoyuandians[i].className = "";
			}
			this.xiaoyuandians[this.idx].className = "cur";
		}
		var carousel = new MobileCarousel("carousel");