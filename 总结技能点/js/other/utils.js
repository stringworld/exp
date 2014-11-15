if(!window.Utils){
	window.Utils={};
}
(function($){
	/*
	type
	formatJSON
	parseJSON
	formatDate
	cookie
	isEmpty
	*/
	//查看变量类型
	$.type=function(o){
        var _toS=Object.prototype.toString;
        var _types={
            'undefined': 'undefined',
            'number': 'number',
            'boolean': 'boolean',
            'string': 'string',
            '[object Function]': 'function',
            '[object RegExp]': 'regexp',
            '[object Array]': 'array',
            '[object Date]': 'date',
            '[object Error]': 'error'
        };
        return _types[typeof o] || _types[_toS.call(o)] || (o ? 'object' : 'null');
    };
	var $specialChars={'\b': '\\b', '\t': '\\t', '\n': '\\n', '\f': '\\f', '\r': '\\r', '"': '\\"', '\\': '\\\\'};
	var $replaceChars=function(chr){return $specialChars[chr] || '\\u00' + Math.floor(chr.charCodeAt() / 16).toString(16) + (chr.charCodeAt() % 16).toString(16);};
	//把对象转换为json格式的字符串
	$.formatJSON=function(o){
		var s=[];
		switch ($.type(o)){
			case 'string':
				return '"' + o.replace(/[\x00-\x1f\\"]/g, $replaceChars) + '"';
			case 'number':
			case 'boolean':
			case 'function':
				return o.toString();
			case 'date':
				var year=o.getFullYear(),month=o.getMonth()+1,day=o.getDate(),hours=o.getHours(),minutes=o.getMinutes(),seconds=o.getSeconds(),milli=o.getMilliseconds();
				if(month<10){month='0'+month;}
				if(day<10){day='0'+day;}
				if(hours<10){hours='0'+hours;}
				if(minutes<10){minutes='0'+minutes;}
				if(seconds<10){seconds='0'+seconds;}
				if(milli<10){milli='0'+milli;};
				return '"'+year+'-'+month+'-'+day+' '+hours+':'+minutes+':'+seconds+'"';
			case 'array':
				for (var i=0, l=o.length; i < l; i++){
					s.push($.formatJSON(o[i]));
				}
				return '[' + s.join(',') + ']';
			case 'object':
			case 'error':
				for (var p in o){
					s.push(p + ':' + $.formatJSON(o[p]));
				}
				return '{' + s.join(',') + '}';
			case 'undefined':
				return 'undefined';
			case 'null':
				return 'null';
			default:
				return '';
		}
	};
	//把json格式的字符串转换为对象
	$.parseJSON=function(s){
	    if ($.type(s) != 'string' || !s.length) return null;
	    var obj = null;
	    try {
	        obj = eval('(' + s + ')');
	    } catch (e) { }
	    return obj;
	};
	//把日期按照指定格式转换为字符串
	//yyyy-MM-dd hh:mm:ss
	//yyyy年MM月dd日 hh时mm分ss秒S毫秒 第q季度
	$.formatDate=function(date,fmt){
		if($.type(date)!="date"||fmt==null)return;
		var o={
			"M+" : date.getMonth()+1,
			"d+" : date.getDate(),
			"h+" : date.getHours(),
			"m+" : date.getMinutes(),
			"s+" : date.getSeconds(),
			"q+" : Math.floor((date.getMonth()+3)/3),
			"S" : date.getMilliseconds()
		};
		if(/(y+)/.test(fmt)){
			fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4-RegExp.$1.length));
		}
		for(var k in o){
			if(new RegExp("("+ k +")").test(fmt)){
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1)?(o[k]):(("00"+o[k]).substr((""+ o[k]).length)));
			}
		}
		return fmt;
	}
	//封装cookie
	//expires保存时间（秒，设置为0，有效期当前会话），path站点内可用路径，domain域名，secure是否使用其他协议（如：https）
	//$.cookie("age",10,{expires:30,path:"/",domain:"jquery.com",secure:false});
	$.cookie=function(name,value,options){
		if(typeof value!="undefined"){//如果第二个参数存在
			options=options||{};//初始化第三个参数，如果不存在则设置为空字符串
			if(value===null){//如果第二个参数值为null，则表示删除该cookie值
				value="";//清空值
				options.expires=-1;//设置失效时间
			}
			var expires="";
			if(options.expires&&(typeof options.expires=="number"||options.expires.toUTCString)){
				var date;
				if(typeof options.expires=="number"){//设置时间，把天数转换为毫秒数添加到时间对象中
					date=new Date();
					date.setTime(date.getTime()+options.expires*1000);
				}else{//如果是时间格式，则直接传递时间参数
					date=options.expires;
				}
				expires=";expires="+date.toUTCString();
			}
			var path=options.path?";path="+options.path:"";//设置路径
			var domain=options.domain?";domain="+options.domain:"";//设置域
			var secure=options.secure?";secure":"";//设置安全措施
			document.cookie=[name,"=",encodeURIComponent(value),expires,path,domain,secure].join("");
		}else{//如果第二个参数不存在，则表示读取指定cookie信息
			var cookieValue=null;
			if(document.cookie&&document.cookie!=""){//如果cookie信息不存在且不为空
				var cookies=document.cookie.split(";");
				for(var i=0;i<cookies.length;i++){//遍历cookie信息
					var cookie=(cookies[i]||"").replace(/^\s+|\s+$/g,"");//清除两侧空格
					if(cookie.substring(0,name.length+1)==(name+"=")){//匹配指定cookie名称
						cookieValue=decodeURIComponent(cookie.substring(name.length+1));
						break;
					}
				}
			}
			return cookieValue;
		}
	}
	//判断数据是否为空
	$.isEmpty=function(val){
		switch (typeof val){
			case "string":
			  return $.trim(val).length==0;
			case "number":
			  return val==0;
			case "object":
			  return val==null;
			case "array":
			  return val.length==0;
			default:
			  return true;
		}
	}
})(window.Utils);
//去除空字符
String.prototype.trim=function(){
    return this.replace(/^\s+|\s+$/,"");
}