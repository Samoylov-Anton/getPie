var app = angular.module('getPieApp',['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl:"/view/angular/showCase.html",
            controller:"GetShowCase"
        })
        .when('/profile', {
            templateUrl:"/view/angular/profile.html",
            controller:"GetProfile"
        });

}]);

app.controller('GetShowCase',function ($scope, $rootScope, $http){
    if ($rootScope.city == "undefined" || $rootScope.city == null) {
        ymaps.ready(function () {
            resolveCity($scope, $rootScope);
            getShowCase($scope, $rootScope, $http);
        });
    } else {
        getShowCase($scope, $rootScope, $http);
    }
});

app.controller('GetProfile',function ($scope,  $http){
    $http({
        method: 'GET',
        url: '/profile'
    }).then(function (response){
        $scope.profile = response.data;
    },function (error){

    });
});

app.controller('TabController', ['$scope', function($scope) {
    $scope.tab = 1;

    $scope.setTab = function(newTab){
        $scope.tab = newTab;
    };

    $scope.isSet = function(tabNum){
        return $scope.tab === tabNum;
    };
}]);

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
    $rootScope.cityInput = $rootScope.city.id;
}

function getShowCase($scope, $rootScope, $http){
    $http({
        method: 'GET',
        url: '/getShowCaseList/' + $rootScope.city.id
    }).then(function (response){
        $scope.showCase = response.data;
    },function (error){

    });
}