var myApp = angular.module('myApp', []);

myApp.controller('LogInController', function($scope, $http) {

    $scope.logIn = function () {

        var login = {
            username: $scope.username,
            password: $scope.password
        }

        var res = $http.post('http://localhost:8080/logIn', login);

        res.then(function (data, status, headers, config) {
            $scope.message = data.data;
        }, function error(data, status, headers, config) {
            alert("failure message: "+JSON.stringify({data: data}))
        });

        $scope.login = "";
        $scope.password = "";

        // var sResult = $scope.sResult;
        //
        // var res2 = $http.post('http://localhost:8080/logInStatus', sResult);
        //
        // res2.then(function (data, status, headers, config) {
        //     $scope.response = data;
        //     console.log(data.data);
        //     console.log(data);
        // }, function error(data, status, headers, config) {
        //     alert("failure message: "+JSON.stringify({data: data}))
        // });

        //sprawdzanie wyniku zalogowania
        // $http.get('http://localhost:8080/logInStatus2').then(function (response) {
        //     $scope.response = response;
        //     console.log(response);
        // }, function error(response) {
        //     $scope.postResultMessage = "Error with status"+ response.statusText;
        // });

    }


});