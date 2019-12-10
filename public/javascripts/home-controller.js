angular.module('myLib')
    .controller('HomeController', function HomeController($scope, $http) {
        var self = this;
        $http.get('http://localhost:9000/users').then(function (response) {
            self.users = response.data;
        });
        $scope.addUser = function (user) {
            let userData = JSON.stringify(user);
            $http.post('http://localhost:9000/users', userData);
        };
        $scope.showNewRow = function () {
            $scope.checked = true;
        }
    });
