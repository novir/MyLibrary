angular.module('myLib')
    .controller('HomeController', function HomeController($http, $window) {
        const vm = this;

        vm.listUsers = function () {
            $http.get('http://localhost:9000/users').then(function (response) {
                vm.users = response.data;
            });
        };

        vm.addUser = function (user) {
            let userData = JSON.stringify(user);
            $http.post('http://localhost:9000/users', userData);
            vm.listUsers();
        };

        vm.updateUser = function (user) {
            let id = user.id;
            let userData = JSON.stringify(user);
            $http.post('http://localhost:9000/users/' + id, userData);
            vm.listUsers();
        };

        vm.removeUser = function (user) {
            let id = user.id;
            $http.delete('http://localhost:9000/users/' + id);
            vm.listUsers();
        };

        vm.showExtraRow = function () {
            vm.extraRowPresent = true;
        };

        vm.hideExtraRow = function () {
            vm.extraRowPresent = false;
        };

        vm.listUsers();
    });
