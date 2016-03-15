/**
 * Created by Dev on 04.03.2016.
 */
angular.module("App").controller('listGoodsSearchAtNameCtrl', function($scope, $http, listDataProductServices)
{
    $scope.getGoods = function()
    {
        return listDataProductServices.dataSearchProductRead();
    }
})
