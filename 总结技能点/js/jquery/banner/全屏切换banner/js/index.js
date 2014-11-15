$(function(){
	$(window).resize(function(){
		var imgWidth=1900;//图片宽度
		var conWidth=1160;//主体显示区域宽度
		var showWidth=$(window).width();//浏览器显示区域宽度
		if(showWidth<conWidth){
			$(".banner img").css("left",(conWidth-imgWidth)/2);
			$(".banner,.menuw").width(conWidth);
		}else{
			$(".banner img").css("left",(showWidth-imgWidth)/2);
			$(".banner,.menuw").width(showWidth);
		}
	});
	$(window).resize();
	show_count=$(".banner img").length;
	show(0);
	
	var m_tmr;
	var m_time=300;
	$(".mi,.mu").mouseenter(function(){
		clearTimeout(m_tmr);
		if($(this).is("[to],[class*=mu]")){
			if($(this).is("[to]")){
				$(".mu").hide();
				$(".mubg").show();
				var m_index=$(this).attr("to");
				//子菜单坐标
				if(m_index<6){
					var left=$(this).offset().left;
					$(".mu.t"+m_index).show().css("left",left);
				}else{
					var right=$(this).parents(".menuw:first").width()-$(this).offset().left-$(this).width();
					$(".mu.t"+m_index).show().css("right",right);
				}
			}
		}else{
			$(".mubg,.mu").hide();
		}
		//显示菜单项光影
		if($(this).is("[class*=mi]")){
			if($(this).is("[class*=i1]")){
				$(".mif").css("left",$(this).position().left-87).show();
			}else{
				$(".mif").css("left",$(this).position().left-76).show();
			}
		}
	}).mouseleave(function(){
		$(".mif").hide();
		//延迟隐藏子菜单
		m_tmr=setTimeout(function(){
			$(".mubg,.mu").hide();
		},m_time);
	});
});
var show_timer=null;		//切换计时器
var show_time=1000;	//显示效果时间
var show_spacetime=3000;	//切换间隔时间
var show_count=0;	//显示个数
var show_current=0;		//当前显示索引
//切换图片、更换按钮样式
function show(i){
	if(isNaN(i)||i<0||i>=show_count)i=0;
	clearTimeout(show_timer);
	if(i!=show_current){
		$(".banner img").stop();
		$(".banner img").each(function(){
			if($(this).index()!=i&&$(this).index()!=show_current){
				$(this).css({"z-index":0});
			}
			$(this).show();
		});
		$(".banner img:eq("+show_current+")").css("z-index",2).animate({opacity:0},show_time,function(){
			$(this).hide();
		});
		$(".banner img:eq("+i+")").css("z-index",1).animate({opacity:1},show_time);
	}
	show_current=i;
	show_timer=setTimeout(function(){show(show_current+1);},show_spacetime);
}