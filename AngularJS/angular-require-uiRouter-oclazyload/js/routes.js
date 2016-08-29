define(['./app', 'zepto', 'd3'], function(app, zepto, d3) {

    return app
        .run(['$rootScope', '$state', '$stateParams', function($rootScope, $state, $stateParams) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
            5
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


            $rootScope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
                // Èç¹ûÐèÒª×èÖ¹ÊÂ¼þµÄÍê³É
                // evt.preventDefault();
                console.log(evt);
            });
            $rootScope.$on('$viewContentLoading', function(event, viewConfig) {
                // »ñÈ¡ÈÎºÎÊÓÍ¼ÉèÖÃµÄ²ÎÊý£¬ÒÔ¼°Ò»¸öÌØÊâµÄÊôÐÔ£º
                console.log(viewConfig);
                // alert('loading');
                //var pageView=document.querySelectorAll('.page-view');
            });

        }])


    .config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
        //ÀÁ¼ÓÔØ³õÊ¼»¯
        $ocLazyLoadProvider.config({
            loadedModules: ['app'],
            asyncLoader: require,
            modules: [{
                name: 'view1',
                files: ['partials/view1/view1.js']
            }, {
                name: 'record',
                files: ['partials/record/record.js']
            }]
        });
        //ÀÁ¼ÓÔØ³õÊ¼»¯Íê±Ï
        $urlRouterProvider.otherwise('/record');
        $stateProvider
            .state('index', {
                url: '/index'
            })
            .state('view1', {
                url: '/view1?{userid:5}',
                views: {
                    'v1': {
                        templateUrl: 'partials/view1/partial1.html',
                        //  controller: 'view1Part'
                    }
                },
                resolve: {
                    loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                        // you can lazy load files for an existing module
                        return $ocLazyLoad.load('view1');
                    }]
                }

            })
            .state('view1.detail', {
                url: '/detail?{detail:[0-8888]}',
                templateUrl: 'partials/partial1-detail.html'

            })

        .state('view2', {
            url: '/view2',
            views: {
                'v2': {
                    templateUrl: 'partials/partial2.html',

                }
            }

        })

        //formal coding begin

        .state('recod', {
            url: '/record?',
            views: {
                'head': {
                    templateUrl: 'partials/head.html',

                },
                'bottom': {
                    templateUrl: 'partials/bottom.html',

                },
                'body': {
                    templateUrl: 'partials/record/record.html',

                }
            },
            resolve: {
                    loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
                        // you can lazy load files for an existing module
                        return $ocLazyLoad.load('record');
                    }]
                }

        })


    }])
});
