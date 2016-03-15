
angular.module("App").controller('listImageCtrl', function($scope, $http)
{
    $scope.sub = ""
    $scope.showListSubcategory = [];

    $scope.loadImage = function(message)
    {
        $scope.sub = message
    }

    var showSubcategory = function()
    {
        $scope.showListSubcategory.push('Different');
        $http.get("/getListSubcategory").success(function(responce)
        {
            for(var i=0; i<responce.length; i++)
            {
                $scope.showListSubcategory.push(responce[i]);
            }
        })
    }

    showSubcategory();


    $scope.srcImage = ''
    $scope.getImage = function()
    {
        $http.get("/getImage").success(function(responce)
        {
            $scope.srcImage = responce;
        })
    }
})
