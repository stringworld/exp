 public function notify_url () {
	echo "aaaa";
	die;
    $alipay_config = C('alipay_config');
    $alipay_notify = new AlipayNotify($alipay_config);
    $verify_result = $alipay_notify->verifyNotify();

    if ($verify_result) {
        //验证成功
        $parameter = array(
            'out_trade_no'  => $_POST['out_trade_no'],
            'trade_no'      => $_POST['trade_no'],
            'total_fee'     => $_POST['total_fee'],
            'trade_status'  => $_POST['trade_status'],
            'notify_id'     => $_POST['notify_id'],
            'notify_time'   => $_POST['notify_time'],
            'buyer_email'   => $_POST['buyer_email']
        );

        if ($_POST['trade_status'] == 'TRADE_SUCCESS' || $_POST['trade_status'] == 'TRADE_FINISHED')  {
            //if ( ! checkorderstatus($_POST['out_trade_no']) ) {
                orderhandle($parameter);
            //}

            echo 'success';
        }
    } else {
        echo 'fail';
    }
}