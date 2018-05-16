var myApp = angular.module('myApp', []);

myApp.controller('ShowRecipesController', function($scope, $http) {

        $http.get('http://localhost:8080//recipes')
            .then(function (response) {
            $scope.response = response.data;
        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });
});

myApp.controller('ShowRecipesTypeController', function($scope, $http) {

    $http.get('http://localhost:8080//recipes/{type}')
        .then(function (response) {
            $scope.response = response.data;
        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });
});
