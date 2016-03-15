/**
 * Created by user on 01.02.16.
 */

angular.module("App").controller('categoryBodyCtrl', function($scope, $http, listDataProductServices){

    $scope.categoryList = '';
    $scope.subCategoryList = '';

    $scope.getSubcategory = function(category)
    {
        $scope.subCategoryList = '';
        var params = {
            category:category
        }

        $http.get('/getSubCategoryList', {params:params}).success(function(responce){
            $scope.subCategoryList = responce;
        })
    }

    var getCategory = function(){
        $http.get('/getCategoryList').success(function (responce)
        {
            $scope.categoryList = responce;
        })
    }
    getCategory();

    $scope.listProduct = function(subcategory)
    {
        var params = {
            subcategory:subcategory
        }
        setColorcategoryTitle();
        $http.get("/getFieldProduct", {params:params}).success(function(responce)
        {
            var array =[]
            for(var i =0; i<responce.length; i++)
            {
                if(responce[i].nameSubcategory == subcategory)
                {
                    array.push(responce[i])
                }
            }
            listDataProductServices.dataProductWrite(array);
        })
    }

    var setColorcategoryTitle = function()
    {
        document.getElementById('categoryTitle').style.color = '#C4C4C4'
    }
})