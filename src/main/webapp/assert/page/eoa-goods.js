$(document).ready(function(){
	//对表单绑定校验。
	$('#form_goods_add_edit').validationEngine('attach', {
		onValidationComplete : function(form, status) {
			//如果校验通过
			if(status){
				//执行 新增或修改
				saveOrUpdate();
			}
		}
	});
	//查询所有的数据
	initTalbeData(1);
	//绑定新增按钮
	$('#button_add').off('click').on('click',function(){
		$('#form_goods_add_edit')[0].reset();
		$('#modal_goods').modal('show');
		//尝试清空所有的校验信息
		$('.formError').remove();
		//尝试移除data-skip这个属性（为了唯一性校验）
		$('#goodsName').removeAttr('data-skip');
		//$('#rowId').val('');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_goods_add_edit').submit();
	});
	
	//绑定 删除超连接事件 
	$('#dataTable_wrapper').off('click','#deleteA').on('click','#deleteA',function(){
		//this = <a href="javascript:;" data-rowId="2">删除</a>
		//console.log(this);
		var rowId = $(this).attr("data-rowId");
		//console.log(rowId);
		if(confirm("您确定要删除吗？")){
			$.ajax({
				url:'goods/doelete/'+rowId,
				success:function(result){
					if(result){
						initTalbeData(1);
					}
				}
			});
		}
	});
	
	//绑定搜索按钮
	$('#button_search').on('click',function(){
		//查询所有的数据
		initTalbeData(1);
	});
});
//执行 新增或修改
function saveOrUpdate(){
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断进行的是修改
		$.ajax({
			type:'post',
			url:'goods/doupdate',
			data:$('#form_goods_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_goods').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}else{//则判断执行的是新增
		$.ajax({
			type:'post',
			url:'goods/add',
			data:$('#form_goods_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_goods').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}
// go update
function goupdate(rowId){
	$.ajax({
		url:'goods/goupdate/'+rowId,
		dataType:'json',
		success:function(goods){
			//if(true) js false()
			if(goods){
				//将modal表单显示
				$('#modal_goods').modal('show');
				//尝试清空所有的校验信息
				$('.formError').remove();
				//$('#goodsName').val(goods.goodsName);
				var goodsName = goods.goodsName;
				//在需要进行唯一性校验的field里面增加 data-skip这个属性并赋值。
				$('#goodsName').val(goodsName).attr('data-skip',goodsName);
				$('#goodsKind').val(goods.goodsKind);
				$('#goodsInfo').val(goods.goodsInfo);
				$('#rowId').val(goods.rowId);
				$('#rowPass').val(goods.goodsPass);
				$('#action_info').html('修改');
			}
		}
	});
}

//init table data
 function initTalbeData(pageNo){
	 $.ajax({
		 type:'post',
		 url:'goods/find/'+pageNo,
		 data:$('#form_search').serialize(),
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
 }
 //响应分页
 function page_select(pageNo){
	 initTalbeData(pageNo);
 }
 //上一页
 function page_prev(){
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	//console.log(current_page);
	initTalbeData(current_page-1);
 }
 //下一页
 function page_next(){
	 var current_page = $('#ul_pagination').find('.active').find('span').text();
	 initTalbeData(parseInt(current_page)+1);
 }