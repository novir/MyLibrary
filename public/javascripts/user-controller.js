angular.module('myLib')
    .controller('UserController', function UserController($http, $window, $modal, id) {
        const vm = this;
        vm.showUser = function () {
            $http.get('http://localhost:9000/users/' + id).then(function (response) {
                vm.user = response.data;
            });
        };
        // vm.addUser = function (user) {
        //     let userData = JSON.stringify(user);
        //     $http.post('http://localhost:9000/users', userData);
        //     vm.showUser();
        // };
        vm.updateUser = function (user) {
            let id = user.id;
            let userData = JSON.stringify(user);
            $http.post('http://localhost:9000/users/' + id, userData)
                .then(function onSuccess(response) {
                        $window.alert("User data changed correctly.");
                    }, function onError(response) {
                        $window.alert("Error while user data change.");
                    }
                );
            vm.showUser();
        };
        // vm.removeUser = function (user) {
        //     let id = user.id;
        //     $http.delete('http://localhost:9000/users/' + id);
        //     vm.showUser();
        // };
        // vm.showExtraRow = function () {
        //     vm.extraRowPresent = true;
        // };
        // vm.hideExtraRow = function () {
        //     vm.extraRowPresent = false;
        // };
        vm.showUser();
    });
