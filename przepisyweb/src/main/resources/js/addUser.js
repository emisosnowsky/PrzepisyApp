var myApp = angular.module('myApp', []);

myApp.controller('SignInController', function($scope, $http) {

    $scope.signIn = function () {

        var User = {
            firstname: $scope.firstname,
            lastname: $scope.lastname,
            login: $scope.login,
            email: $scope.email,
            password: $scope.password,
        }

        var res = $http.post('http://localhost:8080/addNewUser', User);

        res.then(function (data, status, headers, config) {
            $scope.message = data.data;
            console.log(data.data);
        }, function error(data, status, headers, config) {
            alert("failure message: "+JSON.stringify({data: data}))
        });

        var info = "Dodano użytkownika.";
        $scope.info = info;
        $scope.firstname = "";
        $scope.lastname = "";
        $scope.login = "";
        $scope.email = "";
        $scope.password = "";
    }

});