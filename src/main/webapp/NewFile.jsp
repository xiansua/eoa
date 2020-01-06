<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 商品目录管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">新增</button>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div>
           <ul id="treeDemo" class="ztree"></ul>
        </div>
			</div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_goods" tabindex="-1" goods="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" goods="document">
	</div>
</div>
<script>
var settingss = {
        data: {
          simpleData: {
            enable: true,  //true 、 false 分别表示 使用 、 不使用 简单数据模式
            idKey: "id",  //节点数据中保存唯一标识的属性名称
            pIdKey: "parentId",    //节点数据中保存其父节点唯一标识的属性名称  
            rootPId: -1  //用于修正根节点父节点数据，即 pIdKey 指定的属性值
                      },
          key: {
            name: "menuName"  //zTree 节点数据保存节点名称的属性名称  默认值："name"
               }
              },
        check:{
            enable:true,  //true 、 false 分别表示 显示 、不显示 复选框或单选框
            nocheckInherit:true  //当父节点设置 nocheck = true 时，设置子节点是否自动继承 nocheck = true 
              }

};

	//数据
	var zNodes = [
	   //注意，数据中的 menuName 必须与 settingss 中key 中定义的name一致，否则找不到
	   {menuName:"父节点1", open:true, children:[
	       {menuName:"子节点1"}, {menuName:"子节点2"}]},
	   {menuName:"父节点2", open:true, children:[
	       {menuName:"子节点3"}, {menuName:"子节点4"}]}
	   ];
			
	zTreeObj = $.fn.zTree.init($("#treeDemo"), settingss, zNodes); //初始化树
	zTreeObj.expandAll(true);    //true 节点全部展开、false节点收缩

</script>
<script src="assert/page/eoa-goods.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<link rel="stylesheet" href="ztree/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css" />