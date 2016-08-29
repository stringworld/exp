angular.module("view1", [])
    .service('testService', ['$http', '$q', function ($http, $q) {
        this.testList = function () {
            var deferred = $q.defer();
            $http.get('../../data/list.json').success(function (data) {
                deferred.resolve(data);
            });
            return deferred.promise;
        }

    }])

    .directive('directiveTest', ['testService', function (testService) {
        var a = testService.testList();
        a.then(function (data) {
            var dataList = data;
            console.log(dataList);
        })
        return {
            restrict: 'ECAM',
            template: '<ul class="jqTest"><li ng-repeat="item in dataList" ng-init="updateList($last)"><i>{{$index + 1}}</i><em>{{item.name}}</em></li></ul>',
            replace: true,
            link: function (scope, element, attr) {
                alert('link success')
                scope.updateList = function (bool) {
                    if (bool) {
                        console.log('number=' + $('.jqTest li').length);

                    }
                }
            }
        };
    }])
    .controller('view1Part', ['$scope', '$stateParams', '$ocLazyLoad', 'testService', function ($scope, $stateParams, $ocLazyLoad, testService) {
        var a = testService.testList();
        a.then(function (data) {
            $scope.dataList = data;
            console.log($scope.dataList);
            // alert($);
            // console.log($('.liststyle li').length)
        })
        // console.log($('.liststyle li').length)
        // alert($stateParams.userid);
        $scope.stateDtail = 5;

    }]);

