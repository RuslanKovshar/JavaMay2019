var app = angular.module("registrationForm", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.auth = {};
    $scope.sendForm = function (auth) {
        $http({
            method: "POST",
            url: "/registration",
            data: $.param(auth),
            headers: {"Content-Type": "application/x-www-form-urlencoded"}
        });
    }
});