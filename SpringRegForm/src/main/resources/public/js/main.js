var app = angular.module("registrationForm",[]);

app.controller("AppCtrl",function ($scope, $http) {
    $scope.auth = {};
    $scope.sendForm = function(auth){
        $http({
            method: "POST",
            url: "/registration",
            data: $.param(auth),
            headers: { "Content-Type" : "application/x-www-form-urlencoded" }
        }).then(
            function(data) {
                window.alert("Доступ разрешен");
            },
            function(error) {
                $http({
                    method: "GET",
                    url: "/userDTO",
                    headers: {"Content-Type": "application/json"}
                }).then(function(data) {
                    let param = document.getElementById("InputEmail");
                    param.setAttribute("class","form-control is-invalid");
                    param.value = data.data.email;
                });
                window.alert("Доступ запрещен");
            }
        );
    }
});