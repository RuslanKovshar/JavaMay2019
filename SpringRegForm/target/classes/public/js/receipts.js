var app = angular.module("receipts_form", []);

app.controller("ReceiptsCtrl", function ($scope, $http, $sce) {
    $scope.receipts = [];

    $http({
        method: "GET",
        url: "/main/get_receipts",
        headers: {"Content-Type": "application/json"}
    }).then(function(data) {
        console.log(data.data);
        $scope.receipts = data.data.receipts;
    });

    $scope.getIframeSrc = function (Id) {
        return '/main/save/' + Id;
    };
});
