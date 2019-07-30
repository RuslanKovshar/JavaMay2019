var app = angular.module("users_form", []);

app.controller("UserCtrl", function ($scope, $http) {
    $scope.users = [];

    $http({
        method: "GET",
        url: "/get_users",
        headers: {"Content-Type": "application/json"}
    }).then(function (data) {
        $scope.users = data.data.users;
    });

    $scope.getUrl = function (id) {
        return '/account/users/' + id + '/account_history';
    };
});

