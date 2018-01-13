angular.module('BrewIT', [])
    .controller('Recipe', function ($scope, $http) {
        $http.get('/recipes').then(function (response) {
            $scope.recipes = response.data;
        });
    });