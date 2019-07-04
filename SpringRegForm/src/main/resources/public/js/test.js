var app = angular.module("test", []);

app.controller("testCtrl", function ($scope, $http) {
    $http({
        method: "GET",
        url: "/userDTO",
        headers: {"Content-Type": "application/json"}
    }).then(function(data) {
        console.log(data);
        var param = document.getElementById("InputEmail");
        param.value = data.data.email;
        param.style.color = "red";
    });
});