<%@page pageEncoding="gbk" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/" %>"/>
		<title>��ҳ�治����-��Ե��</title>
		<meta http-equiv="content-type" content="text/html;charset=gbk"/>
		<style>
			.center{height:200px;position:relative;overflow:hidden;}
			.center .border_left{height:233px;}
			.center .border_right{height:233px;}
				.errorimg{position:absolute;left:280px;top:50px;width:81px;height:89px;}
				.error{width:250px;height:150px;margin:30px auto auto 390px;}
					.error_title{font-size:16px;color:#BC0466;}
					.error_info{font-size:15px;color:#636363;margin-top:10px;}
					.error_info a{font-size:15px;color:#178FFB;}
					.error_info ul{list-style:none;margin-top:5px;line-height:25px;}
		</style>
	</head>
	<body>
		<div class="main">
			<%@include file="head.jsp"%>
			<%@include file="upsearch.jsp" %>
			<div class="center">
				<!-- 
				<img class="border_top" src="images/login_border_top.png"/>
				<img class="border_left" src="images/login_border_leftright.png"/>
				<img class="border_right" src="images/login_border_leftright.png"/>
				<img class="border_bottom" src="images/login_border_bottom.png"/>
				 -->
				<img class="errorimg" src="img/404.png"/>
				<div class="error">
					<div class="error_title">�ܱ�Ǹ,����ʵ�ҳ�治����!</div>
					<div class="error_info">
						<p>�볢�Խ������²�����</p>
						<ul>
							<li>1����������ַ�Ƿ���ȷ</li>
							<li>2��ֱ�ӷ���<a href="index.jsp">��Ե��ҳ</a></li>
							<li>3�����ط���<a href="javascript:history.go(-1);">��һ��</a>��ҳ</li>
						</ul>
					</div>
				</div>
			</div>
			<%@include file="bottom.jsp"%>
		</div>
	</body>
</html>