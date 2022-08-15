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
    .when('/:filt',{
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
myApp.controller('mainController',['$scope','$http','$routeParams',function($scope,$http,$routeParams){
    $scope.newactivity='';
        $scope.serviceURL="todo/"
        $scope.filt= $routeParams.filt || 'all';

        $scope.getAll=function(){
            $http({
                method:'GET',
                url:$scope.serviceURL+$scope.filt,
                dataType: 'json'}).then(function successCallback(response) {
                $scope.activities=response.data;
            }, function errorCallback(response) {

            });
        }

        $scope.getAll();

        //method to update status
        $scope.changeStatus=function(id,name,status){
            $http({
                method:'PUT',
                url:$scope.serviceURL+'update',
                data:{id:id,
                      name:name,
                      status:status},
                dataType: 'json'}).then(function successCallback(response) {
                $scope.activities=response.data;
            }, function errorCallback(response) {
            });
        }

        //method to validate and add new activity
        $scope.validateadd=function(){
            if($scope.newactivity!='' && $scope.newactivity!=undefined && $scope.newactivity.length>0){
                $http({
                    method:'POST',
                    url:$scope.serviceURL,
                    data:{name:$scope.newactivity},
                    dataType: 'json'}).then(function successCallback(response) {
                    $scope.newactivity='';
                    $scope.activities=response.data;
                }, function errorCallback(response) {
                });
            }
        }

        //method to delete
        $scope.deleteactivity=function(activityId){
            $http({
                method:'DELETE',
                url:$scope.serviceURL+activityId})
                .then(function successCallback(response) {
                $scope.activities=response.data;
            }, function errorCallback(response) {
            });
        }
}]);