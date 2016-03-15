/**
 * Created by user on 05.12.15.
 */
app.controller('contactCtrl', function($scope){
    $scope.contactPage = function(){
        $location.path("/contact");
    }
})