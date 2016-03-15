/**
 * Created by Dev on 28.02.2016.
 */
app.controller('orderCtrl', function($scope, $http, historySalesServices)
{
    $scope.infoProduct = ''
    $scope.allOrder = ''
    $scope.countOrder = 0
    var countOrder = function()
    {
        $http.get("/orders").success(function(responce)
        {
            $scope.allOrder = responce;
            $scope.countOrder = responce.length

            console.log(responce)
        })
    }

    countOrder()

    $scope.getInfoProduct = function(idProduct, index)
    {
        var params = {
            idProduct: $scope.allOrder[index].nameProduct,
            subcategory:$scope.allOrder[index].subcategory
        }
        $http.get("/getProductAtId", {params:params}).success(function(responce){
            $scope.infoProduct = responce
            console.log(responce)
        })

    }

    $scope.soldTrue = function(index)
    {
        $scope.allOrder[index].sold = 'true'
        if($scope.countOrder > 0)
        {
            $scope.countOrder--
            if($scope.countOrder == 0)
            {
                document.getElementById('orderCount').style.backgroundColor = "gray"
            }
        }

        var params = {
            idOrder : $scope.allOrder[index].idUser
        }
        $http.get('/updateSold', {params:params}).success(function(res)
        {
            toastr.info(res, 'Update')

            $http.get("/getHistorySales").success(function(responce)
            {
                $scope.allSales = responce;
                historySalesServices.listSalesWrite(responce)
            })
        })
    }
})