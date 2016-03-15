app.controller('historySalesCtrl', function($scope, $http, historySalesServices)
{
    $scope.allSales = ''
    $scope.infoProduct=''

    var sales = function()
    {
        $http.get("/getHistorySales").success(function(responce)
        {
            $scope.allSales = responce;
            historySalesServices.listSalesWrite(responce)
        })
        console.log($scope.allSales)
    }

    sales()

    $scope.getInfoProduct = function(idProduct, index)
    {
        var params = {
            idProduct: $scope.allSales[index].nameProduct,
            subcategory:$scope.allSales[index].subcategory
        }
        $http.get("/getProductAtId", {params:params}).success(function(responce){
            $scope.infoProduct = responce
        })

    }

    $scope.getHistorySales = function()
    {
        return historySalesServices.listSalesRead();
    }

    $scope.sort = function(key)
    {
        $scope.sortKey = key;
        $scope.reverse= !$scope.reverse;
    }
})
