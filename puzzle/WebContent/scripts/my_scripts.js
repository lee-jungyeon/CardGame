/**
 * p72.html
 */


$(document).ready(function(){
	
		let getRandom = function(num){
			let my_num = Math.floor(Math.random()*num);
			return my_num;
		}
		
		let hideCode = function(){	
			let numRand = getRandom(4); //0,1,2,3
			numRand = 0;
			$(".guess_box").each(function(index, item){// 0,1,2,3 반복
				
				if(numRand === index){
					$(this).append("<span id='has_discount'><sqpn>");
					return false; //함수 종료
					
					
				}
			
			});
			
		}
		hideCode();
	
		let checkForCode = function(){
			let discount = "";
			if($.contains(this, document.getElementById("has_discount"))){
				let my_num = getRandom(100);
				discount = "<p>Your Code:CODE"+new Date().getTime()+my_num+"<p>";
			}else{
				discount = "<p>Sorry, no discount this time!<p>";
			}
			$(this).append(discount);
			
			$(".guess_box").each(function(){
				if($.contains(this, document.getElementById("has_discount"))){
					$(this).addClass("discount");
					
				}else{
					$(this).addClass("no_discount");
				}
				
					$(this).unbind("click"); //한번 클릭하면 다시 클릭못하개한다.
			});
			
			};
			$(".guess_box").click(checkForCode);
});