<?php

require_once('core/core.php');

$shengpay=new shengpay();
$array=array(
	'Name'=>'B2CPayment',
	'Version'=>'V4.1.1.1.1',
	'Charset'=>'UTF-8',
	'MsgSender'=>'170811',
	'SendTime'=>date('YmdHis'),
	'OrderTime'=>date('YmdHis'),
	'PayType'=>'PT001',
	'PayChannel'=>'19',/*（19 储蓄卡，20 信用卡）做直连时，储蓄卡和信用卡需要分开*/
	'InstCode'=>'CMB', //银行编码，参考接口文档
	'PageUrl'=>'http://localhost/shengpay-php-demo/pageurl.php',
	'NotifyUrl'=>'http://localhost/shengpay-php-demo/notifyurl.php',
	'ProductName'=>'盛付通支付接口测试',
	'BuyerContact'=>'',
	'BuyerIp'=>'',
	'Ext1'=>'',
	'Ext2'=>'',
	'SignType'=>'MD5',
);
$shengpay->init($array);
$shengpay->setKey('bonliwangluo0513abc');

/*通过get传入oid和fee*/
$oid=$_GET['oid'];
$fee=$_GET['fee'];
/*其他参数设置*/
/*
	PayType或者InstCode等其他参数
	$shengpay->setParam('PayType','PT002');
/*
/*
	商家自行检测传入的价格与数据库订单需支付金额是否相同
*/
$shengpay->takeOrder($oid,$fee);