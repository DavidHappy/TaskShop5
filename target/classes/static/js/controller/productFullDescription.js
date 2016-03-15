
app.controller('productFullDescriptionCtrl', function($scope, $http, $stateParams, listDataProductServices, getUserConnectedServices)
{
    $scope.subcategory = $stateParams.subcategory;
    $scope.id = $stateParams.id;

    $scope.user = '';
    $scope.product = [];
    $scope.listParam = {}
    $scope.countGoods = 1

    $scope.phone = ''
    $scope.priceAll = ''

    $scope.userInfo = function()
    {
        $scope.user = getUserConnectedServices.readUserInfo().id;
        return getUserConnectedServices.readUserInfo();
    }

    var getProduct = function()
    {
        for(var i = 0; i < listDataProductServices.dataProductRead().length; i++)
        {
            if($stateParams.id == listDataProductServices.dataProductRead()[i].id)
            {
                $scope.product = listDataProductServices.dataProductRead()[i];
                for (var key in listDataProductServices.dataProductRead()[i])
                {
                    if(key !== 'id' && key != 'nameSubcategory' && key != 'idName' && key != 'image' && key != '$$hashKey')
                    {
                        $scope.listParam[key] = listDataProductServices.dataProductRead()[i][key];
                    }
                }
            }
        }
    }
    getProduct();

    $scope.getNameParam = function(message)
    {
        for(var i = 0; i < Object.keys($scope.listParam).length; i++)
        {
            for (var item in $scope.listParam)
            {
                if($scope.listParam[item] == message)
                {
                    return item
                }
            }
        }
    }

    $scope.getName=function()
    {
        toastr.info("Name product")
    }

    $scope.getConnected = function()
    {
        if(getUserConnectedServices.getConnectedUser())
        {
            return true;
        }
        else if(getUserConnectedServices.getConnectedAdmin())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    $scope.getClickBasket = function()
    {
        if(getUserConnectedServices.getConnectedUser()== false && getUserConnectedServices.getConnectedAdmin()==false)
        {
            toastr.info("Enter username and password")
        }
        else
        {
            if(getUserConnectedServices.readUserInfo().login == undefined)
            {
                var params = {
                    login:getUserConnectedServices.readLoginUser(),
                    password: getUserConnectedServices.readPasswordUser()
                }
                $http.get('/search_user', {params:params}).success(function(responce)
                {
                    getUserConnectedServices.writeUserInfo(responce)
                })
            }
        }
    }

    $scope.addCount = function()
    {
        if($scope.countGoods < 999)
        {
            $scope.countGoods++;
        }
    }

    $scope.minusCount = function()
    {
        if($scope.countGoods > 1)
        {
            $scope.countGoods--;
        }
    }

    $scope.priceBuy = function(count, price)
    {
        $scope.priceAll = count*price
        return count * price;
    }

    $scope.buyOrder = function()
    {
        var params = {
            phone:$scope.phone,
            count:$scope.countGoods,
            price:$scope.priceAll,
            sold:false,
            idProduct:$scope.id,
            subcategory:$scope.subcategory,
            user:$scope.user
        }
        $http.get("/order", {params:params}).success(function(responce)
        {
            toastr.info(responce);
        })
    }

})
