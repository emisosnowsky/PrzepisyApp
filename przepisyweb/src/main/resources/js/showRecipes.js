var myApp = angular.module('myApp', []);

myApp.controller('ShowRecipesController', function($scope, $http) {

        $http.get('http://localhost:8080//recipes')
            .then(function (response) {
            $scope.response = response.data;
        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });
});



// myApp.controller('ShowRecipesTypeController', function($scope, $http) {
//
//     var type = '${type}}';
//     console.log(type);
//     $http.get('http://localhost:8080//recipes/{{type}}')
//         .then(function (response) {
//             $scope.response = response.data;
//             console.log(response);
//             console.log(type);
//
//         }, function error(response) {
//             $scope.postResultMessage = "Error with status"+ response.statusText;
//         });
// });

myApp.controller('SniadanieController', function($scope, $http) {

    var type = '${type}}';
    console.log(type);
    $http.get('http://localhost:8080//Sniadanie')
        .then(function (response) {
            $scope.response = response.data;
            console.log(response);
            console.log(type);

        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });
});

myApp.controller('ObiadController', function($scope, $http) {

    var type = '${type}}';
    console.log(type);
    $http.get('http://localhost:8080//Obiad')
        .then(function (response) {
            $scope.response = response.data;
            console.log(response);
            console.log(type);

        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });
});

myApp.controller('KolacjaController', function($scope, $http) {

    var type = '${type}}';
    console.log(type);
    $http.get('http://localhost:8080//Kolacja')
        .then(function (response) {
            $scope.response = response.data;
            console.log(response);
            console.log(type);

        }, function error(response) {
            $scope.postResultMessage = "Error with status"+ response.statusText;
        });
});