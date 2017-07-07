var app = angular.module('getPieApp',['ngRoute']); //You can inject the dependencies within the square bracket

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl:"/view/angular/showCase.html",
            controller:"GetShowCase"
        });

}]);

app.controller('GetShowCase',function ($scope, $rootScope, $http){
    if ($rootScope.city == "undefined" || $rootScope.city == null) {
        ymaps.ready(function () {
            resolveCity($scope, $rootScope);
        });
    }
    $http({
        method: 'GET',
        url: '/getShowCaseList/' + $rootScope.city.id
    }).then(function (response){
        $scope.showCase = response.data;
    },function (error){

    });
});

app.controller('CityController', function($scope, $rootScope, $route) {

    $scope.chooseCity = function (cityInput) {
        if (cityInput == 77) {
            $rootScope.city = {
                id: 77,
                name: 'Москва'
            }
        }
        if (cityInput == 16) {
            $rootScope.city = {
                id: 16,
                name: 'Казань'
            }
        }
        $route.reload();
    };
});

function resolveCity($scope, $rootScope){
    var cityFilter = $rootScope.city;

    if (cityFilter == "undefined" || cityFilter == null) {
        var cityLocation = ymaps.geolocation.city;
        if (cityLocation == "Казань") {
            $rootScope.city = {
                id: 16,
                name: 'Казань'
            }
        } else {
            $rootScope.city = {
                id: 77,
                name: 'Москва'
            }
        }
    }
    $scope.cityInput = $rootScope.city.id;
}