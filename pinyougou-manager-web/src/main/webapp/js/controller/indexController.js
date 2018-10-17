app.controller("indexController",function($scope,loginService){
   //控制器继承
   $scope.showLoginName=function () {
       loginService.loginName().success(
           function (response) {
               $scope.loginName = response.loginName;
           }
       );
   }

});