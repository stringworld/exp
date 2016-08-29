define(['./module'], function (directives) {
    'use strict';
    directives.directive('appVersion', ['version', function (version) {
        return function (scope, elm) {
            elm.text(version);
        };
    }])
        //返回指令
        .directive('pageBack', ['$rootScope', '$timeout', function ($rootScope, $timeout) {
            return {
                restrict: 'ECAM',
                //template:'<a class="page-back-btn" href="{{us.state}}" ng-click="pageBack()"><<返回</a>',
                //replace:true,
                link: function (scope, element, attr) {
                    var a = document.createElement('a');
                    a.className = 'page-back-btn';
                    a.setAttribute('href', '#' + attr.uiSref);
                    a.setAttribute('ng-click', 'pageBack()');
                    a.innerHTML = element.html() || '<<返回';
                    element.parent().append(a);
                    element.remove();
                    return function (scope, element, attr) {
                        scope.pageBack = function () {
                            $rootScope.pageClass[attr.pageclass] = $rootScope.pageClassValue.prePage;
                            $timeout(function () {
                                $rootScope.pageClass[attr.pageclass] = $rootScope.pageClassValue.nextPage;
                            }, $rootScope.pageClassValue.time)
                        }
                    }
                }
            }
        }])
        //单页样式
        .directive('pageView', function () {
            return {
                restrict: 'ECAM',
                compile: function (element, attr) {
                    element[0].style.height = document.documentElement.clientHeight + 'px';
                }
            }
        })
});

