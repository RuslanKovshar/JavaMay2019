var app = angular.module("receiptsHistory_form", []);

app.controller("ReceiptsHistoryCtrl", function ($scope, $http) {
    $scope.payedReceipts = [];

    $scope.init = function (url) {
        $http({
            method: "GET",
            url: url,
            headers: {"Content-Type": "application/json"}
        }).then(function (data) {
            console.log(data.data);
            $scope.payedReceipts = data.data;
        });
    };
});