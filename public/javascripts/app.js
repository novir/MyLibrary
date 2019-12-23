(function() {
    'use strict';
    angular.module('myLib', ['ngRoute', 'ngAnimate', 'ngSanitize', 'mgcrea.ngStrap']).config(routeConfig);
    function routeConfig($routeProvider) {
        $routeProvider
            .when('/users', {
                templateUrl: '/public/templates/users.html',
                controller: 'UsersController',
                controllerAs: 'vm'
            })
            .when('/users/:id', {
                templateUrl: '/public/templates/user.html',
                controller: 'UserController',
                controllerAs: 'vm'
            })
            .otherwise({
                redirectTo: '/home'
            });
    }
}());