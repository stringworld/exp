/**
 * bootstraps angular onto the window.document node
 * NOTE: the ng-app attribute should not be on the index.html when using ng.bootstrap
 */
define([
    'require',
    'angular',
    'app',
    'routes',
    'jquery-bootstrap'
], function (require, angular) {
  


    require(['domReady!'], function (document) {
        angular.bootstrap(document, ['app']);
    });
});
