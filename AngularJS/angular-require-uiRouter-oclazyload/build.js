({
    appDir: "./",  //  根目录 开始拷贝的目录
    baseUrl: "./js",   //  开始压缩的目录
    dir: "./build",   // 输出目录
    modules: [
        {
            name: "lib_config"  //压缩的模板
        }
    ],
    fileExclusionRegExp: /^(r|build)\.js$/,
    optimizeCss: 'standard',
    removeCombined:true,
    paths: {
        'domReady': '../lib/domReady',
        'angular': '../lib/angular',
        "uiRouter": "../lib/angular-ui-router.min",
        "jquery": "../lib/jquery-1.7.1",
        "touch": "../lib/touch.min",
        "zepto": "../lib/zepto",
        "angular-animate": "../lib/angular-animate",
        "ocLazyLoad": "../lib/ocLazyLoad.min"
    },
    map: {
        '*': {
            'css': '../lib/css'
        }
    },

    /**
     * for libs that either do not support AMD out of the box, or
     * require some fine tuning to dependency mgt'
     */
    shim: {
        'angular': {
            exports: 'angular'
        },
        'zepto': {
            exports: '$'
        },
        'jquery': {
            exports: '$'
        },
        'uiRouter':{
            deps: ['angular']
        },
        'angular-animate':{
            deps: ['angular']
        },
        'ocLazyLoad':{
            deps: ['angular','uiRouter']
        }
    },

    deps: [
        // kick start application... see bootstrap.js
        './bootstrap'
    ]
})