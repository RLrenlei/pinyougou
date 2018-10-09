app.controller("typeTemplateController",function($scope,$controller,typeTemplateService,brandService,specificationService){
   //控制器继承
   $controller('baseController',{$scope:$scope});
    $scope.searchEntity={};
    //查询结果
    $scope.search=function (page, rows) {
        typeTemplateService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.paginationConf.totalItems=response.total;
                $scope.list=response.rows;
            }
        );
    }
    $scope.addTableRow=function(){
        $scope.entity.customAttributeItems.push({});
    }
    $scope.delTableRow=function(index){
        $scope.entity.customAttributeItems.splice(index,1);
    }
    //定义品牌列表
    $scope.brandList={data:[]};
    //读取品牌列表
    $scope.findBrandList=function(){
        brandService.selectOptionList().success(
          function (response) {
              $scope.brandList={data:response};
          }
        );
    }
    //定义规格列表
    $scope.specificationList={data:[]};
    //读取规格列表
    $scope.findSpecificationList=function(){
        specificationService.selectSpecificationList().success(
            function (response) {
                $scope.specificationList={data:response};
            }
        );
    }
    //保存
    $scope.save=function () {
        //debugger;
        var object = null;
        if($scope.entity.id != null){
            //修改
            object = typeTemplateService.update($scope.entity);
        } else {
            //添加
            object = typeTemplateService.add($scope.entity);
        }
        object.success(
            function (response) {
                if(response.success){
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }
    //修改时查询实体
    $scope.findOne=function (id) {
        debugger;
        typeTemplateService.findOne(id).success(
            function (response) {
                $scope.entity = response;
                $scope.entity.brandIds = JSON.parse($scope.entity.brandIds);//转换品牌列表
                $scope.entity.specIds = JSON.parse($scope.entity.specIds);//转换规格属性
                $scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);//转换拓展属性
            }
        );
    }
    //批量删除
    $scope.del=function(){
        typeTemplateService.del($scope.selectIds).success(
            function (response) {
                if(response.success) {
                    $scope.reloadList();
                }
            }
        );
    }
});