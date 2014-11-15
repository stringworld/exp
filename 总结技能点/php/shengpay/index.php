<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN""http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns = 'http://www.w3.org/1999/xhtml'>
<head>
	<meta http-equiv = 'content-Type' content = 'text/html; charset = utf-8'/>
	<title>盛付通支付测试</title>
</head>
	<body>
		<form action='takeorder.php' method='get'>
			<input type='hidden' name='oid' value='<?php echo date('YmdHis');?>'/>
			<p>支付金额 <input type='text' name='fee' value='100'/></p>
			<p><input type='submit' value='去支付'/></p>
		</form>
	</body>
</html>