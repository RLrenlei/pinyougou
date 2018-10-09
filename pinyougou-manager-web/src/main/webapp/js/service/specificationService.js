app.service('specificationService', function($http){
    this.findAll=function () {
        return $http.get('../specification/findAll.do');
    }
    this.search=function (page, rows, searchEntity) {
        return $http.post("../specification/search.do?page="+page+"&rows="+rows,searchEntity);
    }
    //增加
    this.add=function (entity) {
        return $http.post("../specification/add.do",entity);
    }
    //修改
    this.update=function (entity) {
        return $http.post("../specification/update.do",entity);
    }
    //修改时查询
    this.findOne=function(id) {
        return $http.get("../specification/findOne.do?id="+id);
    }
    //删除
    this.del=function (ids) {
        return new $http.get("../specification/delete.do?ids="+ids);
    }
    //下拉列表数据
    this.selectSpecificationList=function(){
        return $http.get('../specification/selectSpecificationList.do');
    }
});