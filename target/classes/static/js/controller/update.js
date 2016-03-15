/**
 * Created by user on 01.03.16.
 */
app.controller('updateCtrl', function($scope, $http)
{
    $scope.categoryList = []
    $scope.nameCategoryBtn = 'Category'
    $scope.subcategoryList = []
    $scope.nameSubcategoryBtn = 'Subcategory'
    $scope.listGoods = []
    $scope.updateTrue = 'false'

    $scope.isUpdateValue =  [];

    var getCategory = function(){
        $http.get('/getCategoryList').success(function (responce)
        {
            $scope.categoryList = responce;
        })
    }
    getCategory();

    $scope.setNameCategoryBtn = function(name)
    {
        $scope.nameCategoryBtn = name;
        getSubcategory(name)
    }

    $scope.setNameSubcategoryBtn = function(name)
    {
        $scope.nameSubcategoryBtn = name;
        getProductSubcategory(name)

    }

    var getSubcategory = function(category)
    {
        var params = {
            category:category
        }
        $http.get('/getSubCategoryList', {params:params}).success(function(responce)
        {
            $scope.subcategoryList = responce
        })
    }


    var getProductSubcategory = function(subcategory)
    {
        var params = {
            subcategory:subcategory
        }

        $http.get('/getProductAtSubcategory', {params:params}).success(function(responce)
        {
            $scope.listGoods = []
            $scope.listGoods = responce
            $scope.isUpdateValue = []
            for(var i = 0; i<responce.length; i++)
            {
                var obj = {}
                for (var key in responce[i])
                {
                    obj[key] = 'false'
                }
                $scope.isUpdateValue.push(obj)
            }
        })

    }

    $scope.isUpdate = function(title, index)
    {
        $scope.isUpdateValue[index][title] = 'true'

    }

    $scope.cancelUpdate = function(title, index)
    {
        $scope.isUpdateValue[index][title] = 'false'
    }

    $scope.update = function(title, index)
    {
        var params = {
            subcategory: $scope.nameSubcategoryBtn,
            nameParam: title,
            value: $scope.listGoods[index][title],
            id:$scope.listGoods[index].id
        }

        $http.get("/updateValues", {params:params}).success(function(responce){
            toastr.info(responce)
        })
        $scope.isUpdateValue[index][title] = 'false'
        console.log($scope.listGoods[index])
    }
})
