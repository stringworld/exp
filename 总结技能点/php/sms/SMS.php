<?php
	require_once("nusoap.php");

	class SMS{
		/**
	     * 发送短信
	     * @param $numbers 手机号码（多个手机号码之间用,分割）
	     * @param $content 内容
	     * @return 成功1，失败0
	     */
		public static function send($numbers,$content){
			$content=iconv("utf-8","gbk",$content);//字符转码
			$sms=new soapclient("http://210.14.64.74:81/SmsService/UnicomWdslRec.asmx?wsdl",true);
			$sms->soap_defencoding="gbk";
			$sms->decode_utf8=false;
			$aryPara=array(
				"Sd_UserName"=>"201303061039",
				"Sd_UserPsd"=>"123456",
				"Sd_Phones"=>$numbers,
				"Sd_MsgContent"=>$content,
				"Sd_SchTime"=>"",
				"Sd_ExNumber"=>"888",
				"Sd_SeqNum"=>""
				);
			$aryResult=$sms->call("SendMessage",array("parameters"=>$aryPara));
			$err=$sms->getError();
			if($aryResult=="0,send success!"){
				return "1";
			}else{
				return "0";
			}
		}
	}
?>