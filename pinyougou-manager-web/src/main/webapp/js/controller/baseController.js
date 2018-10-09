app.controller('baseController', function($scope){
    $scope.reloadList=function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        //$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    }
    $scope.selectIds=[];//选中的id集合
    //更新复选
    $scope.updateSelection = function($event, id) {
        //debugger;
        if($event.target.checked) {
            //如果被选中，则增加至数组
            $scope.selectIds.push(id);
        } else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    }
    //将json数据中某个属性提取出来用逗号分隔
    $scope.jsonToString=function (jsonString, key) {
        var json = JSON.parse(jsonString);//将json字符串转换成json对象
        var value="";
        for(var i=0; i<json.length; i++){
            if(i>0){
                value+=",";
            }
            value += json[i][key];
        }
        return value;
    }
});