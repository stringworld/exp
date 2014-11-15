<?php

require_once('core/core.php');


$shengpay=new shengpay();
$shengpay->setKey('shengfutongSHENGFUTONGtest');
if($shengpay->returnSign()){
	/*支付成功*/
	$oid=$_POST['OrderNo'];
	$fee=$_POST['TransAmount'];
	/*
		商家自行检测商家订单状态，避免重复处理，而且请检查fee的值与订单需支付金额是否相同
	*/
	echo 'OK';
}else{
	echo 'Error';
}