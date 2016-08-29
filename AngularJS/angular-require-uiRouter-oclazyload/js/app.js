/**
 * loads sub modules and wraps them up into the main module
 * this should be used for top-level module definitions only
 */
define(['angular','angular-animate','ocLazyLoad','uiRouter','./controllers/index','./directives/index','./filters/index','./services/index'
], function (angular) {
    

    return angular.module('app', [
        'app.services',
        'app.controllers',
        'app.filters',
        'app.directives',
        'ui.router',
        'ngAnimate',
        'oc.lazyLoad'
    ]);
});