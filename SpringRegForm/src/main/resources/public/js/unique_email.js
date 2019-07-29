var app = angular.module("uniqueEmail", []);

app.controller("uniqueEmailCtrl", function ($scope, $http) {
    $http({
        method: "GET",
        url: "/userDTO",
        headers: {"Content-Type": "application/json"}
    }).then(function (data) {
        let param = document.getElementById("InputEmail");
        param.setAttribute("class", "form-control is-invalid");
        param.value = data.data.email;
    });
});