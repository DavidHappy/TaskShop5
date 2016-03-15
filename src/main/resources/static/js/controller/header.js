
angular.module("App").controller('headerCtrl', function($scope, $http, getUserConnectedServices, listDataProductServices){

    $scope.searchProduct = ''

    $scope.getIsAdmin=function()
    {
        return getUserConnectedServices.getConnectedAdmin();
    }

    $scope.getGoodsAtName = function()
    {
        if($scope.searchProduct=='')
        {
            toastr.warning("Enter the name of the product")
            return
        }
        var params = {
            search: $scope.searchProduct
        }
        $http.get("/getProductAtName" , {params:params}).success(function(responce)
        {
            listDataProductServices.dataSearchProductWrite(responce);
            console.log(responce)
        })
    }
})
