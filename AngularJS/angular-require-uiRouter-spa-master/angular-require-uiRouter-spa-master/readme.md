angular+spa+uirouter

此套架构试用于Ie8以及以上浏览器


1.入口文件lib_config 配置JS依赖关系 启动bootstrap.

 app.js里面激活angular插件 


2.目录文件controllers，directives，filters，services 下的index.js 

包含各类模块，可用于团队集体开发（一个开发人员一个文件）


3.路由统一由uirouter管理，路由代码在routes.js中. 

（这里注意子页面嵌套关系 page 以及 pageview 属性的应用，主要是单页CSS
的问题）

pageview 指令可在directive里查看

4.完成项目，打包压缩 打开node.js 进入目录执行 node r.js -o build.js

工程化代码 配置文件在build.js


如有疑问请联系
stone 
QQ 327610720



