
app.controller('loginPasswordCtrl', function($scope, $http, getUserConnectedServices)
{
    $scope.loginUser = '';
    $scope.passwordUser = '';

    $scope.searchUser = function()
    {
        var data = {
            login:$scope.loginUser,
            password:$scope.passwordUser
        }
        $http.get('/search_user', {params:data}).success(function(responce)
        {
            $scope.clearField();
            if(responce.login == 'admin' && responce.password=='admin')
            {
                toastr.success('Hello ' + responce.name, 'Admin')
                getUserConnectedServices.adminConnected(true)
                getUserConnectedServices.userConnected(true)
                getUserConnectedServices.writeUserInfo(responce)

                var cookie = 'connected' + "=" + encodeURIComponent('admin');
                var login = 'login' + "=" + encodeURIComponent(responce.login)
                var password = 'password' + "=" + encodeURIComponent(responce.password)
                document.cookie = cookie;
                document.cookie = login;
                document.cookie = password;
            }
            else if(responce.login)
            {
                getUserConnectedServices.userConnected(true)
                getUserConnectedServices.adminConnected(false)
                getUserConnectedServices.writeUserInfo(responce)

                toastr.success('Connected')

                var login = 'login' + "=" + encodeURIComponent(responce.login)
                var password = 'password' + "=" + encodeURIComponent(responce.password)
                var cookie = 'connected' + "=" + encodeURIComponent('user');

                document.cookie = cookie;
                document.cookie = login;
                document.cookie = password;
                return
            }
            else
            {
                getUserConnectedServices.userConnected(false)
                getUserConnectedServices.adminConnected(false)
                toastr.warning("Invalid username or password")
                return
            }
        })
    }


    $scope.clearField = function()
    {
        $scope.loginUser = '';
        $scope.passwordUser = '';
    }

})
