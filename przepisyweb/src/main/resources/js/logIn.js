var myApp = angular.module('myApp', []);

myApp.controller('LogInController', function($scope, $http) {

    $scope.signIn = function () {

        $http.get('http://localhost:8080/logIn').then(function (response) {
            $scope.response = response.data;
            console.log(renponse);
            console.log(data);
        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });

        var info = "Zalogowano użytkownika.";
        $scope.info = info;
        $scope.login = "";
        $scope.password = "";
    }

});