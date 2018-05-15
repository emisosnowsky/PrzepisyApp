var myApp = angular.module('myApp', []);

myApp.controller('AddRecipeController', function($scope, $http) {

    $scope.addRecipe = function () {

        var Recipe = {
            title: $scope.title,
            description: $scope.description,
            image: $scope.image
        }

        var res = $http.post('http://localhost:8080/addNewRecipe', Recipe);

        res.then(function (data, status, headers, config) {
            $scope.message = data.data;
            console.log(data.data);
        }, function error(data, status, headers, config) {
            alert("failure message: "+JSON.stringify({data: data}))
        });

        var info = "Dodano przepis.";

        $scope.info = info;
        $scope.title = "";
        $scope.description = "";
        $scope.image = "";
    }

});