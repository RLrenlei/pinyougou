//控制层
app.controller("indexController",function ($scope,loginService) {
    this.showLoginName=function () {
        loginService.showLoginName().success(
            function (response) {
                $scope.loginName = response.loginName;
            }
        );
    }
});