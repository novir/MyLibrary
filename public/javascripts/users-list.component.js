angular.module('myLib', [])
    .component('usersList', {
        template:
            '<ul>' +
            '<li ng-repeat="user in $ctrl.users">' +
            '<span>{{user.login}}</span>' +
            '<p>{{user.password}}</p>' +
            '</li>' +
            '</ul>',
        controller: function ($http) {
            var self = this;
            $http.get('http://localhost:9000/users').then(function (response) {
                self.users = response.data;
            })
        }
    });
