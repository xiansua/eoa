<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">商品名称</th>
					<th scope="col">商品编号</th>
					<th scope="col">商品价格</th>
					<th scope="col">商品库存</th>
					<th scope="col">商品上架状态</th>
					<th scope="col">商品简介</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty goodsList}">
					<c:forEach items="${goodsList}" var="goods" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${goods.goodsName}</td>
							<td>${goods.goodsNum}</td>
							<td>${goods.goodsPrice}</td>
							<td>${goods.goodsCount}</td>
							<td>${goods.goodsPutaway}</td>
							<td>${goods.goodsInfo}</td>
							<td><a class="btn btn-primary btn-sm" href="javascript:goupdate(${goods.rowId});">修改</a> 
							<!-- data-xxx H5以后允许自定义元素的属性 --> 
							<a class="btn btn-primary btn-sm" href="javascript:;" data-rowId="${goods.rowId}" id="deleteA">删除</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<%-- 引入分页 --%>
<%@ include file="/page.jsp" %>