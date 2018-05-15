var myApp = angular.module('myApp', []);

myApp.controller('LogInController', function($scope, $http) {

    $scope.logIn = function () {

        var Login = {
            login: $scope.login,
            password: $scope.password
        }

        var res = $http.post('http://localhost:8080/logIn', Login);

        res.then(function (data, status, headers, config) {
            $scope.message = data.data;
            console.log(data.data);
        }, function error(data, status, headers, config) {
            alert("failure message: "+JSON.stringify({data: data}))
        });

        var info = "Zalogowano użytkownika.";
        $scope.info = info;
        $scope.login = "";
        $scope.password = "";
    }

});