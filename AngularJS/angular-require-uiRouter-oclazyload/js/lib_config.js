/**
 * configure RequireJS
 * prefer named modules to long paths, especially for version mgt
 * or 3rd party libraries
 */
require.config({

    paths: {
        'domReady': '../lib/domReady',
        'angular': '../lib/angular',
        "uiRouter": "../lib/angular-ui-router.min",
		"jquery": "../lib/jquery-1.9.min",
		"touch": "../lib/touch.min",
		"zepto": "../lib/zepto",
        "angular-animate": "../lib/angular-animate",
        "ocLazyLoad": "../lib/ocLazyLoad.min",
        "d3": "../lib/d3.v4.min",
        'jquery-bootstrap': '../lib/bootstrap.min'
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
        'jquery-bootstrap': {
            deps: ['jquery']
        },
        'ocLazyLoad':{
            deps: ['angular','uiRouter']
        }
    },
    
    deps: [
        // kick start application... see bootstrap.js
        './bootstrap'
    ]
});
