(function() {
    "use strict";
    angular.module("myLib", ["ngRoute"]).config(routeConfig);
    function routeConfig($routeProvider) {
        $routeProvider
            .when("/home", {
                templateUrl: "/public/templates/home.html",
                controller: "HomeController",
                controllerAs: "vm"
            })
            .when("/user/:id", {
                templateUrl: "/public/templates/user.html",
                controller: "UserController",
                controllerAs: "user"
            })
            .otherwise({
                redirectTo: "/home"
            });
    }
}());