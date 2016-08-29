/**
 * Defines the main routes in the application.
 * The routes you see here will be anchors '#/' unless specifically configured otherwise.
 */

/*define(['./app'], function (app) {
 'use strict';
 return app.config(['$routeProvider', function ($routeProvider) {
 $routeProvider.when('/view1', {
 templateUrl: 'partials/partial1.html',
 controller: 'MyCtrl1'
 });

 $routeProvider.when('/view2', {
 templateUrl: 'partials/partial2.html',
 controller: 'MyCtrl2'
 });

 $routeProvider.otherwise({
 redirectTo: '/view1'
 });
 }]);
 });*/
define(['./app'], function (app) {

    return app
        .run(['$rootScope', '$state', '$stateParams', function ($rootScope, $state, $stateParams) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
            $rootScope.pageClassValue = {
                nextPage: 'nextPage',
                prePage: 'prePage',
                time: 600
            }
            $rootScope.pageClass = {
                index: $rootScope.pageClassValue.nextPage,
                list: $rootScope.pageClassValue.nextPage,
                detail: $rootScope.pageClassValue.nextPage,
                detailInfo: $rootScope.pageClassValue.nextPage
            }


            $rootScope.$on('$stateChangeStart', function (evt, toState, toParams, fromState, fromParams) {
                // 如果需要阻止事件的完成
                // evt.preventDefault();
                console.log(evt);
            });
            $rootScope.$on('$viewContentLoading', function (event, viewConfig) {
                // 获取任何视图设置的参数，以及一个特殊的属性：
                console.log(viewConfig);
                //var pageView=document.querySelectorAll('.page-view');
            });
        }])


        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/index');
            $stateProvider
                .state('index', {
                    url: '/index'
                })
                .state('view1', {
                    url: '/view1',
                    views: {
                        'v1': {
                            templateUrl: 'partials/partial1.html',
                            controller: 'MyCtrl1'
                        }
                    }

                })
                .state('view1.detail', {
                    url: '/detail',
                    templateUrl: 'partials/partial1-detail.html'

                })

                .state('view2', {
                    url: '/view2',
                    views: {
                        'v2': {
                            templateUrl: 'partials/partial2.html',
                            controller: 'MyCtrl2'
                        }
                    }

                })

        }])
});