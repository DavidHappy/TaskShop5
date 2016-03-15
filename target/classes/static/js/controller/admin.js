
app.controller('adminCtrl', function($scope, $http) {
    $scope.nameButton = 'insert new goods'
    $scope.buttonCategory = 'insert new category'
    $scope.buttonSubCategory = 'insert new sub category'
    $scope.categoryList = [];
    $scope.subCategoryList = [];
    $scope.listField=[];

    $scope.newCategory = "";
    $scope.newSubCategory = "";
    $scope.getCategoryName = "Введите категорию";
    $scope.getCategoryNameProduct = "Введите категорию";
    $scope.getSubcategoryNameProduct = "Введите подкатегорию"

    $scope.image = '';

    $scope.getSubcategory = function(category)
    {
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

    $scope.insertCategory = function () {
        if ($scope.newCategory !== '') {
            var params =
            {
                newCategory: $scope.newCategory
            }
            $http.get('/insertCategory', {params: params}).success(function (resp)
            {
                $scope.newCategory = '';
                toastr.success(resp)
                getCategory();
            })
        }
        else {
            toastr.warning("Enter the category", "Warning")
        }
    }

    $scope.insertSubCategory = function()
    {
        if($scope.newSubCategory !='')
        {
            var params =
            {
                newSubCategory: $scope.newSubCategory,
                categoryName: $scope.getCategoryName
            }
            $http.get('/insertSubCategory', {params:params}).success(function(resp)
            {
                toastr.success(resp)
                $scope.newSubCategory='';
                $scope.getCategoryName = "Введите категорию";
            })
        }
    }

    $scope.getCategoryForSubCategory = function(message){
        $scope.getCategoryName = message
    }

    $scope.getCategoryForSubCategory2 = function(message){
        $scope.getCategoryNameProduct = message
    }

    $scope.setSubcategory = function(subcategory)
    {
        $scope.getSubcategoryNameProduct = subcategory
        $scope.getFieldProduct(subcategory)
        paramsNewProduct = {}
    }

    $scope.getFieldProduct = function(message)
    {
        var params = {
            subcategory:message
        }
        $http.get('/getFieldNameProduct', {params:params}).success(function(responce){
            $scope.listField=[];
            for(var key in responce)
            {
                if( key !== 'id' && key != 'nameSubcategory' && key != 'idName' && key != 'image')
                {
                    $scope.listField.push(key);
                }
            }
        })
    }

    var paramsNewProduct={}
    $scope.setDescriptionNewProduct = function(name, dataMes)
    {
        if(dataMes!=undefined)
        {
            paramsNewProduct[name] = dataMes;
        }
    }

    $scope.insertProductTest = function()
    {
        if(paramsNewProduct.image == null)
        {
            paramsNewProduct["image"] = '/image/image_default.jpg';
        }
        var price = parseInt(paramsNewProduct.price);

        if(isNaN(price))
        {
            alert('Enter price')
        }
        else
        {
            paramsNewProduct.price = price;
            paramsNewProduct["subcategoryInsert"] =$scope.getSubcategoryNameProduct
            $http.get("/insertNewProduct", {params:paramsNewProduct}).success(function(responce)
            {
                toastr.success(responce)
            })
        }
    }

    $scope.srcListImage = []
    $scope.getListImage = function()
    {
        var params ={subcategory:$scope.getSubcategoryNameProduct}
        $scope.srcListImage = [];
        $scope.imageTest = []
        $http.get("/getListImage", {params:params}).success(function(responce)
        {
            console.log(responce)

            for (var i = 0; i<responce.length; i++)
            {
                $scope.srcListImage.push(responce[i]);
            }
        })
    }

    $scope.image = '/image/image_default.jpg'
    $scope.setImageProduct = function(item)
    {
        paramsNewProduct.image = item;
        $scope.image = item
    }

})