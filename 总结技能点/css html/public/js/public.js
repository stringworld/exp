$(function(){
	var container_width=1000;//主内容区宽度
	/*************处理png图片在IE6下的透明问题*************/
	if(window.DD_belatedPNG){
		DD_belatedPNG.fix(".png");
	}
	/*************页面宽度调整*************/
	$(window).resize(function(){
		$(".headerw,.footerw").width(Math.max(container_width,$(window).width()));
	});
	$(window).resize();
});