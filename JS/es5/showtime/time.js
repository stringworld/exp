// JavaScript Document
/*
在网页中格式的引用

<span id="localtime" style="float:left; text-indent:8em;">2014年05月27日 13:12:02  星期二</span>

*/
window.onload = initDate;
function initDate(){
	var dayName = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	var monName = new Array("1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月");
	var now = new Date();
	var ye=now.getYear();
	var dtString = (now.getYear()+1900)+"年"+monName[now.getMonth()] + now.getDate() +"日"+" "+ now.getHours() +":"+now.getMinutes()+":"+now.getSeconds() +" ,"+dayName[now.getDay()];
	document.getElementById("localtime").innerHTML = dtString;
	window.setTimeout("initDate()", 1000);
}