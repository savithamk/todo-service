//Modules
var myApp=angular.module('myApp',['ngRoute']);

//Routes
myApp.config(function($routeProvider,$locationProvider){
    $locationProvider.hashPrefix('');
    $routeProvider
    .when('/',{
        templateUrl:'pages/main.html',
        controller:'mainController'
    })
});

myApp.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }
]);


//Controllers
myApp.controller('mainController',['$scope','$http',function($scope,httpService){
    
}]);