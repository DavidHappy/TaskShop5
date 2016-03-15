
app.controller('registrationCtrl', function($scope, $http)
{
    $scope.regLogin = '';
    $scope.regPassword  = '';
    $scope.regName='';
    $scope.regSubname='';
    $scope.regMail='';
    $scope.regAge = '';


    $scope.registration_ok = function()
    {
        var infoUser = {
            login:$scope.regLogin,
            password:$scope.regPassword,
            name: $scope.regName,
            subname: $scope.regSubname,
            email: $scope.regMail,
            age:  $scope.regAge
        }
        $http.get('/registration_user', {params:infoUser}).success(function(responce)
        {
            if(responce=='Login busy')
            {
                toastr.warning(responce)
            }
            else
            {
                toastr.success(responce)
            }
            clean();
        })
    }

    $scope.registration_cancel = function(){
        clean();
    }

    function clean(){
        $scope.regLogin = '';
        $scope.regPassword  = '';
        $scope.regName='';
        $scope.regSubname='';
        $scope.regMail='';
        $scope.regAge = '';
    }
})