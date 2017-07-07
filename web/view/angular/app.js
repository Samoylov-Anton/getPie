var app = angular.module('getPieApp',['ngRoute']); //You can inject the dependencies within the square bracket

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl:"/view/angular/showCase.html",
            controller:"GetShowCase"
        });

}]);

app.controller('GetShowCase',function ($scope, $http){
    ymaps.ready(function(){
        resolveCity($scope);
    });
    $http({
        method: 'GET',
        url: '/getShowCaseList/' + $scope.city.id
    }).then(function (response){
        $scope.showCase = response.data;
    },function (error){

    });
});

app.controller('CityController', function($scope,$route) {

    $scope.chooseCity = function (cityInput) {
        if (cityInput == 77) {
            $scope.city = {
                id: 77,
                name: 'Москва'
            }
        }
        if (cityInput == 16) {
            $scope.city = {
                id: 16,
                name: 'Казань'
            }
        }
        $route.reload();
    };
});

function resolveCity($scope){
    var cityFilter = $scope.city;

    if (cityFilter == "undefined" || cityFilter == null) {
        var cityLocation = ymaps.geolocation.city;
        if (cityLocation == "Казань") {
            $scope.city = {
                id: 16,
                name: 'Казань'
            }
        } else {
            $scope.city = {
                id: 77,
                name: 'Москва'
            }
        }
    }
    $scope.cityInput = $scope.city.id;
}