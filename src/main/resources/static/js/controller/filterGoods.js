
angular.module("App").controller('filterGoodsCtrl', function($scope, $http, listDataProductServices){

    $scope.product = []
    $scope.arrayBrand = []
    $scope.arrayColor = []

    var getProduct =function()
     {
        $scope.product=''
        $scope.product = listDataProductServices.dataProductRead();
        return $scope.product;
    }

    getProduct();

    $scope.unique = function(arr)
    {
        var obj = {};
        if(arr.length > 0)
        {
            for (var i = 0; i < arr.length; i++)
            {
                var str = arr[i];
                obj[str] = true;
            }
        }
        return Object.keys(obj);
    }

    $scope.setArraylist = function(mes, name)
    {
        if(mes!==undefined)
        {
            switch(name) {
                case 'brand':
                    $scope.arrayBrand.push(mes);
                    break;
                case 'color':
                    $scope.arrayColor.push(mes);
                    break;
            }
        }
    }

    $scope.selectProduct = function(surname, mes)
    {
        var checkEvent = $("#" + mes).prop("checked");

        if(checkEvent == true)
        {
           // listDataProductServices.dataProductWithFilter(surname, mes)
            listDataProductServices.addFilter(surname, mes);
        }
        else
        {
            listDataProductServices.removeFilter(surname, mes)
        }
    }

})

