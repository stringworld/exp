$(document).ready(function(){
	var pos={direction:"right",side:20,top:150};//位置：方向，两侧，顶部距离
	$("#qqservice").css(pos.direction,pos.side).css("top",pos.top);
	$("#qqservice_content").height($("#qqservice_content_").outerHeight());
	$("#qqservice_close").click(function(){
		$("#qqservice").hide();
		clearInterval(qqservice_tmr);
	});
	if($("#qqservice").length!=0){
		//循环调用该函数计算qqservice坐标
		var qqservice_tmr=setInterval(function(){
			var top=parseInt($("#qqservice").css("top").replace("px",""));
			top=top+($(document).scrollTop()+pos.top-top)/5;
			$("#qqservice").css("top",top);
		},30);
	}
});