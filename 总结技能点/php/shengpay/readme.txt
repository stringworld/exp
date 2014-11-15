本接口适用于能够运行php的任何环境
本支付接口只提供整合思路，开发者需根据本思路自行编码以下文件
index.php
returnurl.php
notifyurl.php
takeorder.php


notifyurl.php为响应盛付通支付通知接口，请务必在支付成功后打印OK，支付失败打印Error
returnurl.php为会员支付成功后浏览器跳转到的地址，开发者可在支付成功或失败后，自行提示会员，或者重定向到其他页面


本接口为第三方友情提供盛付通使用 