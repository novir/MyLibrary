angular.module('myLib')
    .controller('UsersController', function UsersController($http, $location, $modal) {
        const vm = this;
        vm.listUsers = function () {
            $http.get('http://localhost:9000/users').then(function (response) {
                vm.users = response.data;
                vm.SortOrder = '+login';
            });
        };
        vm.addUser = function (user) {
            let userData = JSON.stringify(user);
            $http.post('http://localhost:9000/users', userData);
            vm.listUsers();
        };
        vm.editUser = function (user) {
            $modal({
                templateUrl: '/public/templates/user.html',
                controller: 'UserController',
                controllerAs: 'vm',
                resolve: {
                    id: function () {
                        return user.id;
                    },
                }
            });
            // $location.path('/users/' + id);
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
