var app = angular.module("users_form", []);

app.controller("UserCtrl", function ($scope, $http) {
    $scope.users = [];

    $http({
        method: "GET",
        url: "/get_users",
        headers: {"Content-Type": "application/json"}
    }).then(function(data) {
        window.alert(data.data.users);
        $scope.users = data.data.users;
    });
});

