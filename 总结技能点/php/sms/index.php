<?php
	require_once("SMS.php");
	if(!isset($numbers))$numbers=null;
	if(!isset($content))$content=null;
	$result=null;
	if(!empty($numbers)&&!empty($content)){
		$result=SMS::send($numbers,$content);
		if($result=="1"){
			$result="发送成功";
		}else{
			$result="发送失败";
		}
	}
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>手机短信</title>
		<style>
			*{margin:0;padding:0;}
		</style>
	</head>
	<body>
		<form method="post">
			<table style="width:350px;margin:0px auto;">
				<tr>
					<td>手机号码：</td>
					<td><input name="numbers" type="text" size="30" value="<?php echo $numbers; ?>"/></td>
				</tr>
				<tr>
					<td>短信内容：</td>
					<td><textarea name="content" cols="24" rows="3"><?php echo $content; ?></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="发送"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><?php echo $result; ?></td>
				</tr>
			</table>
		</form>
	</body>
</html>