var myApp = angular.module('myApp', []);

myApp.controller('LogInController', function($scope, $http) {

    $scope.logIn = function () {

        var User = {
            login: $scope.login,
            password: $scope.password
        }

        var res = $http.post('http://localhost:8080/logIn', User);

        res.then(function (data, status, headers, config) {
            $scope.message = data.data;
            console.log(data.data);
        }, function error(data, status, headers, config) {
            alert("failure message: "+JSON.stringify({data: data}))
        });

        $scope.login = "";
        $scope.password = "";

        //sprawdzanie wyniku zalogowania
        // $http.get('http://localhost:8080/logInStatus').then(function (response) {
        //     $scope.response = response;
        //     console.log(response);
        // }, function error(response) {
        //     $scope.postResultMessage = "Error with status"+ response.statusText;
        // });

    }
});