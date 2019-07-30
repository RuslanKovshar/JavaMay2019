var app = angular.module("receipts_form", []);

app.controller("ReceiptsCtrl", function ($scope, $http) {
    $scope.receipts = [];

    $http({
        method: "GET",
        url: "/account/get_receipts",
        headers: {"Content-Type": "application/json"}
    }).then(function (data) {
        $scope.receipts = data.data.receipts;
    });

    $scope.getUrl = function (Id) {
        return '/account/save/' + Id;
    };
});
