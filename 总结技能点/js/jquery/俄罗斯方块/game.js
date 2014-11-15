var divs;//所有的div
var stoptext={stop:"暂停",cont:"继续"};//暂停按钮文本提示文字切换
var ranks=[2,6,12,20,30,42];//等级对应的分数
var hardtime=800;//难度时间间隔
var anum=216;//总数
var cnum=12;//列数
var rnum=216/12;//行数
var pic=[//19个图形的初始化序号
		[5,6,17,18],//正方形1个
		[4,5,6,7],[6,18,30,42],//直线2个
		[5,16,17,18],[5,17,18,29],[5,6,7,18],[6,17,18,30],//横线中间凸出一点4个
		[5,17,29,30],[5,6,7,17],[5,6,18,30],[5,15,16,17],[5,17,28,29],[5,17,18,19],[5,6,17,29],[5,6,7,19],//横线边上凸出一点8个
		[5,17,18,30],[6,7,17,18],[6,17,18,29],[5,6,18,19]//三线4个
	];
var ran;//产生的随机数,是第几种图形
var pnum=pic[0].length;//每个图形的方块数
var four=[];//图形单元格
var t=0;//时间
var tm;//计时器
var gm;//控制移动的
var beginpositoin=false;//图形是否从第一行开始
$(function(){
	//点击开始
	$("#begin").click(function(i){
		if($(this).is("[class*=b]"))return;
		$("#begin").removeClass("f").addClass("b");
		$("#stop").removeClass("b").addClass("f");
		$("#over").removeClass("b").addClass("f");
		run();//开始移动
		time();//开始计时
		divs.removeClass("move ok").addClass("blur");//设置所有的单元格背景颜色为默认色
		$("#stop").text(stoptext.stop);
		$("#time,#line,#score,#rank").text("0");
		$("#overtext").hide();
		$("#hard").attr("disabled","disabled");
		newpic();
	});
	//点击暂停/继续
	$("#stop").click(function(){
		if($(this).is("[class*=b]"))return;
		if($(this).text()==stoptext.stop){
			$(this).text(stoptext.cont);
			clearTimeout(tm);//让时间停止
			clearTimeout(gm);//方块停止移动
		}else{
			$(this).text(stoptext.stop);
			run();//继续移动
			time();//继续计时
		}
	});
	//点击结束
	$("#over").click(function(){
		if($(this).is("[class*=b]"))return;
		$("#begin").removeClass("b").addClass("f");
		$("#stop").removeClass("f").addClass("b");
		$("#over").removeClass("f").addClass("b");
		$("#hard").removeAttr("disabled");
		clearTimeout(tm);//让时间停止
		clearTimeout(gm);//方块停止移动
		beginpositoin=false;
		t=0;//时间归零
		$("#overtext").show();
	});
	$("#hard").change(function(){
		hardtime=800-$(this).val()*200;
	});
	//键盘输入
	$(document).bind("keydown",keydown);
	//添加方块
	for(var i=0;i<anum;i++){
		$("#items").append("<div class='blur'></div>");
	}
	divs=$("#items div");//储存所有方块
	$("#hard").removeAttr("disabled");
	hardtime=800-$("#hard").val()*200;
});
//产生一个新图形,并为相关变量赋值
function newpic(){
	ran=parseInt(Math.random()*(pic.length));
	for(var i=0;i<pnum;i++){
		four[i]=pic[ran][i];
		divs.eq(pic[ran][i]).removeClass("blur").addClass("move");
	}
}
//运行
function run(){
	//可以做成级别，控制时间
	if(t%hardtime==0){
		if(beginpositoin){//延迟一秒,看上去就显示在第一行
			var msg=movedown();
			if(msg=="new"||msg=="over")return;
		}
		beginpositoin=true;
	}
	gm=setTimeout("run()",100);
}
//时间
function time(){
	tm=setTimeout("time()",100);
	$("#time").text(parseInt(t/1000));
	t+=100;
}
//键盘按键
function keydown(event){
	//如果没有点击开始或者当前是暂停状态
	if($("#begin").is("[class*=f]")||$("#stop").text()==stoptext.cont)return;
	var i;
	if(event.keyCode==37||event.keyCode==65){//按A键或←键(向左移动一个方块)
		for(i=0;i<pnum;i++){
			//如果到了边界或者碰到堆积的方块,不继续执行
			if(four[i]%cnum==0||divs.eq(four[i]-1).is("[class*=ok]"))return;
		}
		for(i=0;i<pnum;i++){
			//把左边一个方块改为移动中的样式，当前方块改为默认样式
			divs.eq(four[i]-1).removeClass("blur").addClass("move");
			divs.eq(four[i]).removeClass("move").addClass("blur");
			four[i]--;//把数组里的序号减小1
		}
	}else if(event.keyCode==38||event.keyCode==87){//按W键或↑键(变换图形的样式)
		changePic();
	}else if(event.keyCode==39||event.keyCode==68){//按D键或→键(向右移动一个方块)
		for(i=0;i<pnum;i++){
			//如果到了边界或者碰到堆积的方块,不继续执行
			if(four[i]%cnum==cnum-1||divs.eq(four[i]+1).is("[class*=ok]"))return;
		}
		for(i=pnum;i>=0;i--){
			//把右边一个方块改为移动中的样式，当前方块改为默认样式
			divs.eq(four[i]+1).removeClass("blur").addClass("move");
			divs.eq(four[i]).removeClass("move").addClass("blur");
			four[i]++;//把数组里的序号增加1
		}
	}else if(event.keyCode==40||event.keyCode==83){//按S键或↓键(向下移动一个方块)
		movedown();
	}
}
//方块下移
function movedown(){
	for(var i=0;i<pnum;i++){
		//如果到底部或碰到已经堆积的单元格
		if(four[i]>anum-1-cnum||divs.eq(four[i]+cnum).is("[class*=ok]")){
			for(i=0;i<pnum;i++){
				//移动样式修改为堆积样式
				divs.eq(four[i]).removeClass("move").addClass("ok");
			}
			if(four[0]<cnum){//如果第一行堆积方块
				$("#over").click();
				return "over";
			}
			var a,b,c,count=0,beginRow=parseInt(four[pnum-1]/cnum),endRow=parseInt(four[0]/cnum);
			//从图形最下面的单元格所属行开始向上检查每一行是否需要消去
			for(a=beginRow;a>=endRow;a--){
				for(b=0;b<cnum;b++){
					if(divs.eq(a*cnum+b).is("[class*=blur]"))break;
				}
				if(b==cnum){//如果该行的所有方块都是堆积方块
					count++;
					for(b=a;b>0;b--){
						for(c=0;c<cnum;c++){
							//上一行样式等于该行样式
							divs.eq(b*cnum+c).attr("class",divs.eq(b*cnum+c-cnum).attr("class"));
							divs.eq(b*cnum+c-cnum).attr("class","blur");
						}
					}
					a++;//重新检查该行
				}
			}
			if(count>0){
				var line=parseInt($("#line").text());
				$("#line").text(line+count);
				$("#score").text(line+count+count-1);
				for(var j=0;j<ranks.length;j++){
					if($("#score").text()<ranks[j]){
						$("#rank").text(j);
						break;
					}
				}
			}
			//开始下一个图形
			beginpositoin=false;
			newpic();
			clearTimeout(gm);
			run();
			return "new";
		}
	}
	for(i=pnum-1;i>=0;i--){
		//把下面一个方块改为移动中的样式，当前方块改为默认样式
		divs.eq(four[i]+cnum).removeClass("blur").addClass("move");
		divs.eq(four[i]).removeClass("move").addClass("blur");
		four[i]+=cnum;//把数组里的序号增加列数个
	}
}
//根据不同的图形变换出相对的图形
function changePic(){
	//先把四个单元格的背景色都改变为默认色
	for(var i=0;i<pnum;i++){
		divs.eq(four[i]).removeClass("move").addClass("blur");
	}
	//然后根据图形的序号,改变为相对的图形
	switch(ran){
		case 1:
			if(four[0]>anum-1-(pnum-1)*cnum||divs.eq(four[0]+cnum).is("[class*=ok]")||divs.eq(four[0]+cnum*2).is("[class*=ok]")||divs.eq(four[0]+cnum*3).is("[class*=ok]"))break;
			for(i=1;i<pnum;i++)four[i]=four[0]+i*cnum;
			ran=2;
			break;
		case 2:
			if(four[0]%cnum>cnum-pnum||divs.eq(four[0]+1).is("[class*=ok]")||divs.eq(four[0]+2).is("[class*=ok]")||divs.eq(four[0]+3).is("[class*=ok]"))break;
			for(i=1;i<pnum;i++)four[i]=four[0]+i;
			ran=1;
			break;
		case 3:
			if(four[2]>anum-1-cnum||divs.eq(four[2]+cnum).is("[class*=ok]"))break;
			four[1]=four[1]+1;
			four[2]=four[2]+1;
			four[3]=four[3]-1+cnum;
			ran=4;
			break;
		case 4:
			if(four[1]%cnum==0||divs.eq(four[1]-1).is("[class*=ok]"))break;
			four[0]=four[0]-1+cnum;
			ran=5;
			break;
		case 5:
			if(four[1]<cnum||divs.eq(four[1]-cnum).is("[class*=ok]"))break;
			four[0]=four[0]+1-cnum;
			four[1]=four[1]-1;
			four[2]=four[2]-1;
			ran=6;
			break;
		case 6:
			if(four[2]%cnum==cnum-1||divs.eq(four[2]+1).is("[class*=ok]"))break;
			four[3]=four[3]+1-cnum;
			ran=3;
			break;
		case 7:
			if(four[0]%cnum>cnum-3||divs.eq(four[1]+1).is("[class*=ok]")||divs.eq(four[1]+2).is("[class*=ok]"))break;
			four[0]=four[0]+cnum;
			four[1]=four[1]+1;
			four[2]=four[2]-cnum+2;
			four[3]=four[3]-1;
			ran=8;
			break;
		case 8:
			if(four[3]>anum-1-cnum||divs.eq(four[1]+cnum).is("[class*=ok]")||divs.eq(four[1]+cnum+cnum).is("[class*=ok]"))break;
			four[2]=four[2]-1+cnum;
			four[3]=four[3]+1+cnum;
			ran=9;
			break;
		case 9:
			if(four[0]%cnum==0||divs.eq(four[2]-1).is("[class*=ok]")||divs.eq(four[2]-2).is("[class*=ok]"))break;
			four[0]=four[0]+1;
			four[1]=four[1]+cnum-2;
			four[2]=four[2]-1;
			four[3]=four[3]-cnum;
			ran=10;
			break;
		case 10:
			if(four[0]<cnum||divs.eq(four[2]-cnum).is("[class*=ok]")||divs.eq(four[2]-cnum-cnum).is("[class*=ok]"))break;
			four[0]=four[0]-1-cnum;
			four[1]=four[1]+1-cnum;
			ran=7;
			break;
		case 11:
			if(four[1]%cnum==cnum-1||divs.eq(four[1]-1).is("[class*=ok]")||divs.eq(four[3]+1).is("[class*=ok]"))break;
			four[0]=four[0]+cnum-1;
			four[1]=four[1]+cnum-1;
			four[2]=four[2]+1;
			four[3]=four[3]+1;
			ran=12;
			break;
		case 12:
			if(four[1]>anum-1-cnum||divs.eq(four[0]+1).is("[class*=ok]")||divs.eq(four[1]+cnum).is("[class*=ok]"))break;
			four[1]=four[1]+1-cnum;
			four[2]=four[2]-1;
			four[3]=four[3]-2+cnum;
			ran=13;
			break;
		case 13:
			if(four[0]%cnum==0||divs.eq(four[2]+1).is("[class*=ok]")||divs.eq(four[2]-1).is("[class*=ok]"))break;
			four[0]=four[0]-1;
			four[1]=four[1]-1;
			four[2]=four[2]+1-cnum;
			four[3]=four[3]+1-cnum;
			ran=14;
			break;
		case 14:
			if(four[0]<cnum||divs.eq(four[2]-cnum).is("[class*=ok]")||divs.eq(four[3]-1).is("[class*=ok]"))break;
			four[0]=four[0]+2-cnum;
			four[1]=four[1]+1;
			four[2]=four[2]-1+cnum;
			ran=11;
			break;
		case 15:
			if(four[0]%cnum==0||divs.eq(four[0]+1).is("[class*=ok]")||divs.eq(four[1]-1).is("[class*=ok]"))break;
			four[1]=four[1]+1-cnum;
			four[2]=four[2]-2;
			four[3]=four[3]-cnum-1;
			ran=16;
			break;
		case 16:
			if(four[3]>anum-1-cnum||divs.eq(four[1]+cnum).is("[class*=ok]")||divs.eq(four[1]+cnum+cnum).is("[class*=ok]"))break;
			four[1]=four[1]-1+cnum;
			four[2]=four[2]+2;
			four[3]=four[3]+cnum+1;
			ran=15;
			break
		case 17:
			if(four[0]%cnum==cnum-1||divs.eq(four[0]-1).is("[class*=ok]")||divs.eq(four[2]+1).is("[class*=ok]"))break;
			four[0]=four[0]-1;
			four[1]=four[1]+1-cnum;
			four[3]=four[3]+2-cnum;
			ran=18;
			break;
		case 18:
			if(four[2]>anum-1-cnum||divs.eq(four[0]+cnum).is("[class*=ok]")||divs.eq(four[0]+cnum+cnum).is("[class*=ok]"))break;
			four[0]=four[0]+1;
			four[1]=four[1]-1+cnum;
			four[3]=four[3]-2+cnum;
			ran=17;
			break;
	}
	//最后根据图形中单元格所在的序号,把背景色改为红色就行了
	for(i=0;i<pnum;i++){
		divs.eq(four[i]).removeClass("blur").addClass("move");
	}
}