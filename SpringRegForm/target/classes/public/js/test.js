/*
document.addEventListener('DOMContentLoaded', function(){
    var password = document.getElementById("InputEmail");
    password.value = 11111111;
    password.style.color = "red";
});*/

var app = angular.module('MyApp', []);

app.controller("AppCtrl",function () {
    angular.element(document).ready(function () {
        window.alert("kek");
        //document.getElementById('msg').innerHTML = 'Hello';
    });
});

/*angular.module('MyApp', [])
    .controller('MyCtrl', [function() {
        angular.element(document).ready(function () {
            window.alert("kek");
            //document.getElementById('msg').innerHTML = 'Hello';
        });
    }]);*/
