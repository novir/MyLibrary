angular.module('myLib')
    .controller('HomeController', function HomeController($http) {
        var self = this;
        $http.get('http://localhost:9000/users').then(function (response) {
            self.users = response.data;
        })
    });
