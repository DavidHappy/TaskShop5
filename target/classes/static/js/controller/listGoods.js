/**
 * Created by user on 01.02.16.
 */
angular.module("App").controller('listGoodsCtrl', function($scope, $http, listDataProductServices){

    $scope.getGoods = function()
    {
        var idKey = []
        var dataArray = listDataProductServices.dataProductRead();
        for(var i = 0; i<dataArray.length; i++)
        {
            idKey.push(parseInt(dataArray[i].id))
        }
        idKey.sort(function(a,b){return a-b;})

        var str= []
        for(var i=0; i<dataArray.length; i++)
        {
            str.push(parseInt(dataArray[i].id))
        }

        for(var i = 1; i<idKey.length; i++)
        {
            if(idKey[i]===idKey[i-1])
            {
                var numIndex = str.indexOf(idKey[i])
                dataArray.splice(numIndex,1)
            }
        }
        var nameSub = []
        for(var i = 0; i < dataArray.length; i++)
        {
            nameSub.push(dataArray[i].nameSubcategory)
        }
        return dataArray;
    }
})
