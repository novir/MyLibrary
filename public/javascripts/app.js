(function() {
    'use strict';
    angular.module('myLib', ['ngRoute', 'ngAnimate', 'ngSanitize', 'mgcrea.ngStrap']).config(routeConfig);
    function routeConfig($routeProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: '/public/templates/users.html',
                controller: 'UsersController',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/home'
            });
    }
}());