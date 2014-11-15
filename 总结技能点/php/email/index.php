<?php
	require("UtilEmailer.php");
	
	$result=UtilEmailer::sendEmail("邮件测试","374936891@qq.com","收件人","邮件标题","<span style='color:#f00;'>邮件内容</span>");
	if($result){
		echo "邮件发送成功";
	}else{
		echo "邮件发送失败. <br/>";
		echo "错误原因: " . $result->info;
	}
?>