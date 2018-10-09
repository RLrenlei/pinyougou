app.service('typeTemplateService',function($http){

    this.search=function (page, rows, searchEntity) {
        return $http.post("../typeTemplate/search.do?page="+page+"&rows="+rows,searchEntity);
    }
    //增加
    this.add=function (entity) {
        return $http.post("../typeTemplate/add.do",entity);
    }
    //修改
    this.update=function (entity) {
        return $http.post("../typeTemplate/update.do",entity);
    }
    //查询一个
    this.findOne=function (id) {
        return $http.post("../typeTemplate/findOne.do?id="+id);
    }
    //删除
    this.del=function (ids) {
        return new $http.get("../typeTemplate/delete.do?ids="+ids);
    }
});