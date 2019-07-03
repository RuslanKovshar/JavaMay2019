var app = angular.module("users_form", []);

app.controller("UserCtrl", function ($scope, $http) {
    $scope.users = [];

    /*$http.get('/get_users').then(function(data) {*/
    $http({
        method: "GET",
        url: "/get_users",
        headers: {"Content-Type": "application/json"}
    }).then(function(data) {
        $scope.users = data.data.users;
    });
    /*$scope.users = data.data;*/
});
/*
})
;*/
