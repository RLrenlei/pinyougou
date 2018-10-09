app.controller('specificationController', function($scope,$controller,specificationService){
    $controller('baseController',{$scope:$scope});
    //查询全部列表
    $scope.findAll=function () {
        specificationService.findAll().success(
            function (response) {
                debugger;
                $scope.list=response;
            }
        );
    }
    $scope.searchEntity={};
    //查询结果
    $scope.search=function (page, rows) {
        specificationService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total;
                $scope.list=response.rows;
            }
        );
    }
    //新增选项行
    $scope.addTableRow=function () {
        $scope.entity.specificationOptionList.push({});
    }
    //批量选项行删除
    $scope.delTableRow=function(index) {
        $scope.entity.specificationOptionList.splice(index,1);
    }

    //保存
    $scope.save=function () {
        var object = null;//方法名称
        if($scope.entity.specification.id != null) {
            object = specificationService.update($scope.entity);//执行修改方法
        } else {
            object = specificationService.add($scope.entity);
        }
        object.success(
            function (response) {
                //debugger;
                if(response.success) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert(response.message);
                }
            }
        );
    }
    //修改时查询实体
    $scope.findOne=function(id) {
        specificationService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }
    //批量删除
    $scope.del=function(){
        specificationService.del($scope.selectIds).success(
            function (response) {
                if(response.success) {
                    $scope.reloadList();
                }
            }
        );
    }
});